/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 审计对比结果信息表检索条件实现
  * 功能描述: 审计对比结果信息表检索条件实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditResultSearchCondImpl implements
		AuditResultSearchCond {
	
	/** 审计更新时间 */
	protected String autupdtime;
	
	/** 审计对比时间 */
	protected String autcomptime;
	
	/** 审计任务描述 */
	protected Integer autid;
	
	/** 资产层次码 */
	protected String esyscoding;

	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产层次码设定
	 * @param esyscoding 资产层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 审计更新时间取得
	 * @return 审计更新时间
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * 审计更新时间设定
	 * @param autupdtime 审计更新时间
	 */
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * 审计对比时间取得
	 * @return 审计对比时间
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * 审计对比时间设定
	 * @param autcomptime 审计对比时间
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}

	/**
	 * 审计任务ID取得
	 * @return 审计任务ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * 审计任务ID设定
	 * @param autid 审计任务ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}
	

}