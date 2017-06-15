/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控对象信息检索条件实现
  * 功能描述: 监控对象信息检索条件实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public class MonitorObjectSearchCondImpl implements
		MonitorObjectSearchCond {

	/**
	 * 层次码
	 */
	protected String mtSyscoding;
	
	/**
	 * 监控对象名称
	 */
	protected String moName;
	
	/**
	 * 创建时间从
	 */
	protected String moCreateTime_from;
	
	/**
	 * 创建时间到
	 */
	protected String moCreateTime_to;

	/**
	 * 监控对象名称获取
	 * @return
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * 监控对象名称设定
	 * @param moName
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}

	/**
	 * 创建时间到获取
	 * @return
	 */
	public String getMoCreateTime_to() {
		return moCreateTime_to;
	}
	
	/**
	 * 创建时间到设定
	 * @return
	 */
	public void setMoCreateTime_to(String moCreateTime_to) {
		this.moCreateTime_to = moCreateTime_to;
	}

	/**
	 * 创建时间从获取
	 * @return
	 */
	public String getMoCreateTime_from() {
		return moCreateTime_from;
	}

	/**
	 * 创建时间从设定
	 * @return
	 */
	public void setMoCreateTime_from(String moCreateTime_from) {
		this.moCreateTime_from = moCreateTime_from;
	}

	/**
	 * 层次码获取
	 * @return
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * 层次码设定
	 * @param mtSyscoding
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}
	
}