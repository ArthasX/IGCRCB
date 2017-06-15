/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG787Info;

/**
 * <p>概述:流程共通变量信息实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG787VW implements Serializable,Cloneable, IG787Info {
	/**
	 * 流程记录ID
	 */
	@Id
	protected Integer prid;
	
	
	/**
	 * 共通变量名称
	 */
	protected String generalname;
	
	/**
	 * 共通变量ID
	 */
	protected Integer pidgid;
	
	/**
	 * 共通变量值
	 */
	protected String generalvalue;
	
	/**
	 * 功能：流程记录ID取得
	 * @return prid 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 功能：流程记录ID设置
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 功能：共通变量名称取得
	 * @return generalname 共通变量名称
	 */
	public String getGeneralname() {
		return generalname;
	}

	/**
	 * 功能：共通变量名称设置
	 * @param generalname 共通变量名称
	 */
	public void setGeneralname(String generalname) {
		this.generalname = generalname;
	}

	/** 
	 * 功能：共通变量ID取得
	 * @return pidgid 共通变量ID
	 */
	public Integer getPidgid() {
		return pidgid;
	}

	/**
	 * 功能：共通变量ID设置
	 * @param pidgid 共通变量ID
	 */
	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	/**
	 * 功能：共通变量值取得
	 * @return generalvalue 共通变量值
	 */
	public String getGeneralvalue() {
		return generalvalue;
	}

	/**
	 * 功能：共通变量值设置
	 * @param generalvalue 共通变量值
	 */
	public void setGeneralvalue(String generalvalue) {
		this.generalvalue = generalvalue;
	}

	
	
}
