package model;

import java.util.List;

import dao.RemindDAO;

public class PostRemindLogic {
	public void create(Remind remindLatest) {
		RemindDAO dao = new RemindDAO();
		dao.create(remindLatest);
	}

	public List<Remind> execute() {
		RemindDAO dao = new RemindDAO();
		List<Remind> remindList = dao.findAll();

		return remindList;
	}

}
