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
import model.RemindDeleteLogic;
import model.User;

@WebServlet("/ReminderDelete")
public class ReminderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		Remind remindDelete = (Remind) session.getAttribute("remindDelete");

		RemindDeleteLogic remindDeleteLogic = new RemindDeleteLogic();
		boolean deleteResult = remindDeleteLogic.delete(loginUser, remindDelete);

		request.setAttribute("deleteResult", deleteResult);

		String path = "/WEB-INF/reminderDeleteResult.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String remind = request.getParameter("remind");
		String category = request.getParameter("category");

		Remind remindDelete = new Remind(remind, category);

		HttpSession session = request.getSession();
		session.setAttribute("remindDelete", remindDelete);

		String path = "/WEB-INF/reminderDeleteConfirm.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}

}
