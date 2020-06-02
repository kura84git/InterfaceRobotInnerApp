package model;

import dao.RemindUpdateDAO;

public class RemindUpdateLogic {
	public void update(Remind remindUpdate) {
		RemindUpdateDAO dao = new RemindUpdateDAO();
		dao.update(remindUpdate);
	}
}
