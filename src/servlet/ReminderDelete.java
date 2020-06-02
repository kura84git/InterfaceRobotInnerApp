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

		//セッションスコープからログインしているユーザーの情報を取得
		User loginUser = (User)session.getAttribute("loginUser");

		//セッションスコープから削除するリマインドの情報を取得
		Remind remindDelete = (Remind) session.getAttribute("remindDelete");

		//リマインド削除処理
		RemindDeleteLogic remindDeleteLogic = new RemindDeleteLogic();
		boolean deleteResult = remindDeleteLogic.delete(loginUser, remindDelete);

		//削除実行結果をリクエストスコープに格納
		request.setAttribute("deleteResult", deleteResult);

		//reminderDeleteResult.jspへフォワード
		String path = "/WEB-INF/reminderDeleteResult.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String remind = request.getParameter("remind");
		String category = request.getParameter("category");

		Remind remindDelete = new Remind(remind, category);

		HttpSession session = request.getSession();

		//セッションスコープに削除するリマインドの情報を格納
		session.setAttribute("remindDelete", remindDelete);

		//reminderDeleteConfirm.jspへフォワード
		String path = "/WEB-INF/reminderDeleteConfirm.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}

}
