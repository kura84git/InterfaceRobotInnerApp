package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUser;
import model.RegisterUserLogic;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if(action == null) {

			//register.jspへフォワード
			String path = "/WEB-INF/register.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);

		} else if(action.equals("done")) {

			HttpSession session = request.getSession();
			RegisterUser registerUser = (RegisterUser)session.getAttribute("registerUser");


			//RegisterUserLogicのインスタンス化
			RegisterUserLogic rul = new RegisterUserLogic();
			rul.execute(registerUser);

			//registerDone.jspへフォワード
			String path = "/WEB-INF/registerDone.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String botName = request.getParameter("botName");


		//RegisterUserクラスをインスタンス化
		RegisterUser registerUser = new RegisterUser(id, name, pass, mail, botName);

		//セッションスコープを使用する
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);

		//registerConfirm.jspへフォワード
		String path = "/WEB-INF/registerConfirm.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);


	}

}
