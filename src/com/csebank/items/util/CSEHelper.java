package com.csebank.items.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CSEHelper {
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(System.currentTimeMillis());
	}
	
	public static String getCurrentYear() {
		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	/**
	 * ���ر���ȡ�������
	 * @param doubleValue ����ȡ������
	 * @param scale С�������λ��
	 * @return
	 */
	public static Double round(String doubleValue, int scale){ 
		Double value = null; 
		String text = doubleValue; 
		BigDecimal bd=new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP); 
		value = bd.doubleValue(); 
		return value; 
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getMultiply(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.multiply(bd2_b);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static double getMultiply(Double bd1,Double bd2){
		if(bd1 == null) {
			bd1 = 0.0D;
		}
		if(bd2 == null) {
			bd2 = 0.0D;
		}
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)); 
		
		return bd1_b.multiply(bd2_b).doubleValue();
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getMultiply(BigDecimal bd1,BigDecimal bd2){
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.multiply(bd2_b);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getDivide(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static double getDivide(Double bd1,Double bd2){
		if(bd1 == null) {
			bd1 = 0.0D;
		}
		if(bd2 == null) {
			bd2 = 1.0D;
		}
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)); 
		
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32).doubleValue();
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getDivide(BigDecimal bd1,BigDecimal bd2){
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32);
	}
	
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getAdd(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.add(bd2_b);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static double getAdd(Double bd1,Double bd2){
		if(bd1 == null) {
			bd1 = 0.0D;
		}
		if(bd2 == null) {
			bd2 = 0.0D;
		}
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)); 
		
		return bd1_b.add(bd2_b).doubleValue();
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getAdd(BigDecimal bd1,BigDecimal bd2){

		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.add(bd2_b);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getSubtract(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.subtract(bd2_b);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static double getSubtract(Double bd1,Double bd2){
		if(bd1 == null) {
			bd1 = 0.0D;
		}
		if(bd2 == null) {
			bd2 = 0.0D;
		}
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)); 
		
		return bd1_b.subtract(bd2_b).doubleValue();
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	public static BigDecimal getSubtract(BigDecimal bd1,BigDecimal bd2){
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.subtract(bd2_b);
	}
}
