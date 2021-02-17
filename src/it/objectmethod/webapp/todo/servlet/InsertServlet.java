package it.objectmethod.webapp.todo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		char s[] = new char[3];
		char num[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		char car[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		Random rand = new Random();
		do {
			s[0] = car[rand.nextInt(25)];
			s[1] = num[rand.nextInt(9)];
			s[2] = car[rand.nextInt(25)];
		} while (false);
		String codice = String.valueOf(s);

		String activity = request.getParameter("todo_phrase");

		@SuppressWarnings("unchecked")
		HashMap<String, String> mapActivity = (HashMap<String, String>) session.getAttribute("activity_map");
		mapActivity.put(codice, activity);
		session.setAttribute("activity_map", mapActivity);
		session.setAttribute("numero_frasi", mapActivity.size());

		request.getRequestDispatcher("logged.jsp").forward(request, response);

	}

}
