package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.User;

@Controller
public class ProfilesController {
	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public String profiles() {
		return "/profiles/test";
    }
	
	@RequestMapping(value = "/profilesJSON", method = RequestMethod.GET)
	@ResponseBody
	public String profilesJSON() {
		dao.UserDAO userDAO = new dao.UserDAO();
		List<User> list = userDAO.listUsers();
		Gson gson = new Gson();
		return gson.toJson(list);
    }
}
