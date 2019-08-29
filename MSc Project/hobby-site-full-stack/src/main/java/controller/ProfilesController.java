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

import model.User;
import model.UserLogin;
import util.AuthenticatedSession;

@Controller
public class ProfilesController {
	
	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView profiles() {
		Gson gson = new Gson();
		List<User> list = null;
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		ModelAndView loggedInModelAndView = new ModelAndView("/profiles/profiles");
		if(session.getAttribute("authenticated") != null) {
			dao.UserDAO userDAO = new dao.UserDAO();
			list = userDAO.listUsers();
			AuthenticatedSession s = (AuthenticatedSession) session.getAttribute("authenticated");
			String jsonList = gson.toJson(list);
			loggedInModelAndView.addObject("json", jsonList);
		} else {
			return new ModelAndView("/profiles/test");
		}
		return loggedInModelAndView;
    }
	
	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getUser(@PathVariable(value="id") int id) {
		Gson gson = new Gson();
		User user = new User();
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		ModelAndView loggedInModelAndView = new ModelAndView("/profiles/individualprofile");
		if(session.getAttribute("authenticated") != null) {
			dao.UserDAO userDAO = new dao.UserDAO();
			user = userDAO.getUser(id);
			AuthenticatedSession s = (AuthenticatedSession) session.getAttribute("authenticated");
			String jsonUser = gson.toJson(user);
			loggedInModelAndView.addObject("json", jsonUser);
		} else {
			return new ModelAndView("/profiles/individualprofile");
		}
		return loggedInModelAndView;
    }
}
