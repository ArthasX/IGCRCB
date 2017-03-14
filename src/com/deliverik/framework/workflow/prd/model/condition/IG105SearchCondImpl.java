/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;



/**
 * 概述: 流程策略设定信息检索条件实现
 * 功能描述：流程策略设定信息检索条件实现
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public class IG105SearchCondImpl implements IG105SearchCond {
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 策略版本 */
	protected Integer psdversion;
	
	/** 流程状态 */
	protected String prstatus;

	/** 紧急程度 */
	protected String prurgency;
	
	/**
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程名称ID设定
	 * @param pdid 流程名称ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * 策略版本取得
	 * 
	 * @return 策略版本
	 */
	public Integer getPsdversion() {
		return psdversion;
	}

	/**
	 * 策略版本设定
	 * 
	 * @param psdversion策略版本
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}
	
	/**
	 * 流程状态取得
	 * 
	 * @return 流程状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 * 
	 * @param prstatus流程状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 紧急程度取得
	 * 
	 * @return 紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 紧急程度设定
	 * 
	 * @param prurgency紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
	
}
