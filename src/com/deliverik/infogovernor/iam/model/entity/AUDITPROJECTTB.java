/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;

/**
  * 概述: 审计报告表实体
  * 功能描述: 审计报告表实体
  * 创建记录: 2012/08/08
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AUDITPROJECT")
public class AUDITPROJECTTB extends BaseEntity implements Serializable,
		Cloneable, AUDITPROJECTInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="AUDITPROJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="AUDITPROJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AUDITPROJECT_TABLE_GENERATOR")
	protected Integer apid;

	/** 审计报告类型 */
	protected String apreporttype;

	/** 审计项目ID */
	protected Integer approjectid;

	/** 项目名称 */
	protected String approjectname;

	/** 项目年度 */
	protected String approjectyear;

	/** 审计报告附件KEY */
	protected String apattkey;
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getApid() {
		return apid;
	}

	/**
	 * 主键设定
	 *
	 * @param apid 主键
	 */
	public void setApid(Integer apid) {
		this.apid = apid;
	}

	/**
	 * 审计报告类型取得
	 *
	 * @return 审计报告类型
	 */
	public String getApreporttype() {
		return apreporttype;
	}

	/**
	 * 审计报告类型设定
	 *
	 * @param apreporttype 审计报告类型
	 */
	public void setApreporttype(String apreporttype) {
		this.apreporttype = apreporttype;
	}

	/**
	 * 审计项目ID取得
	 *
	 * @return 审计项目ID
	 */
	public Integer getApprojectid() {
		return approjectid;
	}

	/**
	 * 审计项目ID设定
	 *
	 * @param approjectid 审计项目ID
	 */
	public void setApprojectid(Integer approjectid) {
		this.approjectid = approjectid;
	}

	/**
	 * 项目名称取得
	 *
	 * @return 项目名称
	 */
	public String getApprojectname() {
		return approjectname;
	}

	/**
	 * 项目名称设定
	 *
	 * @param approjectname 项目名称
	 */
	public void setApprojectname(String approjectname) {
		this.approjectname = approjectname;
	}

	/**
	 * 项目年度取得
	 *
	 * @return 项目年度
	 */
	public String getApprojectyear() {
		return approjectyear;
	}

	/**
	 * 项目年度设定
	 *
	 * @param approjectyear 项目年度
	 */
	public void setApprojectyear(String approjectyear) {
		this.approjectyear = approjectyear;
	}

	/**
	 * 审计报告附件KEY取得
	 *
	 * @return 审计报告附件KEY
	 */
	public String getApattkey() {
		return apattkey;
	}

	/**
	 * 审计报告附件KEY设定
	 *
	 * @param apattkey 审计报告附件KEY
	 */
	public void setApattkey(String apattkey) {
		this.apattkey = apattkey;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return apid;
	}
	
}