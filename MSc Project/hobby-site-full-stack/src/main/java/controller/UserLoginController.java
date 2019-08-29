package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.UserLogin;
import util.GetSession;
import util.PBKDF2PasswordHash;

@Controller
public class UserLoginController {
	
	GetSession session = new GetSession();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Object loginPost(UserLogin userFromRequestBody, HttpServletResponse response) {
		dao.UserLoginDAO userDAO = new dao.UserLoginDAO();
		UserLogin userFromDB = userDAO.getUser(userFromRequestBody.getUsername());
		String DBPassword = "";
		if(userFromDB != null) {
			PBKDF2PasswordHash hashPwd = new PBKDF2PasswordHash();
			DBPassword = userFromDB.getPassword();
			if(DBPassword.equals(hashPwd.hashPassword(userFromRequestBody.getPassword()))) {
			    HttpSession sesh = session.getSession(userFromRequestBody.getUsername());
			    return new ModelAndView("redirect:/profiles");
			}
		} else {
			System.out.println("unmatched");
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("redirect:/login");
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "index";
    }
}
