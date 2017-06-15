 /*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
	 * �жϵ�ǰ����Ϊ���ڼ�������Ϊ��yyyyMMdd����
	 * 
	 * @return �������ڼ�
	 */
	public static boolean isWeekend(String nowDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			calendar.setTime(sdf.parse(nowDate));
		} catch (ParseException e) {
			log.error("���������쳣��", e);
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
	 * �жϵ�ǰ�����ж����� (������ʽ��yyyyMM��)
	 * 
	 * @return ����
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
	 * �Ƚ�ʱ�� B-A
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	public static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		long timeNumber = 0;
		// 1Сʱ=60����=3600��=3600000
		long mins = 60L * 1000L;
		// long time= 24L * 60L * 60L * 1000L;��������֮��
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(timeA);
		Date d2 = df.parse(timeB);
		timeNumber = (d2.getTime() - d1.getTime()) / mins;
		return (int) timeNumber;
	}

	/**
	 * 
	 * @param subDateTime ����ʱ��
	 * @param minDateTime ������ʱ��
	 * @return
	 * @throws Exception
	 */
	public static long getTimeDifferenceByMinutes(String subDateTime, String minDateTime) {
		long result = 0l;
		//1����=60��=60000����
		long second = 60l * 1000l;//���ĳ���
		//����ʱ���Ĭ�ϵĶ���yyyy/MM/dd HH:mm�ĸ�ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			Date subtrahend = sdf.parse(subDateTime);
			Date minuend = sdf.parse(minDateTime);
			result = (minuend.getTime() - subtrahend.getTime()) / second;
		} catch (ParseException e) {
			log.debug("==========ʱ���ʽת��ʧ��==========");
			e.printStackTrace();
		}
		return result;
	}

}
