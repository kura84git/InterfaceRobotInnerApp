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
import model.User;



@WebServlet("/Reminder")
public class Reminder extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//セッションスコープにログインしているユーザーの情報を格納
		User loginUser = (User)session.getAttribute("loginUser");

		//リマインド一覧取得
		PostRemindLogic postRemindLogic = new PostRemindLogic();
		List<Remind> remindList = postRemindLogic.execute(loginUser);

		//リマインド一覧をセッションスコープに格納
		session.setAttribute("remindList", remindList);

		//reminder.jspへフォワード
		String path = "/WEB-INF/reminder.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//セッションスコープからログインしているユーザーの情報を取得
		User loginUser = (User)session.getAttribute("loginUser");
		String id = loginUser.getId();

		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータ取得
		String remind = request.getParameter("remind");
		String category = request.getParameter("category");

		//リクエストパラメータがnullでなく、空文字でない場合
		if(remind != null && remind.length() != 0) {

			Remind remindLatest  = new Remind(id, remind, category);

			//リマインドを登録
			PostRemindLogic postRemindLogic = new PostRemindLogic();
			postRemindLogic.create(remindLatest);

		} else {
			request.setAttribute("errorMsg", "必要項目を入力してください。");
		}

		//リマインド一覧取得
		PostRemindLogic postRemindLogic = new PostRemindLogic();
		List<Remind> remindList = postRemindLogic.execute(loginUser);

		//リマインド一覧をセッションスコープに格納
		session.setAttribute("remindList", remindList);

		//reminder.jspへフォワード
		String path = "/WEB-INF/reminder.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);


	}

}
