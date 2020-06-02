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

		//リクエストパラメータ取得
		String action = request.getParameter("action");

		//リクエストパラメータに値が入っている場合
		if(action != null) {
			HttpSession session = request.getSession();

			//セッションスコープからログインしているユーザーの情報を取得
			User loginUser = (User)session.getAttribute("loginUser");

			//セッションスコープから現在のリマインド情報を取得
			Remind remindUpdate = (Remind) session.getAttribute("remindUpdate");

			//セッションスコープからリマインドの書き換え情報を取得
			Remind specifiedRemindUpdate = (Remind) session.getAttribute("specifiedRemindUpdate");

			//リマインド書き換え処理
			RemindUpdateLogic remindUpdateLogic = new RemindUpdateLogic();
			boolean updateResult = remindUpdateLogic.update(loginUser, remindUpdate, specifiedRemindUpdate);

			//書き換え実行結果をリクエストスコープに格納
			request.setAttribute("updateResult", updateResult);

			//reminderUpdateResult.jspへフォワード
			String path = "/WEB-INF/reminderUpdateResult.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		}

		//リクエストパラメータに値が入っていない場合
		else {
			//reminderUpdate.jspへフォワード
			String path = "/WEB-INF/reminderUpdate.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String action = request.getParameter("action");

		//リクエストパラメータがnullの場合
		if(action == null) {
			//リクエストパラメータの取得
			String remind = request.getParameter("remind");
			String category = request.getParameter("category");

			Remind remindUpdate = new Remind(remind, category);

			HttpSession session = request.getSession();

			//セッションスコープに現在のリマインド情報を格納
			session.setAttribute("remindUpdate", remindUpdate);

			//reminderUpdate.jspへフォワード
			String path = "/WEB-INF/reminderUpdate.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}

		//リクエストパラメータに値が入っている場合
		else if(action.equals("update")) {

			//リクエストパラメータの取得
			String specifiedRemind = request.getParameter("specifiedRemind");
			String specifiedCategory = request.getParameter("specifiedCategory");

			Remind specifiedRemindUpdate = new Remind(specifiedRemind, specifiedCategory);

			HttpSession session = request.getSession();

			//セッションスコープにリマインドの書き換え情報を格納
			session.setAttribute("specifiedRemindUpdate", specifiedRemindUpdate);

			//reminderUpdateConfirm.jspへフォワード
			String path = "/WEB-INF/reminderUpdateConfirm.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		}



	}

}
