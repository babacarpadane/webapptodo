package it.objectmethod.webapp.todo.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		HashMap<String, String> activityToRemove = (HashMap<String, String>) session.getAttribute("activity_map");
		String code = request.getParameter("code_remove");
		activityToRemove.remove(code);
		session.setAttribute("activity_map", activityToRemove);
		
		request.getRequestDispatcher("logged.jsp").forward(request, response);
			
		}

}
