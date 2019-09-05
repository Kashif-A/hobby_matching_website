/*package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import com.google.gson.Gson;

import model.Message;
import model.User;
import model.UserLogin;
import util.AuthenticatedSession;
import dao.MessageDAO;
import dao.UserDAO;
import dao.UserLoginDAO;

@Controller
public class MessageController {
	
	MessageDAO messageDAO = new MessageDAO();
	UserLoginDAO userLoginDAO = new UserLoginDAO();
	
	@RequestMapping(value = "/insertMessage", method = RequestMethod.POST)
	@ResponseBody
	public void home(WebRequest request, @RequestBody String requestBody) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		Gson gson = new Gson();
		Message message = gson.fromJson(requestBody, Message.class);
		AuthenticatedSession a = (AuthenticatedSession) session.getAttribute("authenticated");
		UserLogin user = userLoginDAO.getUser(a.getAuthenticatedUser());
		int userId = user.getUser_id();
		messageDAO.insertMessage(userId, message.getMessage(), message.getTimestamp());
    }
}*/
