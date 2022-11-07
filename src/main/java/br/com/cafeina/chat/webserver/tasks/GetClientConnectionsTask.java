package br.com.cafeina.chat.webserver.tasks;

import java.io.IOException;
//import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class GetClientConnectionsTask implements Runnable {
	
	ServerSocket server;
	
	public GetClientConnectionsTask(ServerSocket server) {
		this.server = server;
	}
	
	@Override
	public void run() {
        try {  // for each client's connection
			Socket clientConnection = server.accept(); // blocking method waiting for a client connection
			System.out.println("Server is now waiting for clients");
			System.out.printf("New connection established with client at port %d\n", clientConnection.getPort()); // client's acceptance port number

		} catch (SocketException e) {
			e.printStackTrace();	//TODO treat exception
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
