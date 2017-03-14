package com.csebank.common;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.items.bl.task.ItemsCodesBL;
import com.csebank.items.model.ItemsCodes;
import com.deliverik.framework.platform.WebApplicationSupport;

public class SysConfigManager {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(SysConfigManager.class);
	
	/** 系统参数信息 */
	private static HashMap<String, String> configMap = new HashMap<String, String>();

	/** 加载属性文件标识 */
	private static boolean init = false;

	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private SysConfigManager() {

	}

	/**
	 * <p>
	 * Discription:初始化参数map
	 * </p>
	 * 
	 * @update liupeng@deliverik.com
	 */
	public static void init() {
		if (!init) {
			log.debug("＝＝＝＝＝＝系统参数初始化开始＝＝＝＝＝＝");
			// 取出单位系统配置参数
			configMap.clear();
			
			ItemsCodesBL itemsCodesBL = (ItemsCodesBL) WebApplicationSupport.getBean("itemsCodesBL");
			List<ItemsCodes> itemsCodesList = itemsCodesBL.findAll();
			for (ItemsCodes itemsCodes : itemsCodesList) {
				configMap.put(itemsCodes.getSelectid() + "_" + itemsCodes.getTypecode(), 
						itemsCodes.getTypename());
			}
			init = true;
			log.debug("＝＝＝＝＝＝系统参数初始化结束＝＝＝＝＝＝");
		}
	}

	/**
	 * <p>
	 * Description: 获取参数信息
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update liupeng@deliverik.com
	 */
	public static String getConfigInfo(String key) {
		if (!init) {
			init();
		}
		if (configMap != null && !configMap.isEmpty()) {
			if(configMap.get(key)!=null){
				return (String) configMap.get(key);
			}else{
				return "";
			}
			
		}
		return "";
	}

	/**
	 * <p>
	 * Description: 设置参数信息
	 * </p>
	 * 
	 * @param key
	 * @update liupeng@deliverik.com
	 */
	public static void setConfigInfo(String key, String value) {
		if (init) {
			configMap.put(key, value);
		}
	}
}
