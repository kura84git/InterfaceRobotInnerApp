package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Remind;
import model.User;

public class RemindDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interface_robot_inner?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public boolean create(Remind remindLatest) { //リマインド投稿

		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SQL文
			String sql = "INSERT INTO REMIND (ID, REMIND, CATEGORY) VALUES (?, ?, ?)";

			//SQL文送信
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SQL文に情報を渡す
			pStmt.setString(1, remindLatest.getId());
			pStmt.setString(2, remindLatest.getRemind());
			pStmt.setString(3, remindLatest.getCategory());

			//実行結果取得
			int rs = pStmt.executeUpdate();

			//実行できなかった場合
			if(rs != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		//実行できた場合
		return true;
	} //create()

	public List<Remind> findAll(User loginUser) { //リマインド一覧取得

		//空のArrayListの用意
		List<Remind> remindList = new ArrayList<>();

		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SQL文
			String sql = "SELECT ID, REMIND, CATEGORY FROM REMIND WHERE ID = ? ORDER BY REMIND_ID DESC";

			//SQL文送信
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SQL文に情報を渡す
			pStmt.setString(1, loginUser.getId());

			//結果を取得
			ResultSet rs = pStmt.executeQuery();

			//取得結果の繰り返し処理
			while(rs.next()) {

				//取得結果をArrayListに格納

				String id = rs.getString("ID");
				String remind = rs.getString("REMIND");
				String category = rs.getString("CATEGORY");

				Remind reminder = new Remind(id,remind,category);
				remindList.add(reminder);

			}


		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return remindList;
	}//findAll()
}
