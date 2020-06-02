package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Remind;

public class RemindUpdateDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interface_robot_inner?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public boolean update(Remind remindUpdate) {
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE REMIND SET REMIND = ?, CATEGORY= ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, remindUpdate.getRemind());
			pStmt.setString(2, remindUpdate.getCategory());

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
