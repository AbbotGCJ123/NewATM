package com.feicuiedu.atm;

import java.io.File;
import java.util.ArrayList;

public class SaveWatercourseBusiness {
	//获取到旧的user集合，然后旧的user集合将存到一个集合中，通过user中的一个属性，获得到每次更新的内容
	public void saveWatercourse(ArrayList<CommonUsers> userslist) {
		ArrayList<ArrayList<CommonUsers>> listlist = new ArrayList<>();
		InTheUsers itu = new InTheUsers();
		File file = new File("document" + File.separator + "Watercourse.txt");
		if (file.exists() && file.length() == 0) {
			listlist.add(userslist);
			itu.fwrite1(listlist, file);
		}else {
			ArrayList<ArrayList<CommonUsers>> filelist = itu.greader1(file);
			filelist.add(userslist);
			itu.fwrite1(filelist, file);
		}
		
	}
}
