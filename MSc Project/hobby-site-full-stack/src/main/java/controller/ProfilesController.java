package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;

@Controller
public class ProfilesController {
	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	@ResponseBody
	public String profiles() {
		dao.UserDAOImpl userDAO = new dao.UserDAOImpl();
		List<User> list = userDAO.listUsers();
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return "<h1>Profiles</h1>";
    }
}
