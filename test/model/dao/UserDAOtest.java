package model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import model.entity.UserBean;

class UserDAOtest {

	@Test
	void adminのテスト() {

		UserDAO userdao = new UserDAO();
		UserBean flag = null;

		try {
			flag = userdao.select("admin", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals("admin", flag.getUser_id());
		assertEquals("admin", flag.getPassword());

	}
	
	@Test
	void エラーテスト() {

		UserDAO userdao = new UserDAO();
		UserBean user = null;

		try {
			user = userdao.select("admi", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertNull(user, "ユーザーが存在しないため null が返るはずです");
	}
	
	@Test
	void test1のテスト() {

		UserDAO userdao = new UserDAO();
		UserBean flag = null;

		try {
			flag = userdao.select("test1", "test1");
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals("test1", flag.getUser_id());
		assertEquals("test1", flag.getPassword());

	}
	
	@Test
	void test2のテスト() {

		UserDAO userdao = new UserDAO();
		UserBean flag = null;

		try {
			flag = userdao.select("test2", "test2");
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals("test2", flag.getUser_id());
		assertEquals("test2", flag.getPassword());

	}

}
