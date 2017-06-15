/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * 概述: 流程策略设定信息实体主键
 * 功能描述：流程策略设定信息实体主键
 * 创建记录：刘鹏 2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IG105PK extends BasePK implements Serializable{

	/** 流程定义ID */
	protected String pdid;

	/** 流程状态 */
	protected String prstatus;

	/** 紧急程度 */
	protected String prurgency;
	
	/** 策略版本 */
	protected Integer psdversion;
	
	/**
	 * 流程策略设定信息实体主键构造函数
	 * 
	 */
	public IG105PK() {
	}

	/**
	 * 流程策略设定信息实体主键构造函数
	 * 
	 * @param pdid流程定义ID
	 * @param prstatus流程状态
	 * @param prurgency紧急程度
	 * @param psdversion策略版本
	 */
	public IG105PK(String pdid, String prstatus, String prurgency, Integer psdversion) {
		super();
		this.pdid = pdid;
		this.prstatus = prstatus;
		this.prurgency = prurgency;
		this.psdversion = psdversion;
	}

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
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

}
