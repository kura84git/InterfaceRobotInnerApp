package model;

import java.util.List;
import java.util.Set;

import dao.RemindSortDAO;

public class RemindSortLogic {
	public Set<Remind> findCategory() {
		RemindSortDAO dao = new RemindSortDAO();
		return dao.findCategory();
	}

	public List<Remind> sort(String specifiedCategory) {
		RemindSortDAO dao = new RemindSortDAO();
		return dao.sort(specifiedCategory);
	}
}
