package com.deliverik.infogovernor.util;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.utility.ResourceUtility;

public class ASMHelper {

	public static boolean isChecked(String checkedValue, String checkboxValue) {
		if(null == checkedValue || "".equals(checkedValue)){
			return false;
		}
		if(checkedValue.contains("；")){
			List<String> checkedList = new ArrayList<String>();
			String[] checkedValues = checkedValue.split("；");
			for (int i = 0; i < checkedValues.length; i++) {
				checkedList.add(checkedValues[i]);
			}
			if(checkedList.contains(checkboxValue)){
				return true;
			}
		} else if(checkedValue.equals(checkboxValue)){
			return true;
		}
		return false;
	}
	
	/**
	 * 资产配置信息XML文件路径
	 */
	public static final String XML_FILE_PATH = ResourceUtility.getString("UPLOAD_XML_FILE_ROOT_PATH");
	
	/**
	 * 资产配置信息XML 起始KEY
	 */
	public static final String NODE_KEY = "001";
	/**
	 * 资产配置信息XML文件所属机构
	 */
	public static final String XML_FILE_ORG_ID = ResourceUtility.getString("XML_FILE_ORG_ID");

}
