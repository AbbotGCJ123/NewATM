package com.feicuiedu.atm;

public class AdminUsers {
//	  默认银行账号370120180104
//	  默认银行密码123456
//	  默认名字:翡翠侠  
	private String adminName = "翡翠侠";
	private String adminAccountNumber = "370120180104";
	private String adminPassWord = "123456";
	//只提供 get 方法，不可以修改
	public String getAdminName() {
		return adminName;
	}
	
	public String getAdminAccountNumber() {
		return adminAccountNumber;
	}

	public String getAdminPassWord() {
		return adminPassWord;
	}
}
