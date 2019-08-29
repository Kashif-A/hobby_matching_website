package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
	HobbyDAO hobbyDAO = new HobbyDAO();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loginGet() {
		return "/profiles/register";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String registerPOST(WebRequest request, @RequestBody String json) {
		GetSession session = new GetSession();
		Gson gson = new Gson();
		JsonRegisterForm registerJSONObj = gson.fromJson(json, JsonRegisterForm.class);
		User user = new User(
					registerJSONObj.getFname(),
					registerJSONObj.getLname(),
					registerJSONObj.getGender(),
					registerJSONObj.getLocation(),
					"profileImg"
				);
		String hashedPwd = hashPassword(registerJSONObj.getPassword());
		UserLogin userLogin = new UserLogin(registerJSONObj.getUname(), hashedPwd);
		try {
			userLoginDAO.addUser(userLogin);
			int userID = userLoginDAO.getUser(registerJSONObj.getUname()).getUser_id();
			user.setUsername(userID);
			userDAO.addUser(user);
			hobbyDAO.populateHobbiesLinkedToUser(registerJSONObj.getHobbies(), userID);
			session.getSession(userLogin.getUsername());
			return "success";
		} catch (Exception ex) {
			return "fail";
		}
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
		return gson.toJson(hobbyDAO.getHobbyList());
	}
}
