package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.HobbyDAO;
import dao.UserDAO;
import dao.UserLoginDAO;
import model.JsonRegisterForm;
import model.User;
import model.UserLogin;
import util.GetSession;
import util.PBKDF2PasswordHash;

@Controller
public class Register {
	UserDAO userDAO = new UserDAO();
	UserLoginDAO userLoginDAO = new UserLoginDAO();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loginGet() {
		return "/profiles/register";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String loginGet(WebRequest request, @RequestBody String json) {
		System.out.println(json.toString());
		GetSession session = new GetSession();
		String gender = "";
		if(request.getParameter("male") != null) {
			gender = "male";
		} else {
			gender = "female";
		}
		User user = new User(request.getParameter("firstname"),
							 request.getParameter("lastname"),
							 gender,
							 request.getParameter("location"),
							 "test");
		UserLogin userLogin = new UserLogin(request.getParameter("username"),
											hashPassword(request.getParameter("password")));
		try {
			userLoginDAO.addUser(userLogin);
			int userID = userLoginDAO.getUser(request.getParameter("username")).getUser_id();
			user.setUsername(userID);
			userDAO.addUser(user);
			session.getSession(userLogin.getUsername());
			return "/profiles/profiles";
		} catch (Exception ex) {
			return "profiles/register";
		}
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public void registerPost(@RequestBody String json) {
		Gson gson = new Gson();
		model.JsonRegisterForm a = gson.fromJson(json, model.JsonRegisterForm.class);
		System.out.println("here");
		System.out.println(a.getLocation());
    }
	
	private String hashPassword(String password) {
		PBKDF2PasswordHash hashPwd = new PBKDF2PasswordHash();
		return hashPwd.hashPassword(password);
	}
	
	@RequestMapping(value = "/hobbies", method = RequestMethod.GET)
	@ResponseBody
	public String getHobbies() {
		HobbyDAO hobbyDAO = new HobbyDAO();
		Gson gson = new Gson();
		//System.out.println(hobbyDAO.getHobbyList());
		return gson.toJson(hobbyDAO.getHobbyList());
	}
}
