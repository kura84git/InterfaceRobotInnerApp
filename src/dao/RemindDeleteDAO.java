package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Remind;
import model.User;

public class RemindDeleteDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interface_robot_inner?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";


	public boolean delete(User loginUser, Remind remindDelete) {
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "DELETE FROM REMIND WHERE ID = ? AND REMIND = ? AND CATEGORY = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, loginUser.getId());
			pStmt.setString(2, remindDelete.getRemind());
			pStmt.setString(3, remindDelete.getCategory());

			int rs = pStmt.executeUpdate();

			if(rs != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} //delete()

}
