/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 审计任务查询画面Form
 * 功能描述: 审计任务查询画面Form
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2107Form extends BaseForm implements AuditTaskSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 审计任务描述 */
	protected String autdesc_like;

	/** 开始时间*/
	protected String auttime_from;
	
	/** 结束时间*/
	protected String auttime_to;
	
	/** 状态 */
	protected String autstatus_eq;
	
	
	/**
	 * 审计任务描述取得
	 * @return 审计任务描述
	 */
	public String getAutdesc_like() {
		return autdesc_like;
	}

	/**
	 * 审计任务描述设定
	 * @param autdesc审计任务描述
	 */

	public void setAutdesc_like(String autdesc_like) {
		this.autdesc_like = autdesc_like;
	}

	/**
	 * 开始时间取得
	 * @return 开始时间
	 */
	public String getAuttime_from() {
		return auttime_from;
	}

	/**
	 * 开始时间设定
	 * @param auttime_from开始时间
	 */
	public void setAuttime_from(String auttime_from) {
		this.auttime_from = auttime_from;
	}

	/**
	 * 结束时间取得
	 * @return 结束时间
	 */
	public String getAuttime_to() {
		return auttime_to;
	}

	/**
	 * 结束时间设定
	 * @param auttime_to结束时间
	 */
	public void setAuttime_to(String auttime_to) {
		this.auttime_to = auttime_to;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getAutstatus_eq() {
		return autstatus_eq;
	}
	
	/**
	 * 状态设定
	 * @param autstatus状态
	 */
	public void setAutstatus_eq(String autstatus_eq) {
		this.autstatus_eq = autstatus_eq;
	}
}
