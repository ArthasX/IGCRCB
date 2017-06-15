/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;

/**
  * 概述: vCenter ServiceInstance实体
  * 功能描述: vCenter ServiceInstance实体
  * 创建记录: 2014/02/12
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VIM01")
public class VIM01TB extends BaseEntity implements Serializable,
		Cloneable, VIM01Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VIM01_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM01_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM01_TABLE_GENERATOR")
	protected Integer vcid;

	/** 名称 */
	protected String vcname;

	/** URL */
	protected String vcurl;

	/** 用户名 */
	protected String vcusername;

	/** 密码 */
	protected String vcpassword;

	/** 状态 */
	protected String vcstatus;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * 主键设定
	 *
	 * @param vcid 主键
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * 名称设定
	 *
	 * @param vcname 名称
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * URL取得
	 *
	 * @return URL
	 */
	public String getVcurl() {
		return vcurl;
	}

	/**
	 * URL设定
	 *
	 * @param vcurl URL
	 */
	public void setVcurl(String vcurl) {
		this.vcurl = vcurl;
	}

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getVcusername() {
		return vcusername;
	}

	/**
	 * 用户名设定
	 *
	 * @param vcusername 用户名
	 */
	public void setVcusername(String vcusername) {
		this.vcusername = vcusername;
	}

	/**
	 * 密码取得
	 *
	 * @return 密码
	 */
	public String getVcpassword() {
		return vcpassword;
	}

	/**
	 * 密码设定
	 *
	 * @param vcpassword 密码
	 */
	public void setVcpassword(String vcpassword) {
		this.vcpassword = vcpassword;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getVcstatus() {
		return vcstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param vcstatus 状态
	 */
	public void setVcstatus(String vcstatus) {
		this.vcstatus = vcstatus;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return vcid;
	}

}