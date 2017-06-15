/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

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

import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * 概述: 审计待处理任务实体
  * 功能描述: 审计待处理任务实体
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AuditWaitTask")
public class AuditWaitTaskTB extends BaseEntity implements Serializable,
		Cloneable, AuditWaitTaskInfo, LogicalDelete {

	/** 逻辑主键 */
	@Id
	@TableGenerator(
		name="AUDITWAITTASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="AUDITWAITTASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AUDITWAITTASK_TABLE_GENERATOR")
	protected Integer auwtid;

	/** 任务创建时间 */
	protected String auwtcreatetime;

	/** 源文件名 */
	protected String auwtfilename;
	
	/** 顶级CI */
	protected String auwttopci;
	
	/** 顶级CI类型 */
	protected Integer impTypeid;

	/** 状态 */
	protected String auwtstatus;

	/** 解析开始时间 */
	protected String auwtparsestart;

	/** 解析结束时间 */
	protected String auwtparseend;

	/** CI实体生成开始时间 */
	protected String auwtcistart;

	/** CI实体生成结束时间 */
	protected String auwtciend;

	/** 删除标识 */
	protected String deleteflag;
	
	/** 导入对象类型信息 */
	@ManyToOne
	@JoinColumn(name="impTypeid", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected EiImportProgrammeTB eiImportProgrammeTB;

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getAuwtid() {
		return auwtid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param auwtid 逻辑主键
	 */
	public void setAuwtid(Integer auwtid) {
		this.auwtid = auwtid;
	}

	/**
	 * 任务创建时间取得
	 *
	 * @return 任务创建时间
	 */
	public String getAuwtcreatetime() {
		return auwtcreatetime;
	}

	/**
	 * 任务创建时间设定
	 *
	 * @param auwtcreatetime 任务创建时间
	 */
	public void setAuwtcreatetime(String auwtcreatetime) {
		this.auwtcreatetime = auwtcreatetime;
	}

	/**
	 * 源文件名取得
	 *
	 * @return 源文件名
	 */
	public String getAuwtfilename() {
		return auwtfilename;
	}

	/**
	 * 源文件名设定
	 *
	 * @param auwtfilename 源文件名
	 */
	public void setAuwtfilename(String auwtfilename) {
		this.auwtfilename = auwtfilename;
	}
	
	/**
	 * 顶级CI取得
	 * 
	 * @return 顶级CI
	 */
	public String getAuwttopci() {
		return auwttopci;
	}

	/**
	 * 顶级CI设定
	 * 
	 * @param auwttopci 顶级CI
	 */
	public void setAuwttopci(String auwttopci) {
		this.auwttopci = auwttopci;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getAuwtstatus() {
		return auwtstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param auwtstatus 状态
	 */
	public void setAuwtstatus(String auwtstatus) {
		this.auwtstatus = auwtstatus;
	}

	/**
	 * 解析开始时间取得
	 *
	 * @return 解析开始时间
	 */
	public String getAuwtparsestart() {
		return auwtparsestart;
	}

	/**
	 * 解析开始时间设定
	 *
	 * @param auwtparsestart 解析开始时间
	 */
	public void setAuwtparsestart(String auwtparsestart) {
		this.auwtparsestart = auwtparsestart;
	}

	/**
	 * 解析结束时间取得
	 *
	 * @return 解析结束时间
	 */
	public String getAuwtparseend() {
		return auwtparseend;
	}

	/**
	 * 解析结束时间设定
	 *
	 * @param auwtparseend 解析结束时间
	 */
	public void setAuwtparseend(String auwtparseend) {
		this.auwtparseend = auwtparseend;
	}

	/**
	 * CI实体生成开始时间取得
	 *
	 * @return CI实体生成开始时间
	 */
	public String getAuwtcistart() {
		return auwtcistart;
	}

	/**
	 * CI实体生成开始时间设定
	 *
	 * @param auwtcistart CI实体生成开始时间
	 */
	public void setAuwtcistart(String auwtcistart) {
		this.auwtcistart = auwtcistart;
	}

	/**
	 * CI实体生成结束时间取得
	 *
	 * @return CI实体生成结束时间
	 */
	public String getAuwtciend() {
		return auwtciend;
	}

	/**
	 * CI实体生成结束时间设定
	 *
	 * @param auwtciend CI实体生成结束时间
	 */
	public void setAuwtciend(String auwtciend) {
		this.auwtciend = auwtciend;
	}

	/**
	 * 删除标识取得
	 *
	 * @return 删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 删除标识设定
	 *
	 * @param deleteflag 删除标识
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
		return auwtid;
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
	public EiImportProgrammeTB getEiImportProgrammeTB() {
		return eiImportProgrammeTB;
	}
	
	/**
	 * 导入对象类型信息设定
	 * 
	 * @param eiImportProgrammeTB 导入对象类型信息
	 */
	public void setEiImportProgrammeTB(EiImportProgrammeTB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}

}