package com.feicuiedu.atm;

import java.util.Scanner;

public class AdminUserLogin {
	

	public void adminLogin() {
		
		AdminUsers aUsers = new AdminUsers();
		Scanner scanner = new Scanner(System.in);
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
							System.out.println("1、注册普通 用户         2、删除普通用户     3、退出当前用户     4、修改用户");
							int scaNum1 = scanner.nextInt();
							if (scaNum1 == 1) {
								// 注册用户
								bool3 = false;
								NewUsers createuser = new NewUsers();
								System.out.println("账号随机生成-------");
								System.out.println("请设置密码：");
								String pw = scanner.next();
								System.out.println("请输入姓名：");
								String username = scanner.next();
								System.out.println("请输入性别：(1  表示男      2 表示女)");
								int sex = scanner.nextInt();
								System.out.println("请输入身份证号：");
								String idCardNo = scanner.next();
								System.out.println("请输入学历  (1代表  小学  2代表 中学  3代表  大学    4代表  其他)");
								int education = scanner.nextInt();
								System.out.println("请输入联系地址：(注：长度不可超过50 否则创建失败---)");
								String usersSite = scanner.next();
								createuser.createNewUser(pw, username, sex, idCardNo, education, 0, usersSite);
								bool3 = true;
							} else if (scaNum1 == 2) {
								// 删除普通用户；
								DeleteCommonUser  dc =  new DeleteCommonUser();
								dc.deleteUser();
								//删除后，返回到1、注册普通 用户         2、删除普通用户 界面  
								bool3 = true;
							}else if (scaNum1 == 3) {
								//退出当前用户
								LoginBusiness lb = new LoginBusiness();
								lb.login();
							}else if (scaNum1 == 4) {
								UpdateCommonUser uc = new UpdateCommonUser();
								uc.updateUser();
								bool3 = true;
							}else {
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
		}
	}
}
