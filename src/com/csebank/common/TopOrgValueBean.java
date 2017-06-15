package com.csebank.common;

import com.deliverik.framework.utility.ResourceUtility;

public class TopOrgValueBean {
	
	/** ϵͳ������Ϣ */
	private static String topOrg = "";
	private static String xbOrg = "";
	private static String stOrg = "";

	/** ���������ļ���ʶ */
	private static boolean init = false;
	private static boolean xbinit = false;
	private static boolean stinit = false;

	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private TopOrgValueBean() {

	}

	/**
	 * <p>
	 * Discription:��ʼ������map
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
	 * Description: ��ȡ������Ϣ
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
