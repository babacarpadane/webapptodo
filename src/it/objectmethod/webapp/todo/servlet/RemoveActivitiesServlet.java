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

@WebServlet("/remove")
public class RemoveActivitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		HashMap<String, Activity> mapActivity = (HashMap<String, Activity>) session
				.getAttribute(Constants.ACTIVITY_MAP);
		String code = request.getParameter("code_to_remove");
		mapActivity.remove(code);

		request.getRequestDispatcher("view").forward(request, response);

	}

}
