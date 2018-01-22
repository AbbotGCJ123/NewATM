package com.feicuiedu.atm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AcquireSystemTime {
	// 获取系统 时间   年月日时分秒 毫秒 

	public String getSystemTime() {
		Date date = new Date();
		SimpleDateFormat sdfaccountNum = new SimpleDateFormat("YYYYMMddHHmmssSSS");
		String straccountNum = sdfaccountNum.format(date);
		return straccountNum;
	}
}
