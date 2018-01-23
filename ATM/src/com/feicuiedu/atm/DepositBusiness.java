package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//储蓄业务
public class DepositBusiness {
	public void deposit(CommonUsers user){
		Scanner sca = new Scanner(System.in);
		ArrayList<CommonUsers> userlist = new InTheUsers().greader(new File("document" + File.separator + "users.txt"));
		boolean b = true;
		while(b){
			System.out.println("请输入要存入的金额：");
			int moneyNum = Integer.parseInt(sca.next());
			ToolsBusiness tb = new ToolsBusiness();
			if(tb.verifyMulriple(moneyNum)){
				SaveWatercourseBusiness swb = new SaveWatercourseBusiness();
				swb.saveWatercourse(userlist);
				System.out.println("存入金额满足 100 的倍数,可以存款");
				userlist.remove(user);
				user.setMoney(user.getMoney() + moneyNum);
				ArrayList<CommonUsers> nowlist = userlist;
				user.setUserWatercourse(user.getUsername() + "存入：" + moneyNum + "RMB");
				nowlist.add(user);
				new InTheUsers().fwrite(nowlist, new File("document" + File.separator + "users.txt"));
				System.out.println("存入成功，即将返回菜单");
				MemuBusiness mb = new MemuBusiness();
				mb.memu(user);
				b = false;
			}else{
				b = true;
				System.out.println("存入金额不合法，请从新输入要存入的金额！");
			}
		}
	}
}