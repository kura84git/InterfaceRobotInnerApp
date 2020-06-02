package model;

import java.util.List;

import dao.RemindDAO;

public class PostRemindLogic {
	public void create(Remind remindLatest) { //リマインドの新規登録
		RemindDAO dao = new RemindDAO();
		dao.create(remindLatest);
	}

	public List<Remind> execute(User loginUser) { //リマインドの一覧取得
		RemindDAO dao = new RemindDAO();
		List<Remind> remindList = dao.findAll(loginUser);

		return remindList;
	}

}
