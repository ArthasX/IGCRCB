/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.soc.asset.model.SOC0115Info;

/**
  * 概述: 待处理任务实体
  * 功能描述: 待处理任务实体
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0115")
public class SOC0115TB extends BaseEntity implements Serializable,
		Cloneable, SOC0115Info, LogicalDelete {

	/** 逻辑主键 */
	@Id
	@TableGenerator(
		name="SOC0115_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0115_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0115_TABLE_GENERATOR")
	protected Integer eitid;

	/** 任务创建时间 */
	protected String eitcreatetime;

	/** 顶级ci */
	protected String eittopci;
	
	/** 顶级CI类型 */
	protected Integer impTypeid;

	/** 源文件名 */
	protected String eitfilename;

	/** 状态 */
	protected String eitstatus;

	/** 解析开始时间 */
	protected String eitparsestart;

	/** 解析结束时间 */
	protected String eitparseend;

	/** CI实体生成开始时间 */
	protected String eitcistart;

	/** CI实体生成结束时间 */
	protected String eitciend;

	/** 关系建立开始时间 */
	protected String eitrelationstart;

	/** 关系建立结束时间 */
	protected String eitrelationend;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** 导入对象类型信息 */
	@ManyToOne
	@JoinColumn(name="impTypeid", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0113TB eiImportProgrammeTB;

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getEitid() {
		return eitid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param eitid逻辑主键
	 */
	public void setEitid(Integer eitid) {
		this.eitid = eitid;
	}

	/**
	 * 任务创建时间取得
	 *
	 * @return 任务创建时间
	 */
	public String getEitcreatetime() {
		return eitcreatetime;
	}

	/**
	 * 任务创建时间设定
	 *
	 * @param eitcreatetime任务创建时间
	 */
	public void setEitcreatetime(String eitcreatetime) {
		this.eitcreatetime = eitcreatetime;
	}

	/**
	 * 顶级ci取得
	 *
	 * @return 顶级ci
	 */
	public String getEittopci() {
		return eittopci;
	}

	/**
	 * 顶级ci设定
	 *
	 * @param eittopci顶级ci
	 */
	public void setEittopci(String eittopci) {
		this.eittopci = eittopci;
	}

	/**
	 * 源文件名取得
	 *
	 * @return 源文件名
	 */
	public String getEitfilename() {
		return eitfilename;
	}

	/**
	 * 源文件名设定
	 *
	 * @param eitfilename源文件名
	 */
	public void setEitfilename(String eitfilename) {
		this.eitfilename = eitfilename;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getEitstatus() {
		return eitstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param eitstatus状态
	 */
	public void setEitstatus(String eitstatus) {
		this.eitstatus = eitstatus;
	}

	/**
	 * 解析开始时间取得
	 *
	 * @return 解析开始时间
	 */
	public String getEitparsestart() {
		return eitparsestart;
	}

	/**
	 * 解析开始时间设定
	 *
	 * @param eitparsestart解析开始时间
	 */
	public void setEitparsestart(String eitparsestart) {
		this.eitparsestart = eitparsestart;
	}

	/**
	 * 解析结束时间取得
	 *
	 * @return 解析结束时间
	 */
	public String getEitparseend() {
		return eitparseend;
	}

	/**
	 * 解析结束时间设定
	 *
	 * @param eitparseend解析结束时间
	 */
	public void setEitparseend(String eitparseend) {
		this.eitparseend = eitparseend;
	}

	/**
	 * CI实体生成开始时间取得
	 *
	 * @return CI实体生成开始时间
	 */
	public String getEitcistart() {
		return eitcistart;
	}

	/**
	 * CI实体生成开始时间设定
	 *
	 * @param eitcistartCI实体生成开始时间
	 */
	public void setEitcistart(String eitcistart) {
		this.eitcistart = eitcistart;
	}

	/**
	 * CI实体生成结束时间取得
	 *
	 * @return CI实体生成结束时间
	 */
	public String getEitciend() {
		return eitciend;
	}

	/**
	 * CI实体生成结束时间设定
	 *
	 * @param eitciendCI实体生成结束时间
	 */
	public void setEitciend(String eitciend) {
		this.eitciend = eitciend;
	}

	/**
	 * 关系建立开始时间取得
	 *
	 * @return 关系建立开始时间
	 */
	public String getEitrelationstart() {
		return eitrelationstart;
	}

	/**
	 * 关系建立开始时间设定
	 *
	 * @param eitrelationstart关系建立开始时间
	 */
	public void setEitrelationstart(String eitrelationstart) {
		this.eitrelationstart = eitrelationstart;
	}

	/**
	 * 关系建立结束时间取得
	 *
	 * @return 关系建立结束时间
	 */
	public String getEitrelationend() {
		return eitrelationend;
	}

	/**
	 * 关系建立结束时间设定
	 *
	 * @param eitrelationend关系建立结束时间
	 */
	public void setEitrelationend(String eitrelationend) {
		this.eitrelationend = eitrelationend;
	}
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识设定
	 *
	 * @param brdeleteflag逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return eitid;
	}
	
	/**
	 * 顶级CI类型取得
	 *
	 * @return 顶级CI类型
	 */
	public Integer getImpTypeid() {
		return impTypeid;
	}

	/**
	 * 顶级CI类型设定
	 *
	 * @param impTypeid 顶级CI类型
	 */
	public void setImpTypeid(Integer impTypeid) {
		this.impTypeid = impTypeid;
	}
	
	/**
	 * 导入对象类型信息取得
	 * @return 导入对象类型信息
	 */
	public SOC0113TB getEiImportProgrammeTB() {
		return eiImportProgrammeTB;
	}

	/**
	 * 导入对象类型信息设定
	 * 
	 * @param eiImportProgrammeTB 导入对象类型信息
	 */
	public void setEiImportProgrammeTB(SOC0113TB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}
	
}