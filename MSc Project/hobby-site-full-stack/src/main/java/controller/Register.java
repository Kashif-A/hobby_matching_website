package controller;

import java.io.IOException;
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

import dao.UserDAO;
import dao.UserLoginDAO;
import model.User;
import model.UserLogin;
import util.GetSession;

@Controller
public class Register {
	UserDAO userDAO = new UserDAO();
	UserLoginDAO userLoginDAO = new UserLoginDAO();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loginGet() {
		return "/profiles/register";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String loginGet(WebRequest request) {
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
											request.getParameter("password"));
		System.out.println(user.toString());
		System.out.println(userLogin.toString());
		userLoginDAO.addUser(userLogin);
		int userID = userLoginDAO.getUser(request.getParameter("username")).getUser_id();
		user.setUsername(userID);
		userDAO.addUser(user);
		return "/profiles/register";
    }
}
