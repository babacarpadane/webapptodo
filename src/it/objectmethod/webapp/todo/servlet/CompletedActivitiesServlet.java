package it.objectmethod.webapp.todo.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.webapp.todo.models.Activity;
import it.objectmethod.webapp.todo.models.Constants;

@WebServlet("/complete")
public class CompletedActivitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		HashMap<String, Activity> mapActivity = (HashMap<String, Activity>) session
				.getAttribute(Constants.ACTIVITY_MAP);
		Enumeration<String> parametersNames = request.getParameterNames();

		while (parametersNames.hasMoreElements()) {
			String name = parametersNames.nextElement();
			if (name.length() == 3) { // così facendo nel form non si possono più inserire parametri con un nome di 3
										// caratteri
				Activity attivita = mapActivity.get(name);
				attivita.setChecked(true);
				mapActivity.replace(name, attivita);
			}
		}

		request.getRequestDispatcher("view").forward(request, response);

	}

}
