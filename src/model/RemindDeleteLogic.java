package model;

import dao.RemindDeleteDAO;

public class RemindDeleteLogic {
	public boolean delete(User loginUser, Remind remindDelete) {
		RemindDeleteDAO dao = new RemindDeleteDAO();
		return dao.delete(loginUser, remindDelete);
	}
}
