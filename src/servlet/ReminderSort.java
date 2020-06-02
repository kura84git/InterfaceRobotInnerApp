package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Remind;
import model.RemindSortLogic;
import model.User;


@WebServlet("/ReminderSort")
public class ReminderSort extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		RemindSortLogic remindSortLogic = new RemindSortLogic();
		Set<Remind> categoryList = remindSortLogic.findCategory(loginUser);

		request.setAttribute("categoryList", categoryList);

		String path = "/WEB-INF/reminderSort.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		request.setCharacterEncoding("UTF-8");
		String specifiedCategory = request.getParameter("category");

		List<Remind> remindSortList = null;

		if(specifiedCategory != null && specifiedCategory.length() != 0) {

			RemindSortLogic remindSortLogic = new RemindSortLogic();
			remindSortList = remindSortLogic.sort(loginUser, specifiedCategory);

		} else {
			request.setAttribute("errorMsg", "必要項目を入力してください。");
			String path = "/WEB-INF/reminderSort.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}

		request.setAttribute("remindSortList", remindSortList);

		String path = "/WEB-INF/reminderSortResult.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);



	}

}
