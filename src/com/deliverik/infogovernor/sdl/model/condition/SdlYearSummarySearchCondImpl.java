/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平统计查询MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlYearSummarySearchCondImpl implements SdlSummarySearchCond {

	/**年度*/
	protected String year;

	/**相关资产ID*/
	protected Integer eiid;

	/**资产名称 */
	protected String einame;
	
	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 设置年度
	 * @param year 年度
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设置相关资产ID
	 * @param eiid 相关资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 获取相关资产名字
	 * @return 相关资产名字
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设置相关资产名字
	 * @param einame 相关资产名字
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
}
