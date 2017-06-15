/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 机构信息
 */
public class Organization implements OrganizationInfo {
	
	/** 时间戳 */
	private String fingerPrint;

	/** 所属机构名称 */
	private String orgname;

	/** 所属机构层次码 */
	private String orgsyscoding;
	
	/**
	 * 时间戳取得
	 * @return fingerPrint 时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 时间戳设定
	 * @param fingerPrint 时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 所属机构名称取得
	 *
	 * @return 所属机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 所属机构名称设定
	 *
	 * @param orgname 所属机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 所属机构层次码取得
	 *
	 * @return 所属机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}
	
	/**
	 * 所属机构层次码取得
	 *
	 * @param orgsyscoding 所属机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
}