package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Remind;
import model.RemindUpdateLogic;
import model.User;


@WebServlet("/ReminderUpdate")
public class ReminderUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if(action != null) {
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			Remind remindUpdate = (Remind) session.getAttribute("remindUpdate");
			Remind specifiedRemindUpdate = (Remind) session.getAttribute("specifiedRemindUpdate");

			RemindUpdateLogic remindUpdateLogic = new RemindUpdateLogic();
			boolean updateResult = remindUpdateLogic.update(loginUser, remindUpdate, specifiedRemindUpdate);

			request.setAttribute("updateResult", updateResult);

			String path = "/WEB-INF/reminderUpdateResult.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		}

		else {
			String path = "/WEB-INF/reminderUpdate.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action == null) {
			String remind = request.getParameter("remind");
			String category = request.getParameter("category");

			Remind remindUpdate = new Remind(remind, category);

			HttpSession session = request.getSession();
			session.setAttribute("remindUpdate", remindUpdate);

			String path = "/WEB-INF/reminderUpdate.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}

		else if(action.equals("update")) {

			String specifiedRemind = request.getParameter("specifiedRemind");
			String specifiedCategory = request.getParameter("specifiedCategory");

			Remind specifiedRemindUpdate = new Remind(specifiedRemind, specifiedCategory);

			HttpSession session = request.getSession();
			session.setAttribute("specifiedRemindUpdate", specifiedRemindUpdate);

			String path = "/WEB-INF/reminderUpdateConfirm.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		}



	}

}
