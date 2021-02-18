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

@WebServlet("/view")
public class ViewActivitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		HashMap<String, Activity> mapActivity = (HashMap<String, Activity>) session
				.getAttribute(Constants.ACTIVITY_MAP);
		session.setAttribute(Constants.ACTIVITY_MAP, mapActivity);
		session.setAttribute("numero_frasi", mapActivity.size());

		request.getRequestDispatcher("logged.jsp").forward(request, response);

	}

}
