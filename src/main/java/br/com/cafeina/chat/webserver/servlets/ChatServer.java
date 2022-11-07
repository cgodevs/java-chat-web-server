package br.com.cafeina.chat.webserver.servlets;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.atomic.AtomicBoolean;
import br.com.cafeina.chat.webserver.tasks.GetClientConnectionsTask;

public class ChatServer {	// Singleton class

	private static final long serialVersionUID = 1L;
	private final int port = 12345;
	private final String ipAdress = "127.0.0.1";
	private static ChatServer chatServer;
	private ServerSocket serverSocket;
	private AtomicBoolean isWaitingForClients;

	private ChatServer() {
//		this.allClientsPrintStreams = new ArrayList<>();
		this.isWaitingForClients = new AtomicBoolean();
		this.isWaitingForClients.set(false);
		try {
			this.serverSocket = new ServerSocket(port);
			System.out.println("*** Port 12345 is ready to be connected ***");
		} catch (IOException e) {
			e.printStackTrace(); // TODO treat exception
		}		
		new Thread(new GetClientConnectionsTask(this.serverSocket)).start();
		isWaitingForClients.set(true);
	}

	public static ChatServer getInstance() {
	      if(chatServer == null)
	    	  chatServer = new ChatServer();
	       return chatServer;
	   }
	
	public int getPort() {
		return port;
	}
	
	public String getIpAdress() {
		return ipAdress;
	}
}


