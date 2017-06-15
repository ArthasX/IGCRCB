package com.csebank.common;

import com.deliverik.framework.utility.ResourceUtility;

public class TopOrgValueBean {
	
	/** 系统参数信息 */
	private static String topOrg = "";
	private static String xbOrg = "";
	private static String stOrg = "";

	/** 加载属性文件标识 */
	private static boolean init = false;
	private static boolean xbinit = false;
	private static boolean stinit = false;

	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private TopOrgValueBean() {

	}

	/**
	 * <p>
	 * Discription:初始化参数map
	 * </p>
	 * 
	 * @update sunkaiyu@deliverik.com
	 */
	public static void init() {
		if (!init) {
			topOrg = ResourceUtility.getString("TOP_ORG");
			init = true;
		}
	}
	public static void xbinit() {
		if (!xbinit) {
			xbOrg = ResourceUtility.getString("XB_ORG");
			xbinit = true;
		}
	}
	public static void stinit() {
		if (!stinit) {
			stOrg = ResourceUtility.getString("ST_ORG");
			stinit = true;
		}
	}

	/**
	 * <p>
	 * Description: 获取参数信息
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update sunkaiyu@deliverik.com
	 */
	public static String getTopOrg() {
		if (!init) {
			init();
		}
		return topOrg;
	}
	
	public static String getXbOrg() {
		if (!xbinit) {
			xbinit();
		}
		return xbOrg;
	}
	
	public static String getStOrg() {
		if (!stinit) {
			stinit();
		}
		return stOrg;
	}

}
