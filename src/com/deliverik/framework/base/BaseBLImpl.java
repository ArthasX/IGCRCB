package com.deliverik.framework.base;

import java.util.Date;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.utility.ResourceUtility;


/**
 * Implementation of interface BaseBL. Used as the base class of all business logic processing classes.
 *
 *
 */
public class BaseBLImpl implements BaseBL {

	protected static FastDateFormat dateFormat = FastDateFormat.getInstance("yyyyMMdd");
	protected static FastDateFormat timeFormat = FastDateFormat.getInstance("HHmmss");
	protected static FastDateFormat dateTimeFormat = FastDateFormat.getInstance("yyyyMMddHHmmss");

	/** Static logger */
	static Log log = LogFactory.getLog(BaseBLImpl.class);


	/**
	 * <br>
	 *
	 * @param message 
	 * @throws IllegalStateException
	 */
	protected void throwSystemException(String message) throws IllegalStateException {

		throw new IllegalStateException(message);

	}

	/**
	 * 
	 * @param clsNm this.getClass().getSimpleName()
	 * @return 
	 */
	public String getFunctionID(String clsNm){

		String functionID = null;
		// 
		if(clsNm != null && clsNm.matches("^AD[A-Z]{3}F[0-9]{2}.*")){
			functionID = clsNm.substring(0,8);
		}
		return functionID;
	}

	/**
	 * 
	 * @param date 
	 * @return 
	 */
	public String getDateFormat(Date date){
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @param date 
	 * @return 
	 */
	public String getTimeFormat(Date date){
		return timeFormat.format(date);
	}

	/**
	 * 
	 * @param key 
	 * @return 
	 */
	public String getResourceProperty(String key){
		return ResourceUtility.getString(key);
	}

	/**
	 * 
	 * @param key 
	 * @param param 
	 * @return 
	 */
	public String getMessage(String key, String...param){
		return ResourceUtility.getMessage(key,param);
	}

	/**
	 * 
	 * @param dest 
	 * @param source 
	 */
	protected void copyProperties(Object dest, Object source){
		try {
			PropertyUtils.copyProperties(dest, source);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
