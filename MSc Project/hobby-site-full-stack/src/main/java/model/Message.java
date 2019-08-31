package model;

public class Message {
	private String message;
	private String timeStamp;
	
	public Message(String message, String timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "Message [message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	
}
