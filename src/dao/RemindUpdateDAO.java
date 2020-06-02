package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Remind;
import model.User;

public class RemindUpdateDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interface_robot_inner?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public int select(User loginUser, Remind remindUpdate) {

		int remind_id = 0;

		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT REMIND_ID FROM REMIND WHERE ID = ? AND REMIND = ? AND CATEGORY = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, loginUser.getId());
			pStmt.setString(2, remindUpdate.getRemind());
			pStmt.setString(3, remindUpdate.getCategory());

			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				remind_id = rs.getInt("REMIND_ID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return remind_id;
	}//select()


	public boolean update(User loginUser, int remind_id, Remind specifiedRemindUpdate) {
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE REMIND SET REMIND = ?, CATEGORY= ? WHERE ID = ? AND REMIND_ID = ? ";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, specifiedRemindUpdate.getRemind());
			pStmt.setString(2, specifiedRemindUpdate.getCategory());
			pStmt.setString(3, loginUser.getId());
			pStmt.setInt(4, remind_id);


			int rs = pStmt.executeUpdate();

			if(rs != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} //update()

}
