package util;

import org.springframework.stereotype.Component;

@Component
public class AuthenticatedSession {
	
	private String authenticatedUser;

	public AuthenticatedSession() {};
	
	public AuthenticatedSession(String authenticatedUser) {
		super();
		this.authenticatedUser = authenticatedUser;
	}

	public String getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(String authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	@Override
	public String toString() {
		return "AuthenticatedSession [authenticatedUser=" + authenticatedUser + "]";
	}
	
}
