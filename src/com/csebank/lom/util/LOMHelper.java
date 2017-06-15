package com.csebank.lom.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.csebank.common.CodeValueBean;
import com.csebank.items.model.ItemsCodes;


public class LOMHelper {
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(System.currentTimeMillis());
	}
	
	public static String getCurrentYear() {
		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	/**
	 * 返回被截取后的数据
	 * @param doubleValue 被截取的数据
	 * @param scale 小数点后保留位数
	 * @return
	 */
	public static Double round(String sourcevalue, int scale){ 
		Double value = null; 
		String text = sourcevalue; 
		if(scale>2){
			scale = 2;
		}
		BigDecimal bd=new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP); 
		value = bd.doubleValue(); 
		return value; 
	}
	
	/**
	 * 返回被截取后的数据
	 * @param doubleValue 被截取的数据
	 * @param scale 小数点后保留位数
	 * @return
	 */
	public static BigDecimal roundForBigDecimal(String sourcevalue, int scale){ 
		String text = sourcevalue; 
		if(scale>2){
			scale = 2;
		}
		BigDecimal bd=new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP); 
		return bd; 
	}
	
	/**
	 * 根据传入参数获取其全部的下拉列表
	 */
	public static List<LabelValueBean> getItemsCodes(String selectid){
		List<ItemsCodes> list = CodeValueBean.getConfigInfo(selectid);
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		if(!CodeUtils.OUTSTOCK_STATUS.equals(selectid) ){
			codeList.add(new LabelValueBean("", ""));
		}
		for(Iterator<ItemsCodes> iter = list.iterator();iter.hasNext();){
			ItemsCodes itemsCodes = iter.next();
			codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
		}
		return codeList;
	}
	
	/**
	 * 返回传入参数之积
	 * @return
	 */
	public static BigDecimal getMultiply(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.multiply(bd2_b);
	}
	
	/**
	 * 返回传入参数之积
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
	 * 返回传入参数之积
	 * @return
	 */
	public static BigDecimal getMultiply(BigDecimal bd1,BigDecimal bd2){
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.multiply(bd2_b);
	}
	
	/**
	 * 返回传入参数之商
	 * @return
	 */
	public static BigDecimal getDivide(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32);
	}
	
	/**
	 * 返回传入参数之商
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
	 * 返回传入参数之商
	 * @return
	 */
	public static BigDecimal getDivide(BigDecimal bd1,BigDecimal bd2){
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32);
	}
	
	
	/**
	 * 返回传入参数之和
	 * @return
	 */
	public static BigDecimal getAdd(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.add(bd2_b);
	}
	
	/**
	 * 返回传入参数之和
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
	 * 返回传入参数之和
	 * @return
	 */
	public static BigDecimal getAdd(BigDecimal bd1,BigDecimal bd2){

		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.add(bd2_b);
	}
	
	/**
	 * 返回传入参数之差
	 * @return
	 */
	public static BigDecimal getSubtract(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.subtract(bd2_b);
	}
	
	/**
	 * 返回传入参数之差
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
	 * 返回传入参数之差
	 * @return
	 */
	public static BigDecimal getSubtract(BigDecimal bd1,BigDecimal bd2){
		
		BigDecimal bd1_b = new BigDecimal(String.valueOf(bd1)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		BigDecimal bd2_b = new BigDecimal(String.valueOf(bd2)).setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		return bd1_b.subtract(bd2_b);
	}
}
