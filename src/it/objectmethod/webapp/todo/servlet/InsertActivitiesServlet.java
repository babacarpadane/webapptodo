package it.objectmethod.webapp.todo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.webapp.todo.models.Activity;
import it.objectmethod.webapp.todo.models.Constants;

@WebServlet("/insert")
public class InsertActivitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String code = new String();
		List<String> codeList = new ArrayList<String>();

		do { // Creazone codice alfanumerico di tre caratteri
			StringBuilder codice = new StringBuilder();
			Random rand = new Random();
			codice.append((char) (rand.nextInt(25) + 65));
			codice.append((char) (rand.nextInt(9) + 48));
			codice.append((char) (rand.nextInt(25) + 65));
			code = codice.toString();

		} while (codeList.contains(code)); // Se è già presente nella lista, ricicla e ne crea uno nuovo

		codeList.add(code);

		Activity activity = new Activity();
		activity.description = request.getParameter("todo_phrase");
		activity.checked = false;

		HashMap<String, Activity> mapActivity = (HashMap<String, Activity>) session.getAttribute(Constants.ACTIVITY_MAP);
		mapActivity.put(code, activity);

		request.getRequestDispatcher("view").forward(request, response);

	}

}
