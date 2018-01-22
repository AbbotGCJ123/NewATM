package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		//创建用户
/*		NewUsers newuser = new NewUsers();
		newuser.createNewUser("123456", "王克峥", 1, "1234567", 1, 0, "123154567688621561264");*/
		InTheUsers itu = new InTheUsers();
		File file = new File("document" + File.separator + "users.txt");
		ArrayList<CommonUsers> fileList =  itu.greader(file);
		for(CommonUsers users:fileList) {
			System.out.println(users.toString());
		}
	}
}
