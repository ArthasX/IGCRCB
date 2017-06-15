/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM02Info;

/**
  * 概述: CRM02实体
  * 功能描述: CRM02实体
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM02")
public class CRM02TB extends BaseEntity implements Serializable,
		Cloneable, CRM02Info {

	/** collecttime */
	protected String collecttime;

	/** tablename */
	@Id
	protected String tablename;

	/** status */
	protected String status;

	/**
	 * collecttime取得
	 *
	 * @return collecttime
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * collecttime设定
	 *
	 * @param collecttime collecttime
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * tablename取得
	 *
	 * @return tablename
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * tablename设定
	 *
	 * @param tablename tablename
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * status取得
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * status设定
	 *
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return collecttime;
	}

}