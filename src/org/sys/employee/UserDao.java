package org.sys.employee;

import java.util.ArrayList;
import java.util.List;

/*** 这个类用于存储用户数据
* @author Kuronitz
* @version 1.5
*/

public class UserDao {
	private static List<User> userList;

	public static List<User> getUserList() {
		return userList;
	}

	static {
		User user = new User();
		user.setuName("123456789");
		user.setPsw("Admin");
		userList = new ArrayList<User>();
		userList.add(user);
	}

	public static Boolean checkeUser(String uname, String psw) {
		Boolean ret = false;
		for (User user : userList) {
			if (user.getuName().equals(uname) && user.getPsw().equals(psw)) {
				ret = true;
				break;
			}
		}
		return ret;
	}

	public static User addUser(User user) {
		User ret = null;
		userList.add(user);
		ret = user;
		return ret;
	}
}
