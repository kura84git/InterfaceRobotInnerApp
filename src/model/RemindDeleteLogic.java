package model;

import dao.RemindDeleteDAO;

public class RemindDeleteLogic {
	public boolean delete(User loginUser, Remind remindDelete) { //リマインド削除処理
		RemindDeleteDAO dao = new RemindDeleteDAO();
		return dao.delete(loginUser, remindDelete);
	}
}
