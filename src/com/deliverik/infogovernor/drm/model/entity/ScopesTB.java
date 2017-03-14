/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.ScopesInfo;

/**
  * 概述: 事件影响范围实体
  * 功能描述: 事件影响范围实体
  * 创建记录: 2015/03/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="scopes")
public class ScopesTB extends BaseEntity implements Serializable,
		Cloneable, ScopesInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="SCOPES_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SCOPES_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SCOPES_TABLE_GENERATOR")
	protected Integer scopeid;

	/** 事件ID */
	protected Integer eventid;

	/** 影响范围 */
	protected String impscope;

	/** 业务中断 */
	protected String impbus;

	/** 中断时间 */
	protected String imptime;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getScopeid() {
		return scopeid;
	}

	/**
	 * 主键设定
	 *
	 * @param scopeid 主键
	 */
	public void setScopeid(Integer scopeid) {
		this.scopeid = scopeid;
	}

	/**
	 * 事件ID取得
	 *
	 * @return 事件ID
	 */
	public Integer getEventid() {
		return eventid;
	}

	/**
	 * 事件ID设定
	 *
	 * @param eventid 事件ID
	 */
	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	/**
	 * 影响范围取得
	 *
	 * @return 影响范围
	 */
	public String getImpscope() {
		return impscope;
	}

	/**
	 * 影响范围设定
	 *
	 * @param IMPSCOPE 影响范围
	 */
	public void setImpscope(String impscope) {
		this.impscope = impscope;
	}

	/**
	 * 业务中断取得
	 *
	 * @return 业务中断
	 */
	public String getImpbus() {
		return impbus;
	}

	/**
	 * 业务中断设定
	 *
	 * @param IMPBUS 业务中断
	 */
	public void setImpbus(String impbus) {
		this.impbus = impbus;
	}

	/**
	 * 中断时间取得
	 *
	 * @return 中断时间
	 */
	public String getImptime() {
		return imptime;
	}

	/**
	 * 中断时间设定
	 *
	 * @param IMPTIME 中断时间
	 */
	public void setImptime(String imptime) {
		this.imptime = imptime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return scopeid;
	}

}