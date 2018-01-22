package com.feicuiedu.atm;
//工具类
public class ToolsBusiness{
	//判断输入的金额是否是100的倍数
	public boolean verifyMulriple(double fetchMoney){
		boolean bool = false;
		if(fetchMoney % 100 == 0){
			bool = true;
		}else{
			bool = false;
		}
		return bool;
	}
	//判断余额是否充足
	public boolean isNotSufficientFunds(CommonUsers user,double fetchMoney){
		boolean bool = false;
		if(fetchMoney<=user.getMoney()){
			bool = true;
		}else{
			bool = false;
		}
		return bool;
	}
}