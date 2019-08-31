package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.protobuf.Message;

import dao.MessageDAO;
import model.JsonRegisterForm;
import model.User;
import model.UserLogin;
import util.AuthenticatedSession;
import util.GetSession;

@Controller
public class MessageController {
	
	MessageDAO messageDAO = new MessageDAO();
	
	@RequestMapping(value = "/insertMessage", method = RequestMethod.POST)
	@ResponseBody
	public void home(WebRequest request, @RequestBody String requestBody) {
		Gson gson = new Gson();
		Message message = gson.fromJson(requestBody, Message.class);
		System.out.println(message.toString());
    }
}
