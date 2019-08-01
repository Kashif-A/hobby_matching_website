package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dao.UserLoginDAO;
import dao.UserLoginImpl;
import model.UserLogin;

@Controller
public class LoginController {
	
	UserLoginImpl userLoginDAO = new UserLoginImpl();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody String postPayload, HttpServletResponse response, HttpServletRequest request) {
		final Gson gson = new Gson();
		// Convert received JSON data into Film object
		UserLogin jsonObjectFromServer = gson.fromJson(postPayload, UserLogin.class);
		System.out.println(postPayload);
		System.out.println(jsonObjectFromServer.toString());
		System.out.println(jsonObjectFromServer.getUsername());
		
		// Response headers
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		return "{ \"SERVER RESPONSE\":\"Successfully received JSON object and added film with name }";
    }
}
