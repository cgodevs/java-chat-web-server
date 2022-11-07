package br.com.cafeina.chat.webserver.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cafeina.chat.webserver.client.Client;
import br.com.cafeina.chat.webserver.message.User;

@WebServlet("/clientConnection")
public class ClientConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ChatServer chatServer;
	
	public void init() {
		ClientConnectionServlet.chatServer = ChatServer.getInstance();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sessionId = (String) request.getParameter("sessionId");
		String username = request.getParameter("username");
		Client newClient = new Client(chatServer.getIpAdress(), chatServer.getPort());
		User newUser = new User(username, sessionId, newClient);
		
		request.setAttribute("newUser", newUser);
		request.setAttribute("thisSessionId", newUser.getSessionId());
		
		request.getRequestDispatcher("/chat-room").forward(request, response);		
		System.out.println("NEW USER SESSION ID: " + newUser.getSessionId());
	}
}
