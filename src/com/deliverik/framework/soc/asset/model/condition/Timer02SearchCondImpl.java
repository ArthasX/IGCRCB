/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.io.Serializable;


/**
  * 概述: timer02检索条件实现
  * 功能描述: timer02检索条件实现
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
public class Timer02SearchCondImpl implements
		Timer02SearchCond {
	/** uuid */
	protected String uuid;

	/** name */
	protected String name;

	/** type */
	protected String type;

	/** collectdate */
	protected String collectdate;

	/** executrule */
	protected String executrule;

	/** periodtype */
	protected String periodtype;

	/** executstatus */
	protected String executstatus;

	/**
	 * uuid取得
	 *
	 * @return uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * uuid设定
	 *
	 * @param uuid uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * name取得
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name设定
	 *
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * type取得
	 *
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * type设定
	 *
	 * @param type type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * collectdate取得
	 *
	 * @return collectdate
	 */
	public String getCollectdate() {
		return collectdate;
	}

	/**
	 * collectdate设定
	 *
	 * @param collectdate collectdate
	 */
	public void setCollectdate(String collectdate) {
		this.collectdate = collectdate;
	}

	/**
	 * executrule取得
	 *
	 * @return executrule
	 */
	public String getExecutrule() {
		return executrule;
	}

	/**
	 * executrule设定
	 *
	 * @param executrule executrule
	 */
	public void setExecutrule(String executrule) {
		this.executrule = executrule;
	}

	/**
	 * periodtype取得
	 *
	 * @return periodtype
	 */
	public String getPeriodtype() {
		return periodtype;
	}

	/**
	 * periodtype设定
	 *
	 * @param periodtype periodtype
	 */
	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	/**
	 * executstatus取得
	 *
	 * @return executstatus
	 */
	public String getExecutstatus() {
		return executstatus;
	}

	/**
	 * executstatus设定
	 *
	 * @param executstatus executstatus
	 */
	public void setExecutstatus(String executstatus) {
		this.executstatus = executstatus;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return uuid;
	}
}