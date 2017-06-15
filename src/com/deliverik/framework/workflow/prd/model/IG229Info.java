/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

 /**
  * 概述:流程评审详细记录表接口
  * 功能描述：流程评审详细记录表接口
  *           
  * 创建记录：wangxiaoqiang    2010/11/29
  */
public interface IG229Info {
	/**
	 *主键
	 */
	public Integer getPadid();

	/**
	 *流程ID
	 */
	public Integer getPadprid();

	/**
	 *影响系统
	 */
	public String getPadaffectsystem();

	/**
	 *影响开始时间
	 */
	public String getPadstart();

	/**
	 *影响结束时间
	 */
	public String getPadend();

}

