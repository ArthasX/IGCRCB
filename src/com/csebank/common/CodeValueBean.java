package com.csebank.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.items.bl.task.ItemsCodesBL;
import com.csebank.items.model.ItemsCodes;
import com.deliverik.framework.platform.WebApplicationSupport;

public class CodeValueBean {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(CodeValueBean.class);
	
	/** 系统参数信息 */
	private static HashMap<String, List<ItemsCodes>> codeValueMap = new HashMap<String, List<ItemsCodes>>();

	/** 加载属性文件标识 */
	private static boolean init = false;

	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private CodeValueBean() {

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
			
			ItemsCodesBL itemsCodesBL = (ItemsCodesBL) WebApplicationSupport.getBean("itemsCodesBL");
			List<ItemsCodes> itemsCodesList = itemsCodesBL.findAll();
			List<String> tempList = new ArrayList<String>();
			for (ItemsCodes itemsCodes : itemsCodesList) {
				String selectId = itemsCodes.getSelectid();
				
				if(!tempList.contains(selectId)){
					List<ItemsCodes> itemsCodesForIndexList = new ArrayList<ItemsCodes>();
					itemsCodesForIndexList.add(itemsCodes);
					codeValueMap.put(selectId, itemsCodesForIndexList);
					tempList.add(selectId);
				} else {
					List<ItemsCodes> itemsCodesForIndexList = codeValueMap.get(selectId);
					itemsCodesForIndexList.add(itemsCodes);
					codeValueMap.put(selectId, itemsCodesForIndexList);
				}
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
	public static List<ItemsCodes> getConfigInfo(String key) {
		if (!init) {
			init();
		}
		if (codeValueMap != null && !codeValueMap.isEmpty()) {
			return (List<ItemsCodes>) codeValueMap.get(key);
		}
		return null;
	}

}
