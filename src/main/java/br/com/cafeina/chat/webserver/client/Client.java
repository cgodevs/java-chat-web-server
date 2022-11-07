package br.com.cafeina.chat.webserver.client;

import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket clientSocket;

    public Client (String host, int port) throws UnknownHostException, IOException {
        this.clientSocket = new Socket(host, port);  
        System.out.println("The client was successfully connected to the server!");
    }
}

