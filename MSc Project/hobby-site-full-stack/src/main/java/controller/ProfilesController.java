package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import model.User;
import model.UserLogin;

@Controller
public class ProfilesController {
	
	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	@ResponseBody
	public String profiles() {
		Gson gson = new Gson();
		List<User> list = null;
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		if(session.getAttribute("authenticated") != null) {
			dao.UserDAO userDAO = new dao.UserDAO();
			list = userDAO.listUsers();
		} else {
			return "Incorrect Username";
		}
		return gson.toJson(list);
    }
}
