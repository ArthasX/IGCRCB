/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.deliverik.framework.base.BLException;

/**
 * @Description: 工具类
 * @Author  
 * @History 2009-8-19     新建 
 * @Version V2.0
 */
public class SVCHelper {

	public static String getImgPath(String prurgency, String prtype) {
		if ("I".equals(prtype)) {
			if ("I".equalsIgnoreCase(prurgency)
					|| "J".equalsIgnoreCase(prurgency)
					|| "K".equalsIgnoreCase(prurgency)) {
				return "H";
			} else if ("H".equalsIgnoreCase(prurgency)
					|| "G".equalsIgnoreCase(prurgency)) {
				return "G";
			}
		}
		return prurgency;
	}
	
	/**
	 * 计算每个月最大天数
	 * @param year
	 * @param month
	 * @return 最大天数
	 */
	public static int getMaxDayForMonth(int year,int month){
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 计算两个时间间隔日期(不包含开始日期和结束日期)
	 * @param startTime  开始时间
	 * @param endTime   结束时间
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getSubTime(String startTime,String endTime) throws ParseException{
		SimpleDateFormat timeSf = new SimpleDateFormat("yyyy/MM/dd HH:ss");
		SimpleDateFormat daySf = new SimpleDateFormat("yyyy/MM/dd");
		List<String> dayList = new ArrayList<String>();
		long subDay = 0;
		Date sDate = timeSf.parse(startTime);
		Date eDate = timeSf.parse(endTime);
		subDay = (eDate.getTime() - sDate.getTime())/(1000*3600*24);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(sDate);
		for(int i=0;i<subDay;i++){
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			dayList.add(daySf.format(calendar.getTime()));
			System.out.println(i +"  "+daySf.format(calendar.getTime()));
		}
		return dayList;
	}
	
	/**
	 * 计算两个时间间隔分钟数
	 * @param startTime  开始时间
	 * @param endTime   结束时间
	 * @return
	 * @throws ParseException
	 */
	public static int calculateTime(String startTime,String endTime) throws BLException{
		try {
			SimpleDateFormat timeSf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date sDate = timeSf.parse(startTime);
			Date eDate = timeSf.parse(endTime);
			int subMin = (int)(eDate.getTime() - sDate.getTime())/(1000*60);
			if(subMin<0){
				subMin= 0;
			}
			return subMin;
		} catch (ParseException e) {
			throw new BLException(e.getMessage());
		}
	}
	
	/**
	 * 格式日期
	 * @param dateTime 时间
	 * @param sformatStr 原始格式
	 * @param tformatStr 目标格式
	 * @return
	 * @throws ParseException
	 */
	public static String formatDate(String dateTime,String sformatStr,String tformatStr) throws BLException{
		try {
			SimpleDateFormat sformat = new SimpleDateFormat(sformatStr);
			SimpleDateFormat tformat = new SimpleDateFormat(tformatStr);
			return tformat.format(sformat.parse(dateTime));
		} catch (ParseException e) {
			throw new BLException(e.getMessage());
		}
	}
	


	/**
	 * 判断是否为周末
	 * @param year
	 * @param month
	 * @param day
	 * @return boolean
	 */
	public static boolean getWeekend(int year,int month,int day){
		Calendar calendar=new GregorianCalendar();
		calendar.set(year, month, day);
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		if(weekDay==7||weekDay==1){
			return true;
		}
		return false;
	}
	/**
	 * 返回被截取后的数据
	 * @param doubleValue 被截取的数据
	 * @param scale 小数点后保留位数
	 * @return
	 */
	public static double round(double doubleValue, int scale){ 
		double value = 0.0; 
		BigDecimal bd=new BigDecimal(doubleValue).setScale(scale, BigDecimal.ROUND_HALF_UP); 
		value = bd.doubleValue(); 
		return value; 
	}
	
	/**
	 * 返回传入参数之积
	 * @return
	 */
	public static double getMultiply(double bd1,double bd2){
		BigDecimal bd1_b = new BigDecimal(bd1);
		BigDecimal bd2_b = new BigDecimal(bd2);
		return bd1_b.multiply(bd2_b).doubleValue();
	}
	
	/**
	 * 返回传入参数之商
	 * @return
	 */
	public static double getDivide(double bd1,double bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32).doubleValue();
	}

	/**
	 * 返回传入参数之和
	 * @return
	 */
	public static double getAdd(double bd1,double bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		return bd1_b.add(bd2_b).doubleValue();
	}
	
	/**
	 * 返回传入参数之差
	 * @return
	 */
	public static double getSubtract(double bd1,double bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		return bd1_b.subtract(bd2_b).doubleValue();
	}

}
