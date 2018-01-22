package com.feicuiedu.atm;

import java.io.PrintStream;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class LoginBusiness {
	private PrintStream out;

	public void login() {
		Scanner scanner = new Scanner(System.in);
		boolean bool = true;
		while (bool) {

			System.out.println("請選擇賬號類型:  (1、普通用戶     2、管理員)");
			int scaNum = scanner.nextInt();
			if (scaNum == 1) {
				// 普通用户
				bool = false;
			} else if (scaNum == 2) {
				// 管理员
				AdminUsers aUsers = new AdminUsers();
				boolean bool1 = true;
				while (bool1) {
					System.out.println("请输入管理员帐号:");
					String userNum = scanner.next();
					if (userNum.equals(aUsers.getAdminAccountNumber())) {
						// 帐号正确
						bool1 = false;
						boolean bool2 = true;
						while (bool2) {
							System.out.println("请管理员输入密码：");
							String password = scanner.next();
							if (password.equals(aUsers.getAdminPassWord())) {
								// 密码正确
								bool2 = false;
								System.out.println("当前用户：" + aUsers.getAdminName());
								boolean bool3 = true;
								while (bool3) {
									System.out.println("1、注册普通 用户         2、删除普通用户");
									int scaNum1 = scanner.nextInt();
									if (scaNum1 == 1) {
										// 注册用户
										bool3 = false;
										NewUsers createuser = new NewUsers();
										System.out.println("");
										//createuser.createNewUser(password, username, sex, idCardNo, education, money, usersSite);
									} else if (scaNum1 == 2) {
										// 删除普通用户
										bool3 = false;
									} else {
										bool3 = true;
										System.out.println("输入错误！请从新选择：");
									}
								}
							}

							else {
								bool2 = true;
								System.out.println("密码错误，请从新输入密码：");
							}
						}
					} else {
						bool1 = true;
						System.out.println("管理员帐号错误，请从新输入");
					}
					bool = false;
				}

			} else {
				bool = true;
				System.out.println("輸入錯誤，请从新输入：");
			}

		}
	}
}
