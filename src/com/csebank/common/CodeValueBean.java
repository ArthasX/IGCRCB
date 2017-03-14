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
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(CodeValueBean.class);
	
	/** ϵͳ������Ϣ */
	private static HashMap<String, List<ItemsCodes>> codeValueMap = new HashMap<String, List<ItemsCodes>>();

	/** ���������ļ���ʶ */
	private static boolean init = false;

	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private CodeValueBean() {

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
