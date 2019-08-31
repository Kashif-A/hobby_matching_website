package model;


public class Message {

	private String message;
	private String timestamp;
	
	public Message() {}

	public Message(String message, String timestamp) {
		super();
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", timestamp=" + timestamp + "]";
	}

}

