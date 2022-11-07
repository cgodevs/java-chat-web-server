package br.com.cafeina.chat.webserver.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cafeina.chat.webserver.message.Message;
import br.com.cafeina.chat.webserver.message.MessageRepository;
import br.com.cafeina.chat.webserver.message.User;
import br.com.cafeina.chat.webserver.message.UserRepository;

@WebServlet(urlPatterns = "/chat-room")
public class ChatRoomServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private MessageRepository allRoomMessages;
	private UserRepository allUsers;

	public void init() {
		this.allRoomMessages = new MessageRepository(); 
		this.allUsers = new UserRepository();   
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thisSessionId = (String) request.getAttribute("thisSessionId");
		if (Objects.isNull(thisSessionId))
			thisSessionId = request.getParameter("thisSessionId");
		thisSessionId = thisSessionId.replace("/", ""); // I don't know why slashes got suddenly added to this
		
		User newUser = (User) request.getAttribute("newUser");	// received once from clientConnection
		if (!this.allUsers.repositoryContainsUser(newUser) && Objects.nonNull(newUser))
			this.allUsers.addUser(newUser);
		
		String inputMessage = request.getParameter("user_form_input_message");
		if (Objects.nonNull(inputMessage)) {  //TODO validate from form
			User currentSessionUser = allUsers.getUserbySessionId(thisSessionId);
			Message newMessage = new Message(inputMessage, currentSessionUser);  
			allRoomMessages.addMessage(newMessage);
		}
		
		request.setAttribute("messages", allRoomMessages.retrieveAllMessages());
		request.setAttribute("thisSessionId",thisSessionId);
		RequestDispatcher rd = request.getRequestDispatcher("/chat.jsp");
		rd.forward(request, response);
	}
}
//	this.allClientsPrintStreams = new ArrayList<>(); //in init()
//	private List<PrintStream> allClientsPrintStreams;
//	PrintWriter out = response.getWriter();			//in service()	

