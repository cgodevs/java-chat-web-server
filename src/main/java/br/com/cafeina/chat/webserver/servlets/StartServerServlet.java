package br.com.cafeina.chat.webserver.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.cafeina.chat.webserver.tasks.GetClientConnectionsTask;

@WebServlet(urlPatterns = "/startServer")
public class StartServerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final int port = 12345;
//	private List<PrintStream> allClientsPrintStreams;
	private AtomicBoolean isWaitingForClients;
	ServerSocket server;

	public void init() {
//		this.allClientsPrintStreams = new ArrayList<>();
		this.isWaitingForClients = new AtomicBoolean();
		this.isWaitingForClients.set(false);
		try {
			this.server = new ServerSocket(this.port);
			System.out.println("*** Port 12345 is ready to be connected ***");
		} catch (IOException e) {
			e.printStackTrace(); // TODO 
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		request.setAttribute("username", username);
		request.getRequestDispatcher("/clientConnection").forward(request, response);
		if (!isWaitingForClients.get()) {
			new Thread(new GetClientConnectionsTask(server)).start();
			isWaitingForClients.set(true);
		}
	}

//    public void shareMessageWithAll(String msg) { 
//        for (PrintStream console : allClientsPrintStreams) {
//        	console.println(msg);
//        }
//    }

	
//	 TODO implement quit server method 
//	 public void quit() throws IOException {
////		 this.isOn.set(false); 
//		 this.server.close(); 
//	 }
	 
}
