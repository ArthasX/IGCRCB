package com.deliverik.framework.utility;

import java.text.MessageFormat;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 应用资源文件（ApplicationResources）处理
 *
 * @author 
 *
 */
public class ResourceUtility {

	/** 应用资源文件名 */
	public static final String RESOURCE_FILE = "SystemConfigResources";
	/** 应用资源文件 */
	public static ResourceBundle resources;
	/** 应用资源文件LOG */
	static Log log = LogFactory.getLog(ResourceUtility.class);

	static {
		try {
			resources = PropertyResourceBundle.getBundle(RESOURCE_FILE);
		} catch (Exception e) {
			log.error("应用资源文件读取错误", e);
		}
	}

	/**
	 * 应用资源文件变量读取
	 * @param key 变量名
	 * @return 变量值
	 */
	public static String getString(String key){
		return resources.getString(key);
	}

	/**
	 * 应用资源文件信息定义读取
	 * @param key 信息KEY
	 * @param param 
	 * @return 
	 */
	public static String getMessage(String key, String... param){
		return MessageFormat.format(resources.getString(key), (Object[])param);
	}

}
