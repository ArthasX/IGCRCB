/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * 概述：应急日志信息表检索条件实现
 * 功能描述：应急日志信息表检索条件实现
 * 创建记录：2014/05/19
 * (1)升序与降序排序条件以EmergencyLogTB中的字段列为主且这里只是简单排序没涉及复杂关系
 * 修改记录：
 */
public class EmergencyLogSearchCondImpl implements EmergencyLogSearchCond {
	/**应急相关流程ID(完全匹配)*/
	protected String elprid_eq;
	/**日志信息类型(完全匹配)*/
	protected String ellitype_eq;
	
	protected String[] psdid_in;

	/**升序排序条件组*/
	protected String[] ascs;
	/**降序排序条件组*/
	protected String[] desc;
	
	protected Integer[] prid_in;
	
	
	/**
	 * @return the prid_in
	 */
	public Integer[] getPrid_in() {
		return prid_in;
	}
	/**
	 * @param prid_in the prid_in to set
	 */
	public void setPrid_in(Integer[] prid_in) {
		this.prid_in = prid_in;
	}
	/**
	 * Getter and Setter
	 */
	/**
	 * 应急相关流程ID(完全匹配)取得
	 * @return elprid_eq
	 */
	public String getElprid_eq() {
		return elprid_eq;
	}
	/**
	 * 应急相关流程ID(完全匹配)设定
	 * @param elprid_eq
	 */
	public void setElprid_eq(String elprid_eq) {
		this.elprid_eq = elprid_eq;
	}
	
	/**
	 * 日志信息类型(完全匹配)取得
	 * @return ellitype_eq
	 */
	public String getEllitype_eq() {
		return ellitype_eq;
	}
	/**
	 * 日志信息类型(完全匹配)设定
	 * @param ellitype_eq
	 */
	public void setEllitype_eq(String ellitype_eq) {
		this.ellitype_eq = ellitype_eq;
	}
	
	/**
	 * 升序排序条件组取得
	 * @return ascs
	 */
	public String[] getAscs() {
		return ascs;
	}
	/**
	 * 升序排序条件组设定
	 * @param ascs
	 */
	public void setAscs(String[] ascs) {
		this.ascs = ascs;
	}
	
	/**
	 * 降序排序条件组取得
	 * @return desc
	 */
	public String[] getDesc() {
		return desc;
	}
	/**
	 * 降序排序条件组设定
	 * @param desc
	 */
	public void setDesc(String[] desc) {
		this.desc = desc;
	}
	public String[] getPsdid_in() {
		return psdid_in;
	}
	public void setPsdid_in(String[] psdid_in) {
		this.psdid_in = psdid_in;
	}
}