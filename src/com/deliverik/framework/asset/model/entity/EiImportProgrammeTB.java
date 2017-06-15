/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * 概述: 导入程序管理表实体
  * 功能描述: 导入程序管理表实体
  * 创建记录: 2011/05/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="EiImportProgramme")
public class EiImportProgrammeTB extends BaseEntity implements Serializable,
		Cloneable, EiImportProgrammeInfo {

	/** 类型ID */
	@Id
	@TableGenerator(
		name="EIIMPORTPROGRAMME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EIIMPORTPROGRAMME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EIIMPORTPROGRAMME_TABLE_GENERATOR")
	protected Integer impTypeid;

	/** 类型名称 */
	protected String impTypename;

	/** 导入bat名称 */
	protected String impProgramme;
	
	/** 审计bat名称 */
	protected String impProgrammeAudit;
	
	/** 更新bat名称 */
	protected String impProgrammeUpdate;
	
	
	/**
	 * 类型ID取得
	 *
	 * @return 类型ID
	 */
	public Integer getImpTypeid() {
		return impTypeid;
	}

	/**
	 * 类型ID设定
	 *
	 * @param impTypeid 类型ID
	 */
	public void setImpTypeid(Integer impTypeid) {
		this.impTypeid = impTypeid;
	}

	/**
	 * 类型名称取得
	 *
	 * @return 类型名称
	 */
	public String getImpTypename() {
		return impTypename;
	}

	/**
	 * 类型名称设定
	 *
	 * @param impTypename 类型名称
	 */
	public void setImpTypename(String impTypename) {
		this.impTypename = impTypename;
	}

	/**
	 * 导入bat名称取得
	 *
	 * @return 导入bat名称
	 */
	public String getImpProgramme() {
		return impProgramme;
	}

	/**
	 * 导入bat名称设定
	 *
	 * @param impProgramme 导入bat名称
	 */
	public void setImpProgramme(String impProgramme) {
		this.impProgramme = impProgramme;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return impTypeid;
	}

	/**
	 * 审计bat名称取得
	 * @return 审计bat名称
	 */
	public String getImpProgrammeAudit() {
		return impProgrammeAudit;
	}

	/**
	 * 审计bat名称设定
	 * @param impProgrammeAudit审计bat名称
	 */
	public void setImpProgrammeAudit(String impProgrammeAudit) {
		this.impProgrammeAudit = impProgrammeAudit;
	}

	/**
	 * 更新bat名称取得
	 * @return 更新bat名称
	 */
	public String getImpProgrammeUpdate() {
		return impProgrammeUpdate;
	}

	/**
	 * 更新bat名称设定
	 * @param impProgrammeUpdate更新bat名称
	 */
	public void setImpProgrammeUpdate(String impProgrammeUpdate) {
		this.impProgrammeUpdate = impProgrammeUpdate;
	}

	
	
}