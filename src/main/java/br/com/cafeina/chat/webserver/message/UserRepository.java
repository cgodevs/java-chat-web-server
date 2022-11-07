package br.com.cafeina.chat.webserver.message;

import java.util.HashSet;
import java.util.Set;

public class UserRepository {
	private Set<User> allRoomUsers = new HashSet<User>();
	
	public void addUser(User u) {
		this.allRoomUsers.add(u);
	}
	
	public Set<User> retrieveAllUsers(){
		if (this.allRoomUsers.size() > 0)
			return this.allRoomUsers;
		return null;
	}
	
	public boolean isEmpty() {
		return this.allRoomUsers.isEmpty();
	}
	
	public User getUserbySessionId(String sessionId) {
		for (User user: this.allRoomUsers) {
			if (user.getSessionId().equals(sessionId))
				return user;
		}
		return null;
	}
	
	public boolean repositoryContainsUser(User user) {
		return this.allRoomUsers.contains(user);
	}
}
