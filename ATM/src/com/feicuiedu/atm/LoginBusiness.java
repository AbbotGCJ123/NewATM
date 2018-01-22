package com.feicuiedu.atm;

import java.util.Scanner;

public class LoginBusiness {

	public void login() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean bool = true;
		while (bool) {

			System.out.println("請選擇賬號類型:  (1、普通用戶     2、管理員)");
			int scaNum = scanner.nextInt();
			if (scaNum == 1) {
				// 普通用户
				bool = false;
				CommouUserLogin cLogin = new CommouUserLogin();
				cLogin.cUserLog();
			} else if (scaNum == 2) {
				// 管理员
					bool = false;
					AdminUserLogin adminLog = new AdminUserLogin();
					adminLog.adminLogin();
			}else {
				bool = true;
				System.out.println("輸入錯誤，请从新输入：");
			}

		}
	}
}
