 /*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.utility.IGStringUtils;

public class DateUtils {
	
	static Log log = LogFactory.getLog(DateUtils.class);

	public static String getCurrentYear() {
		return IGStringUtils.getCurrentDateTime().substring(0, 4);
	}

	public static String getCurrentMonth() {
		return IGStringUtils.getCurrentDateTime().substring(5, 7);
	}
	
	public static String getCurrentDate(){
		return IGStringUtils.getCurrentDateTime().substring(8, 10);
	}
	
	public static String getCurrentTime(){
		return IGStringUtils.getCurrentDateTime();
	}
	
	public static String getLoginTime(){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(c.getTimeInMillis() - 5*60*1000);
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
	    "yyyy/MM/dd HH:mm");
		return df.format(c.getTime()).substring(11,16);		
	}
	
	public static String getLogoutTime(){
		return IGStringUtils.getCurrentDateTime().substring(11, 16);
	}
	
	/**
	 * 判断当前日期为星期几（参数为“yyyyMMdd”）
	 * 
	 * @return 数字星期几
	 */
	public static boolean isWeekend(String nowDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			calendar.setTime(sdf.parse(nowDate));
		} catch (ParseException e) {
			log.error("解析日期异常：", e);
			return false;
		}
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 7 || dayOfWeek == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断当前年月有多少天 (参数格式“yyyyMM”)
	 * 
	 * @return 天数
	 */
	public static int MaxDaysOfMonth(String nowDate) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		try {
			c.setTime(sdf.parse(nowDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int d = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		System.out.println("max days is: " + d);
		return d;
	}
	
	  /**
	 * 比较时间 B-A
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	public static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		long timeNumber = 0;
		// 1小时=60分钟=3600秒=3600000
		long mins = 60L * 1000L;
		// long time= 24L * 60L * 60L * 1000L;计算天数之差
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(timeA);
		Date d2 = df.parse(timeB);
		timeNumber = (d2.getTime() - d1.getTime()) / mins;
		return (int) timeNumber;
	}

	/**
	 * 
	 * @param subDateTime 减数时间
	 * @param minDateTime 被减数时间
	 * @return
	 * @throws Exception
	 */
	public static long getTimeDifferenceByMinutes(String subDateTime, String minDateTime) {
		long result = 0l;
		//1分钟=60秒=60000毫秒
		long second = 60l * 1000l;//最后的除数
		//计算时间差默认的都是yyyy/MM/dd HH:mm的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			Date subtrahend = sdf.parse(subDateTime);
			Date minuend = sdf.parse(minDateTime);
			result = (minuend.getTime() - subtrahend.getTime()) / second;
		} catch (ParseException e) {
			log.debug("==========时间格式转换失败==========");
			e.printStackTrace();
		}
		return result;
	}

}
