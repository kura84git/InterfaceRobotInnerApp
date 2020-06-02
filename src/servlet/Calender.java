package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calender")
public class Calender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//calender.jspへフォワード
		String path = "/WEB-INF/calender.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		String ybox = request.getParameter("year");
        String mbox = request.getParameter("month");

      //引数をint型に変更する。
		int a = Integer.parseInt(ybox);
    	int b = Integer.parseInt(mbox);
		//第1引数を求める。

		//カウント機能の変数を作ってあげる
		int count = 0;

		//第1引数うるう年を考慮しないで、（年数-1）＊　365
		//a年1月1日を求める。
		count =(a - 1) * 365;

		//うるう年を考える。
		//うるう年の時にカウントを+1にする。

		for (int i = 1; i < a ; i++){
			if(i%400==0){
			count = count + 1;
			}else if(i%100==0){
			; //処理なし
			}else if(i%4==0){
			count = count + 1;
			}else{
			;//処理なし
			}
		}

 		//第2引数の月を求める。
		//配列を作る。
		int[] tuki = {1,31,28,31,30,31,30,31,31,30,31,30};
		//繰り返し文を利用する。
		for (int i = 0;i < b; i++){
			count = count + tuki[i];
		}

		//第1引数がうるう年の時、うるう年+1を計算する。
    	//うるう年判定変数uruu
    	int uruu;
		if(a%400==0){
			if(b == 1 || b == 2){
				uruu = 1;
			}else{
				uruu = 1;
				count = count + 1;
			}
		}else if(a%100==0){
			uruu = 0;
		}else if(a%4==0){
			if(b == 1 || b == 2){
				uruu = 1;
			}else{
				uruu = 1;
				count = count + 1;
			}
		}else{
			uruu = 0;
		}


    	if (count % 7 == 0) { //1日が日曜日のとき
    		if (b == 1) { //1月
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun1.jspへフォワード
				String path = "/WEB-INF/calenderSun1.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 2) {//2月
    			if (uruu == 0) {
        			//リクエストスコープ
		        	request.setAttribute("ybox", ybox);
		        	request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSun2a.jspへフォワード
					String path = "/WEB-INF/calenderSun2a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSun2b.jspへフォワード
					String path = "/WEB-INF/calenderSun2b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 3) {//3月
    			if (a % 4 == 0 || a % 4 == 1) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSun3a.jspへフォワード
					String path = "/WEB-INF/calenderSun3a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSun3b.jspへフォワード
					String path = "/WEB-INF/calenderSun3b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 4) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun4.jspへフォワード
				String path = "/WEB-INF/calenderSun4.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 5) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun5.jspへフォワード
				String path = "/WEB-INF/calenderSun5.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 6) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun6.jspへフォワード
				String path = "/WEB-INF/calenderSun6.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 7) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun7.jspへフォワード
				String path = "/WEB-INF/calenderSun7.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 8) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun8.jspへフォワード
				String path = "/WEB-INF/calenderSun8.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 9) {
    			if (a % 4 == 0) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSun9a.jspへフォワード
					String path = "/WEB-INF/calenderSun9a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSun9b.jspへフォワード
					String path = "/WEB-INF/calenderSun9b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 10) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun10.jspへフォワード
				String path = "/WEB-INF/calenderSun10.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 11) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun11.jspへフォワード
				String path = "/WEB-INF/calenderSun11.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSun12.jspへフォワード
				String path = "/WEB-INF/calenderSun12.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		}
    	} //if (count % 7 == 0)

    	else if (count % 7 == 1) { //1日が月曜日のとき
    		if (b == 1) { //1月
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon1.jspへフォワード
				String path = "/WEB-INF/calenderMon1.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 2) {//2月
    			if (uruu == 0) {
        			//リクエストスコープ
		        	request.setAttribute("ybox", ybox);
		        	request.setAttribute("mbox", mbox);

					//WEB-INF/calenderMon2a.jspへフォワード
					String path = "/WEB-INF/calenderMon2a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderMon2b.jspへフォワード
					String path = "/WEB-INF/calenderMon2b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 3) {//3月
    			if (a % 4 == 0 || a % 4 == 1) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderMon3a.jspへフォワード
					String path = "/WEB-INF/calenderMon3a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderMon3b.jspへフォワード
					String path = "/WEB-INF/calenderMon3b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 4) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon4.jspへフォワード
				String path = "/WEB-INF/calenderMon4.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 5) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon5.jspへフォワード
				String path = "/WEB-INF/calenderMon5.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 6) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon6.jspへフォワード
				String path = "/WEB-INF/calenderMon6.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 7) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon7.jspへフォワード
				String path = "/WEB-INF/calenderMon7.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 8) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon8.jspへフォワード
				String path = "/WEB-INF/calenderMon8.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 9) {
    			if (a % 4 == 0) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderMon9a.jspへフォワード
					String path = "/WEB-INF/calenderMon9a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderMon9b.jspへフォワード
					String path = "/WEB-INF/calenderMon9b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 10) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon10.jspへフォワード
				String path = "/WEB-INF/calenderMon10.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 11) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon11.jspへフォワード
				String path = "/WEB-INF/calenderMon11.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderMon12.jspへフォワード
				String path = "/WEB-INF/calenderMon12.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		}
    	} //else if (count % 7 == 1)

    	else if (count % 7 == 2) { //1日が火曜日のとき
    		if (b == 1) { //1月
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue1.jspへフォワード
				String path = "/WEB-INF/calenderTue1.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 2) {//2月
    			if (uruu == 0) {
        			//リクエストスコープ
		        	request.setAttribute("ybox", ybox);
		        	request.setAttribute("mbox", mbox);

					//WEB-INF/calenderTue2a.jspへフォワード
					String path = "/WEB-INF/calenderTue2a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderTue2b.jspへフォワード
					String path = "/WEB-INF/calenderTue2b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 3) {//3月
    			if (a % 4 == 0 || a % 4 == 1) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderTue3a.jspへフォワード
					String path = "/WEB-INF/calenderTue3a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderTue3b.jspへフォワード
					String path = "/WEB-INF/calenderTue3b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 4) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue4.jspへフォワード
				String path = "/WEB-INF/calenderTue4.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 5) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue5.jspへフォワード
				String path = "/WEB-INF/calenderTue5.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 6) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue6.jspへフォワード
				String path = "/WEB-INF/calenderTue6.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 7) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue7.jspへフォワード
				String path = "/WEB-INF/calenderTue7.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 8) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue8.jspへフォワード
				String path = "/WEB-INF/calenderTue8.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 9) {
    			if (a % 4 == 0) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderTue9a.jspへフォワード
					String path = "/WEB-INF/calenderTue9a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderTue9b.jspへフォワード
					String path = "/WEB-INF/calenderTue9b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 10) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue10.jspへフォワード
				String path = "/WEB-INF/calenderTue10.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 11) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue11.jspへフォワード
				String path = "/WEB-INF/calenderTue11.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderTue12.jspへフォワード
				String path = "/WEB-INF/calenderTue12.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		}
    	} //else if (count % 7 == 2)

    	else if (count % 7 == 3) { //1日が水曜日のとき
    		if (b == 1) { //1月
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed1.jspへフォワード
				String path = "/WEB-INF/calenderWed1.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 2) {//2月
    			if (uruu == 0) {
        			//リクエストスコープ
		        	request.setAttribute("ybox", ybox);
		        	request.setAttribute("mbox", mbox);

					//WEB-INF/calenderWed2a.jspへフォワード
					String path = "/WEB-INF/calenderWed2a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderWed2b.jspへフォワード
					String path = "/WEB-INF/calenderWed2b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 3) {//3月
    			if (a % 4 == 0 || a % 4 == 1) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderWed3a.jspへフォワード
					String path = "/WEB-INF/calenderWed3a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderWed3b.jspへフォワード
					String path = "/WEB-INF/calenderWed3b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 4) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed4.jspへフォワード
				String path = "/WEB-INF/calenderWed4.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 5) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed5.jspへフォワード
				String path = "/WEB-INF/calenderWed5.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 6) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed6.jspへフォワード
				String path = "/WEB-INF/calenderWed6.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 7) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed7.jspへフォワード
				String path = "/WEB-INF/calenderWed7.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 8) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed8.jspへフォワード
				String path = "/WEB-INF/calenderWed8.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 9) {
    			if (a % 4 == 0) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderWed9a.jspへフォワード
					String path = "/WEB-INF/calenderWed9a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderWed9b.jspへフォワード
					String path = "/WEB-INF/calenderWed9b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 10) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed10.jspへフォワード
				String path = "/WEB-INF/calenderWed10.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 11) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed11.jspへフォワード
				String path = "/WEB-INF/calenderWed11.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderWed12.jspへフォワード
				String path = "/WEB-INF/calenderWed12.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		}
    	} //else if (count % 7 == 3)

    	else if (count % 7 == 4) { //1日が木曜日のとき
    		if (b == 1) { //1月
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu1.jspへフォワード
				String path = "/WEB-INF/calenderThu1.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 2) {//2月
    			if (uruu == 0) {
        			//リクエストスコープ
		        	request.setAttribute("ybox", ybox);
		        	request.setAttribute("mbox", mbox);

					//WEB-INF/calenderThu2a.jspへフォワード
					String path = "/WEB-INF/calenderThu2a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderThu2b.jspへフォワード
					String path = "/WEB-INF/calenderThu2b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 3) {//3月
    			if (a % 4 == 0 || a % 4 == 1) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderThu3a.jspへフォワード
					String path = "/WEB-INF/calenderThu3a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderThu3b.jspへフォワード
					String path = "/WEB-INF/calenderThu3b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 4) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu4.jspへフォワード
				String path = "/WEB-INF/calenderThu4.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 5) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu5.jspへフォワード
				String path = "/WEB-INF/calenderThu5.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 6) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu6.jspへフォワード
				String path = "/WEB-INF/calenderThu6.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 7) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu7.jspへフォワード
				String path = "/WEB-INF/calenderThu7.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 8) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu8.jspへフォワード
				String path = "/WEB-INF/calenderThu8.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 9) {
    			if (a % 4 == 0) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderThu9a.jspへフォワード
					String path = "/WEB-INF/calenderThu9a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderThu9b.jspへフォワード
					String path = "/WEB-INF/calenderThu9b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 10) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu10.jspへフォワード
				String path = "/WEB-INF/calenderThu10.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 11) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu11.jspへフォワード
				String path = "/WEB-INF/calenderThu11.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderThu12.jspへフォワード
				String path = "/WEB-INF/calenderThu12.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		}
    	} //else if (count % 7 == 4)

    	else if (count % 7 == 5) { //1日が金曜日のとき
    		if (b == 1) { //1月
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri1.jspへフォワード
				String path = "/WEB-INF/calenderFri1.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 2) {//2月
    			if (uruu == 0) {
        			//リクエストスコープ
		        	request.setAttribute("ybox", ybox);
		        	request.setAttribute("mbox", mbox);

					//WEB-INF/calenderFri2a.jspへフォワード
					String path = "/WEB-INF/calenderFri2a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderFri2b.jspへフォワード
					String path = "/WEB-INF/calenderFri2b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 3) {//3月
    			if (a % 4 == 0 || a % 4 == 1) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderFri3a.jspへフォワード
					String path = "/WEB-INF/calenderFri3a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderFri3b.jspへフォワード
					String path = "/WEB-INF/calenderFri3b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 4) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri4.jspへフォワード
				String path = "/WEB-INF/calenderFri4.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 5) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri5.jspへフォワード
				String path = "/WEB-INF/calenderFri5.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 6) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri6.jspへフォワード
				String path = "/WEB-INF/calenderFri6.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 7) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri7.jspへフォワード
				String path = "/WEB-INF/calenderFri7.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 8) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri8.jspへフォワード
				String path = "/WEB-INF/calenderFri8.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 9) {
    			if (a % 4 == 0) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderFri9a.jspへフォワード
					String path = "/WEB-INF/calenderFri9a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderFri9b.jspへフォワード
					String path = "/WEB-INF/calenderFri9b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 10) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri10.jspへフォワード
				String path = "/WEB-INF/calenderFri10.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 11) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri11.jspへフォワード
				String path = "/WEB-INF/calenderFri11.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderFri12.jspへフォワード
				String path = "/WEB-INF/calenderFri12.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		}
    	} //else if (count % 7 == 5)

    	else { //1日が土曜日のとき
    		if (b == 1) { //1月
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat1.jspへフォワード
				String path = "/WEB-INF/calenderSat1.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 2) {//2月
    			if (uruu == 0) {
        			//リクエストスコープ
		        	request.setAttribute("ybox", ybox);
		        	request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSat2a.jspへフォワード
					String path = "/WEB-INF/calenderSat2a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSat2b.jspへフォワード
					String path = "/WEB-INF/calenderSat2b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 3) {//3月
    			if (a % 4 == 0 || a % 4 == 1) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSat3a.jspへフォワード
					String path = "/WEB-INF/calenderSat3a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSat3b.jspへフォワード
					String path = "/WEB-INF/calenderSat3b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 4) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat4.jspへフォワード
				String path = "/WEB-INF/calenderSat4.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 5) {
    			//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat5.jspへフォワード
				String path = "/WEB-INF/calenderSat5.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 6) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat6.jspへフォワード
				String path = "/WEB-INF/calenderSat6.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 7) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat7.jspへフォワード
				String path = "/WEB-INF/calenderSat7.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 8) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat8.jspへフォワード
				String path = "/WEB-INF/calenderSat8.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 9) {
    			if (a % 4 == 0) {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSat9a.jspへフォワード
					String path = "/WEB-INF/calenderSat9a.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			} else {
    				//リクエストスコープ
	        		request.setAttribute("ybox", ybox);
	        		request.setAttribute("mbox", mbox);

					//WEB-INF/calenderSat9b.jspへフォワード
					String path = "/WEB-INF/calenderSat9b.jsp";
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
    			}
    		} else if (b == 10) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat10.jspへフォワード
				String path = "/WEB-INF/calenderSat10.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else if (b == 11) {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat11.jspへフォワード
				String path = "/WEB-INF/calenderSat11.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		} else {
        		//リクエストスコープ
	        	request.setAttribute("ybox", ybox);
	        	request.setAttribute("mbox", mbox);

				//WEB-INF/calenderSat12.jspへフォワード
				String path = "/WEB-INF/calenderSat12.jsp";
				RequestDispatcher dis = request.getRequestDispatcher(path);
				dis.forward(request, response);
    		}
    	} //else
	}
}
