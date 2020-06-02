package model;

import java.util.List;
import java.util.Set;

import dao.RemindSortDAO;

public class RemindSortLogic {
	public Set<Remind> findCategory(User loginUser) {
		RemindSortDAO dao = new RemindSortDAO();
		return dao.findCategory(loginUser);
	}

	public List<Remind> sort(User loginUser, String specifiedCategory) {
		RemindSortDAO dao = new RemindSortDAO();
		return dao.sort(loginUser, specifiedCategory);
	}
}
