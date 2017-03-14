/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;


/**
 * 概述:同步告警系统视图实体
 * 功能描述: 同步告警系统视图实体
 * 创建人：王磊
 * 创建记录: 2014/04/03
 * 修改记录: 
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
public class SynchronizationAlarmSystemVW implements Serializable, Cloneable, 
	SynchronizationAlarmSystemVWInfo{
	
	/**id  */
	@Id
	protected Integer rid;
	/**已同步系统id  */
	protected Integer ilsid;
	/**已同步系统名称 */
	protected String ilsname;
	/**需同步系统名称  */
	protected String eaname;
	
	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * id设定
	 *
	 * @return id
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 已同步系统id取得
	 *
	 * @return 已同步系统id
	 */
	public Integer getIlsid() {
		return ilsid;
	}

	/**
	 * 已同步系统id设定
	 *
	 * @return 已同步系统id
	 */
	public void setIlsid(Integer ilsid) {
		this.ilsid = ilsid;
	}

	/**
	 * 已同步系统名称取得
	 *
	 * @return 已同步系统名称
	 */
	public String getIlsname() {
		return ilsname;
	}

	/**
	 * 已同步系统名称设定
	 *
	 * @return 已同步系统名称
	 */
	public void setIlsname(String ilsname) {
		this.ilsname = ilsname;
	}

	/**
	 * 需同步系统名称取得
	 *
	 * @return 需同步系统名称
	 */
	public String getEaname() {
		return eaname;
	}

	/**
	 * 需同步系统名称设定
	 *
	 * @return 需同步系统名称
	 */
	public void setEaname(String eaname) {
		this.eaname = eaname;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rid;
	}
}
