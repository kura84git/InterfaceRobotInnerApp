package model;

import dao.RemindUpdateDAO;

public class RemindUpdateLogic {
	public boolean update(User loginUser, Remind remindUpdate, Remind specifiedRemindUpdate) { //リマインド書き換え処理
		RemindUpdateDAO dao = new RemindUpdateDAO();
		int remind_id = dao.select(loginUser, remindUpdate); //リマインドID取得処理
		return dao.update(loginUser, remind_id, specifiedRemindUpdate); //リマインド書き換え処理
	}
}
