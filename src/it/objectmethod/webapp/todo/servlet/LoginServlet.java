package it.objectmethod.webapp.todo.servlet;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user = request.getParameter("username");
		session.setAttribute("logged_user", user);
		request.getRequestDispatcher("logged.jsp").forward(request, response);
		
		//List<String> listToDo = new ArrayList<String>();
		//session.setAttribute("activity_list", listToDo);
		HashMap<String, String> mapToDo =  new HashMap<String, String>();
		session.setAttribute("activity_map", mapToDo);
		
		

	}

}
