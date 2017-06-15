/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 机构信息
 */
public interface OrganizationInfo {
	
	/**
	 * 时间戳取得
	 * @return fingerPrint 时间戳
	 */
	public String getFingerPrint();
	
	/**
	 * 机构名称取得
	 *
	 * @return 机构名称
	 */
	public String getOrgname();
	
	/**
	 * 所属机构层次码取得
	 *
	 * @return 所属机构层次码
	 */
	public String getOrgsyscoding();
}