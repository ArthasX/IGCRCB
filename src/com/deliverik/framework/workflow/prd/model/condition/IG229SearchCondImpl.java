/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.framework.workflow.prd.model.condition;

 /**
  * 概述:流程评审详细记录表Cond实体
  * 功能描述：
  *           
  * 创建记录：wangxiaoqiang    2010/11/29
  */
public class IG229SearchCondImpl implements
		IG229SearchCond {
	/**
	 *流程ID
	 */
	protected Integer padprid;

	/**
	 *流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPadprid() {
		return padprid;
	}

	/**
	 *流程ID设定
	 * 
	 * @param padprid流程ID
	 */
	public void setPadprid(Integer padprid) {
		this.padprid = padprid;
	}

	/**
	 *影响系统
	 */
	protected String padaffectsystem;

	/**
	 *影响系统取得
	 * 
	 * @return 影响系统
	 */
	public String getPadaffectsystem() {
		return padaffectsystem;
	}

	/**
	 *影响系统设定
	 * 
	 * @param padaffectsystem影响系统
	 */
	public void setPadaffectsystem(String padaffectsystem) {
		this.padaffectsystem = padaffectsystem;
	}

	/**
	 *影响开始时间
	 */
	protected String padstart;

	/**
	 *影响开始时间取得
	 * 
	 * @return 影响开始时间
	 */
	public String getPadstart() {
		return padstart;
	}

	/**
	 *影响开始时间设定
	 * 
	 * @param padstart影响开始时间
	 */
	public void setPadstart(String padstart) {
		this.padstart = padstart;
	}

	/**
	 *影响结束时间
	 */
	protected String padend;

	/**
	 *影响结束时间取得
	 * 
	 * @return 影响结束时间
	 */
	public String getPadend() {
		return padend;
	}

	/**
	 *影响结束时间设定
	 * 
	 * @param padend影响结束时间
	 */
	public void setPadend(String padend) {
		this.padend = padend;
	}
}

