package br.com.cafeina.chat.webserver.message;

import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
	private List<Message> allRoomMessages = new ArrayList<Message>();
	
	public void addMessage(Message m) {
		this.allRoomMessages.add(m);
	}
	
	public List<Message> retrieveAllMessages(){
		if (this.allRoomMessages.size() > 0)
			return this.allRoomMessages;
		return null;
	}
	
	public Message getLastMessage() { //TODO check on whether to keep this
		if (this.allRoomMessages.size() > 0)
			return this.allRoomMessages.get(this.allRoomMessages.size() - 1);
		return null;
	}
	
	public boolean isEmpty() {
		return this.allRoomMessages.isEmpty();
	}
}
