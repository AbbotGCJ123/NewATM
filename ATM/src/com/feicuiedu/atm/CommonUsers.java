package com.feicuiedu.atm;

import java.io.Serializable;

public class CommonUsers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3761431761489991362L;
	/*
	 * 账户信息: 账号 系统自动生成 规则 37+(如果是男01,如果是女02)+当前时间(年月日时分秒毫秒) 密码
	 * 至少8位,数字和字母必须同时又,至少一个大写字母 姓名 长度小10 性别 存储 1:2 1代表男 2代表女
	 * 输入前显示提示信息,请务必确认正确,之后不可修改 身份证号 长度不大于18,不得重复 输入前显示提示信息,请务必确认正确,之后不可修改 学历 存储
	 * 1:2:3:4 1代表 小数 2代表 中学 3代表大学 4代表其他 余额 只能是整数或者小数 开户时默认为0(开户时不用输入) 联系地址 长度不得超过50
	 * 提示,验证全部提供过后,账号自动生成.生成之后要持久化,并支持 账号&身份证号登陆
	 */
	// 帐号
	private String accountNumber;
	// 密码
	private String password;
	// 用户名
	private String username;
	// 性别 1男 2女
	private int sex;
	// 身份证号
	private String idCardNo;
	// 学历
	private int education;
	// 钱 初始化 money = 0；
	private double money;
	// 地址ַ
	private String usersSite;

	public CommonUsers(String accountNumber, String password, String username, int sex, String idCardNo, int education,
			double money, String usersSite) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.username = username;
		this.sex = sex;
		this.idCardNo = idCardNo;
		this.education = education;
		this.money = money;
		this.usersSite = usersSite;
	}

	@Override
	public String toString() {
		return "CommonUsers [accountNumber=" + accountNumber + ", password=" + password + ", username=" + username
				+ ", sex=" + sex + ", idCardNo=" + idCardNo + ", education=" + education + ", money=" + money
				+ ", usersSite=" + usersSite + "]";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getUsersSite() {
		return usersSite;
	}

	public void setUsersSite(String usersSite) {
		this.usersSite = usersSite;
	}

}
