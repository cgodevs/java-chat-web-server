package br.com.cafeina.chat.webserver.server;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cafeina.chat.webserver.message.Message;
import br.com.cafeina.chat.webserver.message.MessageRepository;
import br.com.cafeina.chat.webserver.message.User;

@WebServlet(urlPatterns = "/chat")
public class ChatServer extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private final int port = 12345;
	private List<PrintStream> allClientsPrintStreams;
	private MessageRepository allRoomMessages;
	private AtomicBoolean isOn;
//	ServerSocket server;

	public void init() {
		this.allClientsPrintStreams = new ArrayList<>();
		this.isOn = new AtomicBoolean(true);
		this.allRoomMessages = new MessageRepository();
		
		
		//TODO remove this
		User testUser1 = new User("Caroline", true);
		allRoomMessages.addMessage(new Message("Oi povo !!", testUser1));
		allRoomMessages.addMessage(new Message("Teste !!", testUser1));
		User testUser2 = new User("User2", false);
		allRoomMessages.addMessage(new Message("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer augue sapien, pulvinar id dignissim eu, dictum sed dolor. Aliquam gravida, augue ac sagittis tempor, sapien elit sodales sapien, in accumsan magna eros feugiat diam. Sed finibus, nisl sed iaculis commodo, erat metus ullamcorper quam, a ullamcorper quam est eu nunc. Nulla ornare ut quam a varius. Etiam euismod dolor nec neque imperdiet iaculis. Praesent urna eros, commodo sed ex id, vehicula laoreet massa. Ut vitae tristique nisl, et faucibus turpis. Aenean condimentum libero id urna consectetur pulvinar. Ut ipsum enim, maximus fringilla sollicitudin non, pulvinar vitae lacus. Phasellus interdum dignissim dignissim. In gravida euismod sapien quis posuere. Nam justo mauris, sagittis ac fringilla id, dignissim eu diam. Nunc feugiat purus vel tempor dapibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. ", testUser2));
		User testUser3 = new User("User3", false);
		allRoomMessages.addMessage(new Message("Apenas enrolando aqui", testUser3));
		
//		try {
//			this.server = new ServerSocket(this.port);
//		} catch (IOException e) {
//			e.printStackTrace(); // TODO Treat exception
//		}		
//		getNewClientConnections();
		System.out.println("*** Port 12345 is ready to be connected ***");
	}

    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
		String inputMessage = request.getParameter("user_form_input_message");
		Message newMessage = new Message(inputMessage, new User("Caroline", true));
		allRoomMessages.addMessage(newMessage);
		
		if(Objects.nonNull(allRoomMessages))
			request.setAttribute("messages", allRoomMessages.retrieveAllMessages());
		RequestDispatcher rd = request.getRequestDispatcher("/chat.jsp");
		rd.forward(request, response);
	}

}