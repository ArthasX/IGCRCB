/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG105Info;

/**
 * 概述: 流程策略设定信息实体
 * 功能描述：流程策略设定信息实体
 * 创建记录：刘鹏 2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG105PK.class)
@Table(name = "IG105")
public class IG105TB extends BaseEntity implements Serializable,
		Cloneable, IG105Info {

	/** 流程定义ID */
	@Id
	protected String pdid;

	/** 流程状态 */
	@Id
	protected String prstatus;

	/** 紧急程度 */
	@Id
	protected String prurgency;

	/** 策略版本 */
	@Id
	protected Integer psdversion;

	/** 期望解决时间 */
	protected Double expecttime;
	
	/** 策略创建时间 */
	protected String createtime;

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

	/**
	 * 期望解决时间取得
	 * 
	 * @return 期望解决时间
	 */
	public Double getExpecttime() {
		return expecttime;
	}

	/**
	 * 期望解决时间设定
	 * 
	 * @param expecttime期望解决时间
	 */
	public void setExpecttime(Double expecttime) {
		this.expecttime = expecttime;
	}

	/**
	 * 策略创建时间取得
	 * 
	 * @return 策略创建时间
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 策略创建时间设定
	 * 
	 * @param createtime策略创建时间
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG105PK(pdid, prstatus, prurgency, psdversion);
	}

}
