package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MemuBusiness {
	
	public void memu (CommonUsers user) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.存款       2.取款       3.转账业务       4.查看账户信息");
		System.out.println("请选择：");
		boolean bln = true;
		while (bln) {
			int selectNum = scanner.nextInt();
			if (selectNum == 1) {
				//存款
				bln = false;
				DepositBusiness db = new DepositBusiness();
				db.deposit(user);
			}else if (selectNum == 2) {
				//取款
				bln = false;
				WithdrawalBusiness wb = new WithdrawalBusiness();
				wb.widthdrawal(user);
			}else if (selectNum == 3) {
				//转账
				bln = false;
				TransferAccounts ta = new TransferAccounts();
				ta.transfer(user);
			}else if (selectNum == 4) {
				//查看账户信息
				bln = true;
				SaveWatercourseBusiness swb = new SaveWatercourseBusiness();
				InTheUsers itu = new InTheUsers();
				ArrayList<ArrayList<CommonUsers>> listlist = itu.greader1(new File("document" + File.separator + "Watercourse.txt"));
				for (ArrayList<CommonUsers> arrayList : listlist) {
					for (CommonUsers commonUsers : arrayList) {
						if(user.getUsername() == commonUsers.getUsername()) {
							System.out.println(commonUsers.getUserWatercourse());
						}else {
							System.out.println("无user");
						}
					}
				}
				System.out.println("显示完成，返回菜单！");
			}else {
				bln = true;
				System.out.println("输入错误，请从新输入：");
			}
		}
		
	}
}
