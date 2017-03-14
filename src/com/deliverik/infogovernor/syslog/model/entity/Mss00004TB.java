/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;

/**
  * 概述: 告警规则模板表实体
  * 功能描述: 告警规则模板表实体
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00004")
public class Mss00004TB extends BaseEntity implements Serializable,
		Cloneable, Mss00004Info {

	/** ruletempid */
	@Id
	@TableGenerator(
		name="MSS00004_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MSS00004_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00004_TABLE_GENERATOR")
	protected Integer ruletempid;

	/** 模板名称 */
	protected String ruletempname;

	/** 设备类型 */
	protected String typeid;
	
	/** 规则条件 */
	protected Integer rulecondition;
	
	/** 模板状态 */
	protected Integer tempstate;
	
	/** 创建时间 */
	protected String createtime;
	
	/** 描述 */
	protected String tempdesc;
	
	/** 概述 */
	protected String summary;


	/**
	 * ruletempid取得
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}



	/**
	 * ruletempid设定
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}



	/**
	 * 模板名称取得
	 */
	public String getRuletempname() {
		return ruletempname;
	}



	/**
	 * 模板名称设定
	 */
	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}



	/**
	 * 设备类型取得
	 */
	public String getTypeid() {
		return typeid;
	}



	/**
	 * 设备类型设定
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}



	/**
	 * 规则条件取得
	 */
	public Integer getRulecondition() {
		return rulecondition;
	}



	/**
	 * 规则条件设定
	 */
	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
	}



	/**
	 * 模板状态取得
	 */
	public Integer getTempstate() {
		return tempstate;
	}



	/**
	 * 模板状态设定
	 */
	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
	}



	/**
	 * 创建时间取得
	 */
	public String getCreatetime() {
		return createtime;
	}



	/**
	 * 创建时间设定
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
		return ruletempid;
	}



	/**
	 * 描述取得
	 */
	public String getTempdesc() {
		return tempdesc;
	}



	/**
	 * 描述设定
	 */
	public void setTempdesc(String tempdesc) {
		this.tempdesc = tempdesc;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}
	

}