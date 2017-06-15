/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.model.condition;

/**
  * 概述: oracle性能采集检索条件实现
  * 功能描述: oracle性能采集检索条件实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public class EmSearchCondImpl implements
		EmSearchCond {
	
	/** 类型 */
	protected String em_type;
	
	/** 最大时间*/
	protected String max_collecttime;
	
	/** 总和倒序*/
	protected String order_Totail_desc;
	
	/** 实例查询 */
	protected String fingerprint;

	/**
	 * 类型取得
	 * @return em_type 类型
	 */
	public String getEm_type() {
		return em_type;
	}

	/**
	 * 类型设定
	 * @param em_type 类型
	 */
	public void setEm_type(String em_type) {
		this.em_type = em_type;
	}

	/**
	 * 最大时间取得
	 * @return max_collecttime 最大时间
	 */
	public String getMax_collecttime() {
		return max_collecttime;
	}

	/**
	 * 最大时间设定
	 * @param max_collecttime 最大时间
	 */
	public void setMax_collecttime(String max_collecttime) {
		this.max_collecttime = max_collecttime;
	}

	/**
	 * 总和倒序取得
	 * @return order_Totail_desc 总和倒序
	 */
	public String getOrder_Totail_desc() {
		return order_Totail_desc;
	}

	/**
	 * 总和倒序设定
	 * @param order_Totail_desc 总和倒序
	 */
	public void setOrder_Totail_desc(String order_Totail_desc) {
		this.order_Totail_desc = order_Totail_desc;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
}