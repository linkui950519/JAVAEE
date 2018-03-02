package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PubFun {
	/**
	 * 
	* @Description: 获取当前系统时间
	* @author 柴含冰   
	* @date 2017年12月24日 下午4:21:00 
	* @version V1.0
	 */
	public static Date getDate() {
	 Date d = new Date();  
     System.out.println(d);  
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
     String dateNowStr = sdf.format(d);  
     System.out.println("格式化后的日期：" + dateNowStr);  
       
     String str = "2012-1-13 17:26:33";  //要跟上面sdf定义的格式一样  
     Date today = null;
	try {
		today = sdf.parse(str);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
     return today;
	}
	public static String getTime(){
		 Date d = new Date();  
	     System.out.println(d);  
	     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
	     String dateNowStr = sdf.format(d);  
 		return dateNowStr;
		
	}
	public static void main(String[] args) {
		PubFun aPubFun= new PubFun();
		System.out.println(aPubFun.getTime());
	}
}
