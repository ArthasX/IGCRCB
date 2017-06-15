/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;

/**
  * 概述: 内置工作表实体
  * 功能描述: 内置工作表实体
  * 创建记录: 2012/07/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="InternalauditJob")
public class InternalauditJobTB extends BaseEntity implements Serializable,
		Cloneable, InternalauditJobInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="INTERNALAUDITJOB_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INTERNALAUDITJOB_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INTERNALAUDITJOB_TABLE_GENERATOR")
	protected Integer iajid;

	/** 计划年度 */
	protected String iajyear;

	/** 内置项目ID */
	protected Integer iajiapid;

	/** 工作名称 */
	protected String iajname;

	/** 实际工作开始日期 */
	protected String iajstarttime;

	/** 实际工作结束日期 */
	protected String iajovertime;

	/** 工作内容描述 */
	protected String iajdesc;

	/** 登记时间 */
	protected String iajinserttime;

	/** 附件 */
	protected String iajattkey;

	/** 登记人ID */
	protected String iajuserid;

	/** 内审项目信息实体 */
	@OneToOne
	@JoinColumn(name="iajiapid", referencedColumnName="iapid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected  InternalauditprjTB internalauditprjTB;
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getIajid() {
		return iajid;
	}

	/**
	 * 主键设定
	 *
	 * @param iajid 主键
	 */
	public void setIajid(Integer iajid) {
		this.iajid = iajid;
	}

	/**
	 * 计划年度取得
	 *
	 * @return 计划年度
	 */
	public String getIajyear() {
		return iajyear;
	}

	/**
	 * 计划年度设定
	 *
	 * @param iajyear 计划年度
	 */
	public void setIajyear(String iajyear) {
		this.iajyear = iajyear;
	}

	/**
	 * 内置项目ID取得
	 *
	 * @return 内置项目ID
	 */
	public Integer getIajiapid() {
		return iajiapid;
	}

	/**
	 * 内置项目ID设定
	 *
	 * @param iajiapid 内置项目ID
	 */
	public void setIajiapid(Integer iajiapid) {
		this.iajiapid = iajiapid;
	}

	/**
	 * 工作名称取得
	 *
	 * @return 工作名称
	 */
	public String getIajname() {
		return iajname;
	}

	/**
	 * 工作名称设定
	 *
	 * @param iajname 工作名称
	 */
	public void setIajname(String iajname) {
		this.iajname = iajname;
	}

	/**
	 * 实际工作开始日期取得
	 *
	 * @return 实际工作开始日期
	 */
	public String getIajstarttime() {
		return iajstarttime;
	}

	/**
	 * 实际工作开始日期设定
	 *
	 * @param iajstarttime 实际工作开始日期
	 */
	public void setIajstarttime(String iajstarttime) {
		this.iajstarttime = iajstarttime;
	}

	/**
	 * 实际工作结束日期取得
	 *
	 * @return 实际工作结束日期
	 */
	public String getIajovertime() {
		return iajovertime;
	}

	/**
	 * 实际工作结束日期设定
	 *
	 * @param iajovertime 实际工作结束日期
	 */
	public void setIajovertime(String iajovertime) {
		this.iajovertime = iajovertime;
	}

	/**
	 * 工作内容描述取得
	 *
	 * @return 工作内容描述
	 */
	public String getIajdesc() {
		return iajdesc;
	}

	/**
	 * 工作内容描述设定
	 *
	 * @param iajdesc 工作内容描述
	 */
	public void setIajdesc(String iajdesc) {
		this.iajdesc = iajdesc;
	}

	/**
	 * 登记时间取得
	 *
	 * @return 登记时间
	 */
	public String getIajinserttime() {
		return iajinserttime;
	}

	/**
	 * 登记时间设定
	 *
	 * @param iajinserttime 登记时间
	 */
	public void setIajinserttime(String iajinserttime) {
		this.iajinserttime = iajinserttime;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getIajattkey() {
		return iajattkey;
	}

	/**
	 * 附件设定
	 *
	 * @param iajattkey 附件
	 */
	public void setIajattkey(String iajattkey) {
		this.iajattkey = iajattkey;
	}

	/**
	 * 登记人ID取得
	 *
	 * @return 登记人ID
	 */
	public String getIajuserid() {
		return iajuserid;
	}

	/**
	 * 登记人ID设定
	 *
	 * @param iajuserid 登记人ID
	 */
	public void setIajuserid(String iajuserid) {
		this.iajuserid = iajuserid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return iajid;
	}

	/**
	 * 获取internalauditprjTB
	 * @return finternalauditprjTB internalauditprjTB
	 */
	public InternalauditprjTB getInternalauditprjTB() {
		return internalauditprjTB;
	}

	/**
	 * 设置internalauditprjTB
	 * @param internalauditprjTB  internalauditprjTB
	 */
	public void setInternalauditprjTB(InternalauditprjTB internalauditprjTB) {
		this.internalauditprjTB = internalauditprjTB;
	}

}