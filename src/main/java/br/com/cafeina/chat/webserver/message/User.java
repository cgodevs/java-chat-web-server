package br.com.cafeina.chat.webserver.message;

public class User {
	private int id;  //TODO add it to the session later
	private static int classId;
	private String userName;
	private boolean currentSessionUser; //TODO possibly remove later

	public User(){}
	
	public User(String userName) {
		this.userName = userName;
		this.id = classId++;
	}
	
	public User(String userName, boolean isCurrentSessionUser) {
		this.userName = userName;
		this.currentSessionUser = isCurrentSessionUser;
		this.id = classId++;
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

	public boolean getCurrentSessionUser() {
		return currentSessionUser;
	}

	public void setCurrentSessionUser(boolean isCurrentSessionUser) {
		this.currentSessionUser = isCurrentSessionUser;
	}	
	
}
