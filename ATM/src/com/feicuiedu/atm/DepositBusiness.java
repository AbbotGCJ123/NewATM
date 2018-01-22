package com.feicuiedu.atm;

import java.util.Scanner;

//储蓄业务
public class DepositBusiness {
	public void deposit(CommonUsers user){
		Scanner sca = new Scanner(System.in);
		boolean b = true;
		while(b){
			System.out.println("请输入要存入的金额：");
			int moneyNum = Integer.parseInt(sca.next());
			ToolsBusiness tb = new ToolsBusiness();
			if(tb.verifyMulriple(moneyNum)){
				System.out.println("存入金额满足 100 的倍数,可以存款");
				user.setMoney(user.getMoney() + moneyNum);
				
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