/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;

/**
  * 概述: 提醒配置表实体
  * 功能描述: 提醒配置表实体
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="remindConfigure")
public class RemindConfigureTB extends BaseEntity implements Serializable,
		Cloneable, RemindConfigureInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="REMINDCONFIGURE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REMINDCONFIGURE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REMINDCONFIGURE_TABLE_GENERATOR")
	protected Integer rcid;

	/** 年 */
	protected String rcyear;

	/** 月 */
	protected String rcmonth;

	/** 日 */
	protected String rcday;

	/** 类型 */
	protected String rctype;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * 主键设定
	 *
	 * @param rcid 主键
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 年取得
	 *
	 * @return 年
	 */
	public String getRcyear() {
		return rcyear;
	}

	/**
	 * 年设定
	 *
	 * @param rcyear 年
	 */
	public void setRcyear(String rcyear) {
		this.rcyear = rcyear;
	}

	/**
	 * 月取得
	 *
	 * @return 月
	 */
	public String getRcmonth() {
		return rcmonth;
	}

	/**
	 * 月设定
	 *
	 * @param rcmonth 月
	 */
	public void setRcmonth(String rcmonth) {
		this.rcmonth = rcmonth;
	}

	/**
	 * 日取得
	 *
	 * @return 日
	 */
	public String getRcday() {
		return rcday;
	}

	/**
	 * 日设定
	 *
	 * @param rcday 日
	 */
	public void setRcday(String rcday) {
		this.rcday = rcday;
	}

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * 类型设定
	 *
	 * @param rctype 类型
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rcid;
	}

}