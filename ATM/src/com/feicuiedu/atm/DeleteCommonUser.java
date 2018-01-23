package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteCommonUser {

	public void deleteUser() {
		InTheUsers itu = new InTheUsers();
		File file = new File("document" + File.separator + "users.txt");
		ArrayList<CommonUsers> userlist = itu.greader(file);
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你要删除的用户名和身份证号");
		System.out.println("用户名：");
		String userName = scanner.next();
		System.out.println("身份证号：");
		String useridCardNo = scanner.next();
		CommonUsers deleteUser = null ;
		//ArrayList<CommonUsers> deleteUserList = new ArrayList<>();
		for (CommonUsers commonUsers : userlist) {
			if (commonUsers.getUsername().equals(userName) && commonUsers.getIdCardNo().equals(useridCardNo)) {
				//deleteUserList.add(commonUsers);
				deleteUser = commonUsers;
				userlist.remove(deleteUser);
				ArrayList<CommonUsers> nowList = userlist;
				itu.fwrite(nowList, file);
				System.out.println("删除成功，返回管理员菜单");
			}else {
				System.out.println("用户不存在");
			}
		}
	}
}
