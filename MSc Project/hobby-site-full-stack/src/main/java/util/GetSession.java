package util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class GetSession {
	
	AuthenticatedSession authenticatedSession = new AuthenticatedSession();
	
	public HttpSession getSession(String username) {
		authenticatedSession.setAuthenticatedUser(username);
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession(true);
		session.setAttribute("authenticated", authenticatedSession);
	    return session;
	}
}
