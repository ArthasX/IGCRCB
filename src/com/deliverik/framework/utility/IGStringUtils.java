package com.deliverik.framework.utility;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.DateValidator;

/**
 *.<br>
 *
 *
 * org.apache.commons.lang.StringUtils
 *
 * @author 
 *
 * @see org.apache.commons.lang.StringUtils
 *
 */
public class IGStringUtils {

	/**  */
	static Log log = LogFactory.getLog(IGStringUtils.class);


	/**
	 * 
	 *
	 * @param str 
	 * @param bytes 
	 * @return true: OK false:NG
	 */
	public static boolean isValidBytes(String str, int bytes) {
		if( str ==null ) return true;
		try {
			//System.out.println(str + ":" + str.getBytes("UTF-8").length);
			return (bytes >= str.getBytes("UTF-8").length) ;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 *
	 * @param str 
	 * @param byteNum
	 * @return 
	 */
	public static String cutString(String str, int byteNum) {

		if( str == null ) return null;
		if( isValidBytes(str, byteNum) ) return str;

		int len = 0;
		while(true){
			len++;
			if( !isValidBytes(str.substring(0, len), byteNum) ){
				break;
			}
		}
		return str.substring(0, len-1);

	}

	/**
	 * RPAD
	 * 
	 * @param str 
	 * @param len 
	 * @return 
	 */
	public static String rpad(String str, int len) {
	    return fillString(str, "R", len, " ");
	}

	/**
	 * RPAD
	 * 
	 * @param str 
	 * @param len 
	 * @param padStr 
	 * @return 
	 */
	public static String rpad(String str, int len, String padStr) {
	    return fillString(str, "R", len, padStr);
	}

	/**
	 * LPAD
	 * 
	 * @param str
	 * @param len
	 * @param padStr
	 * @return 
	 */
	public static String lpad(String str, int len, String padStr) {
	    return fillString(str, "L", len, padStr);
	}


	/**
	 * 
	 * 
	 *
	 * 
	 * 
	 * @param str 
	 * @param position 
	 * @param len 
	 * @param addStr 
	 * @return 
	 */
	private static String fillString(String str, String position,
	        int len,
	        String addStr) {
	    if (addStr == null || addStr.length() == 0) {
	        throw new IllegalArgumentException
	            ("addStr="+addStr);
	    }
	    if (str == null) {
	        str = "";
	    }
	    StringBuffer buffer = new StringBuffer(str);
	    while (len > buffer.length()) {
	        if (position.equalsIgnoreCase("l")) {
	            int sum = buffer.length() + addStr.length();
	            if (sum > len) {
	                addStr = addStr.substring
	                    (0,addStr.length() - (sum - len));
	                buffer.insert(0, addStr);
	            }else{
	                buffer.insert(0, addStr);
	            }
	        } else {
	            buffer.append(addStr);
	        }
	    }
	    if (buffer.length() == len) {
	        return buffer.toString();
	    }
	    return buffer.toString().substring(0, len);
	}

	/**
	 * YYYYMMDD<br>
	 * [99999999]OK
	 *
	 * @param value
	 * @param allowAll0Flg ALL0
	 * @return
	 */
	public static boolean validateDate(String value, boolean allowAll0Flg) {

		if( "99999999".equals(value) ) return true;
		if( StringUtils.isEmpty(value)) return true;


		if( allowAll0Flg && "00000000".equals(value)) return true;

		if ( !DateValidator.getInstance().isValid(value, "yyyyMMdd", true)) {
			return false;
		}

		if( !Character.isDigit(value.charAt(value.length()-1) )){
			//
			return false;
		}

		// 
		int year = Integer.parseInt(value.substring(0, 4));
		if( year < 1900 || year > 2999 ){
			return false;
		}

		return true;
	}

	/**
	 * YYYYMMDD<br>
	 * 
	 *
	 * @param value
	 * @return 
	 */
	public static Calendar convertCalender(String value) {

		if(StringUtils.isEmpty(value) || "99999999".equals(value) || !validateDate(value, false))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(value));

		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		return cal;
	}

	/**
	 * <br>
	 *
	 * @param cal 
	 * @return 
	 */
	public static String convertDateStr(Calendar cal) {

		if(cal == null)
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date baseDate = cal.getTime();
		return sdf.format(baseDate);
	}


	/**
	 * format
	 *
	 * @param String "yyyy/mm/dd"
	 * @return String (yyyymmdd)
	 */
	public static String stringFormat(String date){

		String strDate = "";

		if ((date == null) || (date.trim().equals(""))) {
			return null;
		}

			strDate = date.substring(0,4) + date.substring(5,7) + date.substring(8,10);


		return strDate;
	}
	
	/**
	 * make a key
	 *
	 * @param  String
	 * @return String 
	 */
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static NumberFormat nf = NumberFormat.getInstance(Locale.CHINA);
    static{
        //设置最小整数位
        nf.setMinimumIntegerDigits(15);
        nf.setGroupingUsed(false);
    }
    private static long postfix = 0;//主键最后15位
	public static synchronized String getAttKey(){
		String id="";
		Date date=new Date();
		id=df.format(date);
		 
		if(postfix==999999999999999l){
		    postfix = 0;
		}else{
		    postfix++;
		}
		
		return id+nf.format(postfix);//不包含str为32位
		
	}
	
	
	/**
	 * make a SMS key
	 *
	 * @param  String
	 * @return String 
	 */
	private static SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static NumberFormat nf1 = NumberFormat.getInstance(Locale.CHINA);
    static{
        //设置最小整数位
        nf1.setMinimumIntegerDigits(9);
        nf1.setGroupingUsed(false);
    }
    private static long postfix1 = 0;//主键最后9位
	public static synchronized String getSmsKey(){
		String id="";
		Date date=new Date();
		id=df1.format(date);
		 
		if(postfix1==999999999l){
		    postfix1 = 0;
		}else{
		    postfix1++;
		}
		
		return id+nf1.format(postfix1);//不包含str为26位
		
	}
	
	/**
	 * <p>
	 * Description: 获取当前时间字符串(yyyy/MM/dd HH:mm)
	 * </p>
	 * 
	 * @return String
	 * @author liupeng@deliverik.com
	 */
	
	public static String getCurrentDateTime(){
		return CommonDefineUtils.DATETIME_FORMAT.format(new Date());
	}
	
	/**
	 * <p>
	 * Description: 获取当前日期字符串(yyyy/MM/dd)
	 * </p>
	 * 
	 * @return String
	 * @author liupeng@deliverik.com
	 */
	
	public static String getCurrentDate(){
		return CommonDefineUtils.DATE_FORMAT.format(new Date());
	}
	
	/**
	 * <p>
	 * Description: 获取当前年字符串(yyyy/MM/dd)
	 * </p>
	 * 
	 * @return String
	 * @author liupeng@deliverik.com
	 */
	
	public static String getCurrentYear(){
		return CommonDefineUtils.YEAR_FORMAT.format(new Date());
	}
	
	public static String filterXMLStr(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		StringBuffer buf = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '<') {
				buf.append("&lt;");
			} else if (ch == '>') {
				buf.append("&gt;");
			} else if (ch == '&') {
				buf.append("&amp;");
			} else if (ch == '"') {
				buf.append("&quot;");
			} else if (ch == '\'') {
				buf.append("&apos;");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}
}
