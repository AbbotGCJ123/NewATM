package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WithdrawalBusiness{

	public void widthdrawal(CommonUsers user){
		Scanner sca = new Scanner(System.in);
		ArrayList<CommonUsers> userlist = new InTheUsers().greader(new File("document" + File.separator + "users.txt"));
		boolean b = true;
		while(b){
			System.out.println("请输入要取款的金额：");
			int fetchMoney = Integer.parseInt(sca.next());
			ToolsBusiness tb = new ToolsBusiness();
			//判断是否是100的倍数
			if(tb.verifyMulriple(fetchMoney)){
				//判断余额是否够取款的数目
				if(tb.isNotSufficientFunds(user,fetchMoney)){
					SaveWatercourseBusiness swb = new SaveWatercourseBusiness();
					swb.saveWatercourse(userlist);
					userlist.remove(user);
					ArrayList<CommonUsers> nowlist = userlist;
					double getmoney = user.getMoney();
					double setmoney = getmoney - fetchMoney;
					user.setMoney(setmoney);
					//取款成功后要把用户操作的信息存到文件中
					user.setUserWatercourse(user.getUsername() + "取出:" + fetchMoney +" RMB");
					nowlist.add(user);
					new InTheUsers().fwrite(nowlist, new File("document" + File.separator + "users.txt"));
					System.out.println("取款成功，返回菜单");
					MemuBusiness mb = new MemuBusiness();
					mb.memu(user);
					b = false;
				}else{
					b = true;
					System.out.println("余额不足，请从新输入取款金额！");
				}
			}else{
				System.out.println("输入的取款金额不合法，请从新输入！");
				b = true;
			}
		}
	}
}