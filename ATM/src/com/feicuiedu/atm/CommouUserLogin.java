package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CommouUserLogin {
	
	public void cUserLog() {
		Scanner scanner =  new Scanner(System.in);
		InTheUsers itu = new InTheUsers();
		File file = new File("document" + File.separator + "users.txt");
		//先获取出来文件中的用户
		ArrayList<CommonUsers> userlist = itu.greader(file);
		System.out.println("请输入账号：(或身份证号)");
		boolean bool  = true;
		while (bool) {
			String accountNum = scanner.next();
			for(CommonUsers user:userlist) {
				if (user.getAccountNumber().equals(accountNum) || user.getIdCardNo().equals(accountNum)) {
					//账号或身份证号能跟文件中的匹配，开始验证密码
					bool = false;
					System.out.println("请输入密码：");
					boolean bool1 = true;
					while(bool1) {
						String password = scanner.next();
						if(user.getPassword().equals(password)) {
							//密码正确，可以进入菜单执行 业务
							bool1 = false;
							//调用菜单类
							MemuBusiness mb = new MemuBusiness();
							mb.memu(user);
						}else {
							//密码错误，重新输入
							bool1 = true;
							System.out.println("密码错误，请重新输入：");
						}
					}

				}else {
					bool = true;
					System.out.println("输入的账号或身份证号错误，请从新输入：");
				}
			}
		}
	}
}
