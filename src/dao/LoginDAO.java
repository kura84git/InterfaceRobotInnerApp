package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class LoginDAO {
	public boolean find(User user) {

		final String JDBC_URL = "jdbc:mysql://localhost:3306/interface_robot_inner?characterEncoding=utf-8&serverTimezone=JST";
		final String DB_USER = "root";
		final String DB_PASS = "root";

		try(Connection con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//データベースにつなぐ処理

			//セレクト文の準備
			String sql = "SELECT ID,PASS FROM ACCOUNT WHERE ID=? AND PASS=?";

			//SQL文を送る
			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPass());

			//SQL文を実行し結果を取得
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
