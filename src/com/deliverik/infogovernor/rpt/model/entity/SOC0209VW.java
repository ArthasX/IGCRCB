/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.rpt.model.SOC0209Info;

/**
  * 概述: 流程来源视图实体
  * 功能描述: 流程来源视图实体
  * 创建记录: 2011/11/24
  * 修改记录: 2012/08/09 将ProcessRecordInfoVW表名改为SOC0209VW
  */
@SuppressWarnings("serial")
@Entity
public class SOC0209VW implements Serializable,
		Cloneable, SOC0209Info {

	/** 流程ID */
	@Id
	protected Integer prid;

	/** 流程类型 */
	protected String prtype;

	/** 流程来源 */
	protected String pivarvalue;

	/** 流程发起时间 */
	protected String propentime;

	/** 流程处理用时 */
	protected Integer prfacttime;

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 *
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程来源取得
	 *
	 * @return 流程来源
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 流程来源设定
	 *
	 * @param pivarvalue 流程来源
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 流程发起时间取得
	 *
	 * @return 流程发起时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 流程发起时间设定
	 *
	 * @param propentime 流程发起时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 流程处理用时取得
	 *
	 * @return 流程处理用时
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}

	/**
	 * 流程处理用时设定
	 *
	 * @param prfacttime 流程处理用时
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return prid;
	}

}