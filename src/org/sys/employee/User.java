package org.sys.employee;

/*** 这个类是用户类
* @author Kuronitz
* @version 1.5
*/

public class User {
	private String uname;
	private String psw;

	public User() {

	}

	public String getuName() {
		return uname;
	}

	public void setuName(String uname) {
		this.uname = uname;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
}
