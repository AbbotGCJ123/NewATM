package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateCommonUser {
	
	public void updateUser() {
		Scanner scanner = new Scanner(System.in);
		InTheUsers itu = new InTheUsers();
		File file = new File("document" + File.separator + "users.txt");
		System.out.println("请输入要修改的账号：");
		String accountNum = scanner.next();
		CommonUsers updateuser = null;
		ArrayList<CommonUsers> userlist = itu.greader(file);
		for (CommonUsers commonUsers : userlist) {
			if (commonUsers.getAccountNumber().equals(accountNum)) {
				updateuser = commonUsers;
				userlist.remove(updateuser);
				ArrayList<CommonUsers> nowlist = userlist;
				//  输入要修改的账号,并更新其中的,密码,姓名,学历,联系地址  
				System.out.println("请输入新密码：");
				String password = scanner.next();
				updateuser.setPassword(password);
				
				System.out.println("请输入新的姓名：");
				String username = scanner.next();
				updateuser.setUsername(username);
				
				System.out.println("请输入新的学历：(1代表  小学  2代表 中学  3代表大学 4代表其他)");
				int education = scanner.nextInt();
				updateuser.setEducation(education);
				
				System.out.println("请输入新的联系地址：(长度不得超过50)");
				String usersSite = scanner.next();
				updateuser.setUsersSite(usersSite);
				
				nowlist.add(updateuser);
				itu.fwrite(nowlist, file);
				System.out.println("修改完成，返回管理员菜单");
			}else {
				System.out.println("要修改的用户 不存在");
			}
		}
		
	}
}
