/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.RehearseVWInfo;


/**
 * 概述：应急人员就位表实体
 * 功能描述：应急人员就位表实体
 * 创建记录：2014/05/19
 * 修改记录：
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RehearseVW implements Serializable, Cloneable, RehearseVWInfo {
	/**行ID*/
	@Id
	protected Integer rowid;

	/**应急启动流程ID*/
	protected Integer counts;
	/**应急启动流程ID*/
	protected String esyscoding;

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public Integer getRowid() {
		return rowid;
	}

	public void setRowid(Integer rowid) {
		this.rowid = rowid;
	}
	
}