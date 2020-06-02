package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Remind;
import model.User;

public class RemindSortDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/interface_robot_inner?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public Set<Remind> findCategory(User loginUser) {
		Set<Remind> categoryList = new HashSet<>();

		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT DISTINCT CATEGORY FROM REMIND WHERE ID = ? ORDER BY REMIND_ID DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, loginUser.getId());

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String category = rs.getString("CATEGORY");

				Remind categoryPiece = new Remind(category);
				categoryList.add(categoryPiece);

			}


		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return categoryList;
	}//findCategory()

	public List<Remind> sort(User loginUser, String specifiedCategory) {
		List<Remind> remindList = new ArrayList<>();

		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ID, REMIND, CATEGORY FROM REMIND WHERE ID = ? AND CATEGORY = ? ORDER BY REMIND_ID DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, loginUser.getId());
			pStmt.setString(2, specifiedCategory);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {

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
