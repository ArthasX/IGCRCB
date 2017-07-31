package com.deliverik.infogovernor.wim.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.deliverik.framework.utility.IGStringUtils;

public class IGDateUtils {

	private static Calendar calendar;

	/**
	 * 根据日期获得所在周的日期 ,返回list<Date>
	 * @param date 2016/06/20
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<Date> dateToWeek(String date) {
		Calendar cal = Calendar.getInstance();  		
		Date mdate = new Date(date);
		cal.setTime(mdate);  
        cal.add(Calendar.DAY_OF_MONTH, -1);  
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设定一个礼拜的第一天为周一
		int b = cal.get(Calendar.DAY_OF_WEEK);
		Date fdate;
		List<Date> list = new ArrayList<Date>();
		Long fTime = mdate.getTime() - b * 24 * 3600000;
		for (int a = 1; a <= 7; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			list.add(a-1, fdate);
		}
		return list;
	}
	/**
	 * 根据日期获得所在周的日期 ,返回list<String> 01-01
	 * @param date 2016/06/20
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> dateToWeekStr(String date) {
		Calendar cal = Calendar.getInstance();  		
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");  
		Date mdate = new Date(date);
		cal.setTime(mdate);  
        cal.add(Calendar.DAY_OF_MONTH, -1);  
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设定一个礼拜的第一天为周一
		int b = cal.get(Calendar.DAY_OF_WEEK);
		Date fdate;
		List<String> list = new ArrayList<String>();
		list.add(IGStringUtils.getCurrentYear());
		Long fTime = mdate.getTime() - b * 24 * 3600000;
		for (int a = 1; a <= 7; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			String str=sdf.format(fdate);
			list.add(str);
		}
		list.add(IGStringUtils.getCurrentDate());
		return list;
	}
	/**
	 * 根据日期获得所在周的日期 ,返回list<String>2017-01-01
	 * @param date 2016/06/20
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> dateToWeekYear(String date) {
		Calendar cal = Calendar.getInstance();  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
		Date mdate = new Date(date);
		cal.setTime(mdate);  
        cal.add(Calendar.DAY_OF_MONTH, -1);  
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设定一个礼拜的第一天为周一
		int b = cal.get(Calendar.DAY_OF_WEEK);
		Date fdate;
		List<String> list = new ArrayList<String>();
		Long fTime = mdate.getTime() - b * 24 * 3600000;
		for (int a = 1; a <= 7; a++) {
			fdate = new Date();
			fdate.setTime(fTime + (a * 24 * 3600000));
			String str=sdf.format(fdate);
			list.add(str);
		}
		return list;
	}
	
	/**
	 * 根据日期获得所在周几 
	 * @param date 2016/06/20
	 * @return {"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"} 周一到周日
	 */
	@SuppressWarnings("deprecation")
	public static int dateToWeekByNum(String date) {	   
		Calendar cal = Calendar.getInstance();  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
		Date mdate = new Date(date);
		cal.setTime(mdate);  
        cal.add(Calendar.DAY_OF_MONTH, -1);  
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设定一个礼拜的第一天为周一
		int b = cal.get(Calendar.DAY_OF_WEEK);
		return b;
	}
	
	/**
	 * 根据日期和周几获得所在的日期 ,
	 * @param date 2016/06/20
	 * @return 日期
	 */
	@SuppressWarnings("deprecation")
	public static String getdateToWeek(String date,int week) {
		Calendar cal = Calendar.getInstance();  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
		Date mdate = new Date(date);
		cal.setTime(mdate);  
        cal.add(Calendar.DAY_OF_MONTH, -1);  
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设定一个礼拜的第一天为周一
		int b = cal.get(Calendar.DAY_OF_WEEK);
		Date fdate;
		Long fTime = mdate.getTime() - b * 24 * 3600000;
		fdate = new Date();
		fdate.setTime(fTime + ((week+1) * 24 * 3600000));
		String str=sdf.format(fdate);
		return str;
	}
	
	/**
	 * 根据日期找到上一周的日期,
	 * @param date 2016/06/20
	 * @return 日期
	 */
	public static String getbeforeweekDate(String date) {
		 Calendar calendar = Calendar.getInstance(); 
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
		 Date mdate = new Date(date);
	     calendar.setTime(mdate); 
	     calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-7);
	     Date fdate = calendar.getTime();
	     String str=sdf.format(fdate);
	     return  str;

	}
	
	
}
