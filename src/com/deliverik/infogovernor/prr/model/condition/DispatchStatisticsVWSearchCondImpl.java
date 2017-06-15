/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * 概述: 发文流程统计检索条件实现
  * 功能描述: 发文流程统计检索条件实现
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public class DispatchStatisticsVWSearchCondImpl implements
		DispatchStatisticsVWSearchCond {
	
	/** 用户名 */
	protected String dsusername;
	
	/** 查询条件开始时间 */
	protected String propentime_from;
	
	/** 查询条件结束时间 */
	protected String propentime_to;
	
	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getDsusername() {
		return dsusername;
	}

	/**
	 * 用户名设定
	 *
	 * @param dsusername 用户名
	 */
	public void setDsusername(String dsusername) {
		this.dsusername = dsusername;
	}

	/**
	 * 查询条件开始时间取得
	 *
	 * @return 查询条件开始时间
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * 查询条件开始时间设定
	 *
	 * @param propentime_from 查询条件开始时间
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * 查询条件结束时间取得
	 *
	 * @return 查询条件结束时间
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * 查询条件结束时间设定
	 *
	 * @param propentime_to 查询条件结束时间
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
	
	

}