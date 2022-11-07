package br.com.cafeina.chat.webserver.message;

import br.com.cafeina.chat.webserver.client.Client;

public class User {
	private static int classId;
	private int id;  
	private String userName;
	private Client userClient;
	private String sessionId; 

	public User(){}
	
	public User(String userName) {
		this.userName = userName;
		this.id = classId++;
	}
	
	public User(String userName, String sessionId) {
		this.userName = userName;
		this.sessionId = sessionId;
		this.id = classId++;
	}

	public User(String userName, Client client) {
		this.userName = userName;
		this.id = classId++;
		this.userClient = client;
	}
	
	public User(String userName, String sessionId, Client client) {
		this.userName = userName;
		this.sessionId = sessionId;
		this.id = classId++;
		this.userClient = client;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}
	
	public int getId() {
		return id;
	}
	
	public Client getUserClient() {
		return userClient;
	}

	public void setUserClient(Client userClient) {
		this.userClient = userClient;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userClient=" + userClient + ", sessionId=" + sessionId
				+ "]";
	}
	
	@Override 
	public boolean equals(Object o) {
		return ((User)o).sessionId.equals(this.sessionId);
	}
	
	//TODO override hashCode!

}
