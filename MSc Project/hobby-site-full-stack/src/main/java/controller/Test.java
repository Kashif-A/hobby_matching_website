package controller;

import java.util.List;

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
public class Test {
	HobbyDAO hobbyDAO = new HobbyDAO();
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		List<Object[]> hobbies = hobbyDAO.getHobbyList();
		for(Object[] h : hobbies) {
			System.out.println(h[1].toString());
		}
    }
}
