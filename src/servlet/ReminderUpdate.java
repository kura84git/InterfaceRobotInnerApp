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


@WebServlet("/ReminderUpdate")
public class ReminderUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if(action.equals("done")) {
			HttpSession session = request.getSession();
			Remind remindUpdate = (Remind) session.getAttribute("specifiedRemindUpdate");

			RemindUpdateLogic remindUpdateLogic = new RemindUpdateLogic();
			remindUpdateLogic.update(remindUpdate);

			String path = "/WEB-INF/remindUpdateResult.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		}

		else {
			String path = "/WEB-INF/remindUpdate.jsp";
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

			String path = "/WEB-INF/remindUpdate.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}

		else if(action.equals("register")) {

			String specifiedRemind = request.getParameter("specifiedRemind");
			String specifiedCategory = request.getParameter("specifiedCategory");

			Remind specifiedRemindUpdate = new Remind(specifiedRemind, specifiedCategory);

			HttpSession session = request.getSession();
			session.setAttribute("specifiedRemindUpdate", specifiedRemindUpdate);

			String path = "/WEB-INF/remindUpdateConfirm.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		}



	}

}
