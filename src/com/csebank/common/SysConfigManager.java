package com.csebank.common;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.items.bl.task.ItemsCodesBL;
import com.csebank.items.model.ItemsCodes;
import com.deliverik.framework.platform.WebApplicationSupport;

public class SysConfigManager {
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(SysConfigManager.class);
	
	/** ϵͳ������Ϣ */
	private static HashMap<String, String> configMap = new HashMap<String, String>();

	/** ���������ļ���ʶ */
	private static boolean init = false;

	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private SysConfigManager() {

	}

	/**
	 * <p>
	 * Discription:��ʼ������map
	 * </p>
	 * 
	 * @update liupeng@deliverik.com
	 */
	public static void init() {
		if (!init) {
			log.debug("������������ϵͳ������ʼ����ʼ������������");
			// ȡ����λϵͳ���ò���
			configMap.clear();
			
			ItemsCodesBL itemsCodesBL = (ItemsCodesBL) WebApplicationSupport.getBean("itemsCodesBL");
			List<ItemsCodes> itemsCodesList = itemsCodesBL.findAll();
			for (ItemsCodes itemsCodes : itemsCodesList) {
				configMap.put(itemsCodes.getSelectid() + "_" + itemsCodes.getTypecode(), 
						itemsCodes.getTypename());
			}
			init = true;
			log.debug("������������ϵͳ������ʼ������������������");
		}
	}

	/**
	 * <p>
	 * Description: ��ȡ������Ϣ
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
	 * Description: ���ò�����Ϣ
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
