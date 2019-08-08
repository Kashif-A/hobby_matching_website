package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.UserLogin;

@Controller
public class UserLoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String profilesJSON(@RequestBody UserLogin userFromRequestBody) {
		Gson gson = new Gson();
		dao.UserLoginDAO userDAO = new dao.UserLoginDAO();
		UserLogin userFromDB = userDAO.getUser(userFromRequestBody.getUsername());
		if(userFromDB != null) {
			if(userFromDB.getUsername().equals(userFromRequestBody.getUsername())) {
				System.out.println("matched");
			}
		} else {
			System.out.println("unmatched");
		}
		return gson.toJson(userFromDB);
    }
}
