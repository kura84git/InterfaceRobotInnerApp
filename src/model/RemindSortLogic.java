package model;

import java.util.List;
import java.util.Set;

import dao.RemindSortDAO;

public class RemindSortLogic {
	public Set<Remind> findCategory(User loginUser) { //カテゴリ検索処理
		RemindSortDAO dao = new RemindSortDAO();
		return dao.findCategory(loginUser);
	}

	public List<Remind> sort(User loginUser, String specifiedCategory) { //カテゴリのソートでリマインドを取得する処理
		RemindSortDAO dao = new RemindSortDAO();
		return dao.sort(loginUser, specifiedCategory);
	}
}
