package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import dao.HobbyDAO;
import model.JsonRegisterForm;
import model.User;
import model.UserLogin;
import util.AuthenticatedSession;
import util.GetSession;

@Controller
public class UpdateProfileController {
	
	@RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView updateUser(@PathVariable(value="userId") final int userId) {
		Gson gson = new Gson();
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		ModelAndView loggedInModelAndView = new ModelAndView("/profiles/update-profile");
		if(session.getAttribute("authenticated") != null) {
			dao.UserDAO userDAO = new dao.UserDAO();
			User user = userDAO.getUser(userId);
			String jsonUser = gson.toJson(user);
			loggedInModelAndView.addObject("json", jsonUser);
		} else {
			return new ModelAndView("/profiles/test");
		}
		return loggedInModelAndView;
    }
	
	/*@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String registerPOST(WebRequest request, @RequestBody String requestBody) {
		GetSession session = new GetSession();
		Gson gson = new Gson();
		JsonRegisterForm registerJSONObj = gson.fromJson(requestBody, JsonRegisterForm.class);
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
			ex.printStackTrace();
			return "fail";
		}
    }*/
}
