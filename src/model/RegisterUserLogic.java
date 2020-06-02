package model;

import dao.AccountDAO;

public class RegisterUserLogic {
	public boolean execute(RegisterUser registerUser) { //アカウント登録処理

		AccountDAO dao = new AccountDAO();
		dao.insert(registerUser);

		return true;

	}
}
