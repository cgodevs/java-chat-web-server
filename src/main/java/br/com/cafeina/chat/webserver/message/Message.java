package br.com.cafeina.chat.webserver.message;

import java.time.LocalDateTime;

public class Message {
	
	private String textString;
	private LocalDateTime dateTime;
	private User user;
	
	public Message(String textString, User user) {
		this.textString = textString;
		this.user = user;
		this.dateTime = LocalDateTime.now();
	}
	
	public String getTextString() {
		return textString;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public User getUser() {
		return user;
	}
	
}
