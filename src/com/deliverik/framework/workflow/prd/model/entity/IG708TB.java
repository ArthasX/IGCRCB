/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.framework.workflow.prd.model.entity;


import com.deliverik.framework.workflow.prd.model.IG708Info;


 /**
  * 概述:流程评审详细记录表TB类
  *  功能描述：流程评审详细记录表TB类
  * 
  * 创建记录：wangxiaoqiang 2010/11/29
  */

public class IG708TB implements IG708Info {
	
	/**
	 * checkbox标识
	 */
	protected String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 主键
	 */
	protected Integer padid;

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public Integer getPadid() {
		return padid;
	}

	/**
	 *主键设定
	 * 
	 * @param padid主键
	 */
	public void setPadid(Integer padid) {
		this.padid = padid;
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

	protected String padaffectsystemname;
	
	
	public String getPadaffectsystemname() {
		return padaffectsystemname;
	}

	public void setPadaffectsystemname(String padaffectsystemname) {
		this.padaffectsystemname = padaffectsystemname;
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

