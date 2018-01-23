package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TransferAccounts {
//转账
	public void transfer(CommonUsers loginUser) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean bool = true;
		while (bool) {
			
			System.out.println("请输入转账账号：");
			String transferAccountNum = scanner.next();
			InTheUsers itu = new InTheUsers();
			File file = new File("document" + File.separator + "users.txt");
			ArrayList<CommonUsers> userlist = itu.greader(file);
			
			for(CommonUsers transferUser:userlist) {
				if(transferUser.getAccountNumber().equals(transferAccountNum) || transferUser.getIdCardNo().equals(transferAccountNum)) {
					//如果输入的转账用户与文件中的用户有存在，则可以进行转账
					bool = false;
					System.out.println("请输入转账金额：");
					boolean bool1 = true;
					while (bool1) {
						double transferMoney = scanner.nextDouble();
						ToolsBusiness tb = new ToolsBusiness();
						boolean bln = tb.verifyMulriple(transferMoney);
						boolean bln2 = tb.isNotSufficientFunds(loginUser, transferMoney);
						//判断输入的转账金额是否是100的倍数    并且还得小于余额   可以执行转账业务
						if (bln && bln2) {
							bool1 = false;
							transferUser.setMoney(transferUser.getMoney() + transferMoney); 
							loginUser.setMoney(loginUser.getMoney() + transferMoney);
							//将没更新的旧集合存放到一个集合中保存下来
							SaveWatercourseBusiness swb = new SaveWatercourseBusiness();
							swb.saveWatercourse(userlist);
							System.out.println("转账成功！");
							//将原来文件中的被转账的用户移除
							userlist.remove(transferUser);
							userlist.remove(loginUser);
							itu.fwrite(userlist, file);
							//再将移除后的剩下的对象  给arraylist
							ArrayList<CommonUsers> arrayList = itu.greader(file);
							//将操作完成后的流水从新给user的属性赋值
							loginUser.setUserWatercourse(loginUser.getUsername() + "转给" + transferUser.getUsername() + transferMoney + "RMB");
							transferUser.setUserWatercourse(transferUser.getUsername() + "收到" + loginUser.getUsername() + transferMoney + "RMB");
							//然后再将被转账的用户加入到arraylist 集合中，完成对对象的重新赋值
							arrayList.add(transferUser);
							arrayList.add(loginUser);
							itu.fwrite(arrayList, file);
							System.out.println("返回菜单");
							MemuBusiness mb = new MemuBusiness();
							mb.memu(loginUser);
						}else {
							bool1 = true;
							bool = true;
							System.out.println("输入金额有误，请从新输入");
						}
					}
					
				}else {
					bool =true;
					System.out.println("该用户不存在！请重新输入:");
				}
			}
		}
	}
}
