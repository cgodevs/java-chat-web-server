package br.com.cafeina.chat.webserver.client;

import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
//import java.util.Scanner;
//import br.com.cafeina.chat.webserver.tasks.ReceiveFromServerTask;
//import br.com.cafeina.chat.webserver.tasks.SendThisClientMessagesTask;

public class Client {
	private Socket clientSocket;
//	private Scanner keyboard = new Scanner(System.in);
//	private PrintStream clientPrinting;

    public Client (String host, int port) throws UnknownHostException, IOException {
        this.clientSocket = new Socket(host, port);  
        System.out.println("The client was successfully connected to the server!");
//        clientPrinting = new PrintStream(clientSocket.getOutputStream());
    }

//    public PrintStream getClientPrinting() {
//    	return clientPrinting;
//    }
//    
//    public Scanner getKeyboard() {
//    	return keyboard;
//    }
//
//    public void startCommunication() throws IOException, InterruptedException {
//    	
//    	// THREAD 0: Gets messages from other Clients through the server
//        ReceiveFromServerTask getServerMessages = new ReceiveFromServerTask(clientSocket.getInputStream());
//        Thread serverFeed = new Thread(getServerMessages);
//        serverFeed.start();
//        
//        // THREAD 1: Sends this client's messages to other clients
//        Thread shareWithOthers = new Thread(new SendThisClientMessagesTask(this));
//        shareWithOthers.start();        
//        shareWithOthers.join();
//        
//        clientPrinting.close();
//        keyboard.close();
//        clientSocket.close();        
//    }
}

