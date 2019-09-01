package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import dao.HobbyDAO;
import model.User;
import model.UserLogin;
import util.AuthenticatedSession;

@Controller
public class ProfilesController {
	
	// GET Requests to /profiles endpoint are handled by this method of the ProfilesController
	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	@ResponseBody // Indicates that the method returns raw response data
	public ModelAndView profiles() {
		Gson gson = new Gson();
		List<User> list = null; // Object to hold all user data once retrieved
		
		// Get current session to ensure user is logged in
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		
		// Select the JSP page to be returned
		ModelAndView loggedInModelAndView = new ModelAndView("/profiles/profiles");
		if(session.getAttribute("authenticated") != null) { // Ensure user is logged in
			dao.UserDAO userDAO = new dao.UserDAO();
			list = userDAO.listUsers(); // Get all users from database
			String jsonList = gson.toJson(list); // Transform retrieved users into JSON object
			loggedInModelAndView.addObject("json", jsonList); // Attach JSON object to the JSP page
		} else {
			return new ModelAndView("/profiles/error");
		}
		return loggedInModelAndView;
    }
	
	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getUser(@PathVariable(value="id") int id) {
		Gson gson = new Gson();
		User user = new User();
		HobbyDAO hobbyDAO = new HobbyDAO();
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		ModelAndView loggedInModelAndView = new ModelAndView("/profiles/individualprofile");
		if(session.getAttribute("authenticated") != null) {
			dao.UserDAO userDAO = new dao.UserDAO();
			user = userDAO.getUser(id);
			List<String> userHobbies = userDAO.getHobbies(user.getUser_id());
			user.setHobbies(userHobbies);
			AuthenticatedSession s = (AuthenticatedSession) session.getAttribute("authenticated");
			String jsonUser = gson.toJson(user);
			loggedInModelAndView.addObject("json", jsonUser);
		} else {
			return new ModelAndView("/");
		}
		return loggedInModelAndView;
    }
	
	@RequestMapping(value = "/sendmessage/*", method = RequestMethod.GET)
	public String home() {
		return "/profiles/message-user";
    }
}
