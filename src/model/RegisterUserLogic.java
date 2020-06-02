package model;

import dao.AccountDAO;

public class RegisterUserLogic {
	public boolean execute(RegisterUser registerUser) {

		AccountDAO dao = new AccountDAO();
		dao.insert(registerUser);

		return true;

	}
}
