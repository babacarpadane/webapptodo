package it.objectmethod.webapp.todo.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.webapp.todo.models.Activity;
import it.objectmethod.webapp.todo.models.Constants;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		HashMap<String, Activity> mapActivity = new HashMap<String, Activity>();
		session.setAttribute(Constants.ACTIVITY_MAP, mapActivity);
		
		String user = request.getParameter("username");
		session.setAttribute("logged_user", user);
		
		request.getRequestDispatcher("logged.jsp").forward(request, response);

	}

}
