/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;

/**
  * 概述: CRM09实体
  * 功能描述: CRM09实体
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM09")
public class CRM09TB extends BaseEntity implements Serializable,
		Cloneable, CRM09Info {

	/** RELATIONID */
	@Id
	@GeneratedValue(generator = "relationid")
	@GenericGenerator(name = "relationid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "crm09_seq") })
	protected Integer relationid;

	/** SERVERID */
	protected Integer serverid;

	/** RULETEMPID */
	protected Integer ruletempid;

	/** MAXALARMNUM */
	protected Integer maxalarmnum;

	/** MAXALARMTIME */
	protected Integer maxalarmtime;
	
	protected String createtime;

	
	public Integer getRelationid() {
		return relationid;
	}


	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}


	public Integer getServerid() {
		return serverid;
	}


	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}


	public Integer getRuletempid() {
		return ruletempid;
	}


	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}


	public Integer getMaxalarmnum() {
		return maxalarmnum;
	}


	public void setMaxalarmnum(Integer maxalarmnum) {
		this.maxalarmnum = maxalarmnum;
	}


	public Integer getMaxalarmtime() {
		return maxalarmtime;
	}


	public void setMaxalarmtime(Integer maxalarmtime) {
		this.maxalarmtime = maxalarmtime;
	}


	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return relationid;
	}


	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}