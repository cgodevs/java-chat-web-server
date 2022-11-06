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

@WebServlet(urlPatterns = "/chat-room")
public class ChatRoomServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private final int port = 12345;
//	private List<PrintStream> allClientsPrintStreams;
	private MessageRepository allRoomMessages;
	private User currentUser;

	public void init() {
//		this.allClientsPrintStreams = new ArrayList<>();
		this.allRoomMessages = new MessageRepository();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();		
		if (Objects.isNull(currentUser))
			this.currentUser = new User(request.getParameter("username"), true);		
		
		if(allRoomMessages.isEmpty()) {
			allRoomMessages.addMessage(new Message("Testing out", new User("User2", false)));
			allRoomMessages.addMessage(
					new Message("Lorem ipsum dolor sit amet, consectetur adipiscing elit. I"
							+ "nteger augue sapien, pulvinar id dignissim eu, dictum sed dolor. Aliquam gravida, "
							+ "augue ac sagittis tempor, sapien elit sodales sapien, in accumsan magna eros feugiat"
							+ " diam. Sed finibus, nisl sed iaculis commodo, erat metus ullamcorper quam, a ullamcorper"
							+ " quam est eu nunc. Nulla ornare ut quam a varius. Etiam euismod dolor nec neque imperdiet "
							+ "iaculis. Praesent urna eros, commodo sed ex id, vehicula laoreet massa. Ut vitae tristique nisl, "
							+ "et faucibus turpis. Aenean condimentum libero id urna consectetur pulvinar. Ut ipsum enim, maximus "
							+ "fringilla sollicitudin non, pulvinar vitae lacus. Phasellus interdum dignissim dignissim. In gravida "
							+ "euismod sapien quis posuere. Nam justo mauris, sagittis ac fringilla id, dignissim eu diam. Nunc feugiat "
							+ "purus vel tempor dapibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. ", new User("User3", false)));
		}
		
		String inputMessage = request.getParameter("user_form_input_message");
		if (Objects.nonNull(inputMessage)) {
			Message newMessage = new Message(inputMessage, currentUser);
			allRoomMessages.addMessage(newMessage);
		}
		request.setAttribute("messages", allRoomMessages.retrieveAllMessages());
		
		RequestDispatcher rd = request.getRequestDispatcher("/chat.jsp");
		rd.forward(request, response);
	}

}