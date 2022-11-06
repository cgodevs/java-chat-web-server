package br.com.cafeina.chat.webserver.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.cafeina.chat.webserver.tasks.StablishClientConnectionTask;

@WebServlet("/clientConnection")
public class ClientConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new Thread(new StablishClientConnectionTask()).start();
		request.getRequestDispatcher("/chat-room").forward(request, response);		
	}
}
