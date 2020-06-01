package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostRemindLogic;
import model.Remind;



@WebServlet("/Reminder")
public class Reminder extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PostRemindLogic postRemindLogic = new PostRemindLogic();
		List<Remind> remindList = postRemindLogic.execute();

		HttpSession session = request.getSession();
		session.setAttribute("remindList", remindList);

		String path = "/WEB-INF/reminder.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String remind = request.getParameter("remind");
		String category = request.getParameter("category");

		if(remind != null && remind.length() != 0) {

			Remind remindLatest  = new Remind(remind, category);

			PostRemindLogic postRemindLogic = new PostRemindLogic();
			postRemindLogic.create(remindLatest);

		} else {
			request.setAttribute("errorMsg", "必要項目を入力してください。");
		}

		PostRemindLogic postRemindLogic = new PostRemindLogic();
		List<Remind> remindList = postRemindLogic.execute();

		HttpSession session = request.getSession();
		session.setAttribute("remindList", remindList);

		String path = "/WEB-INF/reminder.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);


	}

}
