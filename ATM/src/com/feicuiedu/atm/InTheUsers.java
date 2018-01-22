package com.feicuiedu.atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InTheUsers {
	
	//将创建的user 放到list集合中然后将这个集合通过ObjectOutputStream流写到文件中 
	public void fwrite(CommonUsers users,ArrayList<CommonUsers> userRAMList,File file) {
		
		//文件为空的时候
		if (file.exists() && file.length() == 0) {
			//将用户信息放到内存集合中
			userRAMList.add(users);
		}else {
			//文件 不为空   greader 通过去文件中获取， 获得一个新集合  ，将 新集合的内容付给 内存集合
			userRAMList = greader(file);
			//再添加一个新用户到内存集合， 此时内存集合中应该有两个或多个user用户 
			userRAMList.add(users);
		}
		
		try {
			
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//将内存集合写到文件中
			oos.writeObject(userRAMList);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fwrite(ArrayList<CommonUsers> userRAMList,File file) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//将内存集合写到文件中
			oos.writeObject(userRAMList);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//读取出users.txt中 的users  放到usersList中
	public ArrayList<CommonUsers> greader(File file) {
		//创建一个集合用来暂时存放从 文件中取出的用户
		ArrayList<CommonUsers> fileList = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			//将获取出来的内存集合放到暂时存放的集合filelist中
			@SuppressWarnings("unchecked")
			ArrayList<CommonUsers> readObject = (ArrayList<CommonUsers>) ois.readObject();
			fileList =readObject;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将这个存放了内存 集合的filelist 集合 返回出去
		return fileList;
	}
}
