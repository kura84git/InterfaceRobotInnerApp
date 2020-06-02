package model;

import dao.RemindUpdateDAO;

public class RemindUpdateLogic {
	public boolean update(User loginUser, Remind remindUpdate, Remind specifiedRemindUpdate) {
		RemindUpdateDAO dao = new RemindUpdateDAO();
		int remind_id = dao.select(loginUser, remindUpdate);
		return dao.update(loginUser, remind_id, specifiedRemindUpdate);
	}
}
