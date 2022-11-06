package br.com.cafeina.chat.webserver.tasks;

import java.io.IOException;

import br.com.cafeina.chat.webserver.client.Client;

public class StablishClientConnectionTask implements Runnable {

	@Override
	public void run() {
		try {
			new Client("127.0.0.1", 12345).startCommunication();
		} catch (IOException | InterruptedException e) { //TODO treat exception
			e.getMessage(); 
			System.err.println("Client creating error");
		}
	}

}
