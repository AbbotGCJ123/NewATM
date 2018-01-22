package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;



public class NewUsers {
	//创建用户
	 @SuppressWarnings("unused")
	public void createNewUser(String password,String username,int sex,String idCardNo,int education,
			 double money,String usersSite) {
		//使用正则表达式进行判断     账户信息     
		 if (true) {
			 
			 String accountNumber = "";

			 AcquireSystemTime ast = new AcquireSystemTime();
			 InTheUsers itu = new InTheUsers();
			 ArrayList<CommonUsers> userRAMList = new ArrayList<>();
			 File file = new File("document" + File.separator + "users.txt");
			 if (sex == 1) {
				 
				accountNumber = "37"+"01" +ast.getSystemTime();
				CommonUsers users = new CommonUsers
						(accountNumber, password, username, sex, idCardNo, education, money, usersSite);
				System.out.println("创建性别为男的用户成功 ！！");
				System.out.println("账号为：" + accountNumber);
				itu.fwrite(users,userRAMList,file);
				
			}else if (sex == 2) {
				
				accountNumber = "37"+"02" +ast.getSystemTime();
				CommonUsers users = new CommonUsers
						(accountNumber, password, username, sex, idCardNo, education, money, usersSite);
				System.out.println("创建性别为女的用户成功！！");
				System.out.println("账号为：" + accountNumber);
				itu.fwrite(users,userRAMList,file);
				
			}else {
				System.out.println("创建 用户失败");
			}
		}else {
			System.out.println("创建 用户信息输入错误，请重新输入");
		}
	 }
}
