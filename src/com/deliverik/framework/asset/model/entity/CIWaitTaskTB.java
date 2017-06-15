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

import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * 概述: CI变更待处理任务实体
  * 功能描述: CI变更待处理任务实体
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CIWaitTask")
public class CIWaitTaskTB extends BaseEntity implements Serializable,
		Cloneable, CIWaitTaskInfo, LogicalDelete {

	/** 逻辑主键 */
	@Id
	@TableGenerator(
		name="CIWAITTASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CIWAITTASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CIWAITTASK_TABLE_GENERATOR")
	protected Integer ciwtid;

	/** 任务创建时间 */
	protected String ciwtcreatetime;

	/** 源文件名 */
	protected String ciwtfilename;
	
	/** 顶级CI */
	protected String ciwttopci;
	
	/** 顶级CI类型 */
	protected Integer impTypeid;

	/** 状态 */
	protected String ciwtstatus;

	/** 解析开始时间 */
	protected String ciwtparsestart;

	/** 解析结束时间 */
	protected String ciwtparseend;

	/** CI实体生成开始时间 */
	protected String ciwtcistart;

	/** CI实体生成结束时间 */
	protected String ciwtciend;

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
	public Integer getCiwtid() {
		return ciwtid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param ciwtid 逻辑主键
	 */
	public void setCiwtid(Integer ciwtid) {
		this.ciwtid = ciwtid;
	}

	/**
	 * 任务创建时间取得
	 *
	 * @return 任务创建时间
	 */
	public String getCiwtcreatetime() {
		return ciwtcreatetime;
	}

	/**
	 * 任务创建时间设定
	 *
	 * @param ciwtcreatetime 任务创建时间
	 */
	public void setCiwtcreatetime(String ciwtcreatetime) {
		this.ciwtcreatetime = ciwtcreatetime;
	}

	/**
	 * 源文件名取得
	 *
	 * @return 源文件名
	 */
	public String getCiwtfilename() {
		return ciwtfilename;
	}

	/**
	 * 源文件名设定
	 *
	 * @param ciwtfilename 源文件名
	 */
	public void setCiwtfilename(String ciwtfilename) {
		this.ciwtfilename = ciwtfilename;
	}
	
	/**
	 * 顶级CI取得
	 * 
	 * @return 顶级CI
	 */
	public String getCiwttopci() {
		return ciwttopci;
	}

	/**
	 * 顶级CI设定
	 * 
	 * @param ciwttopci 顶级CI
	 */
	public void setCiwttopci(String ciwttopci) {
		this.ciwttopci = ciwttopci;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getCiwtstatus() {
		return ciwtstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param ciwtstatus 状态
	 */
	public void setCiwtstatus(String ciwtstatus) {
		this.ciwtstatus = ciwtstatus;
	}

	/**
	 * 解析开始时间取得
	 *
	 * @return 解析开始时间
	 */
	public String getCiwtparsestart() {
		return ciwtparsestart;
	}

	/**
	 * 解析开始时间设定
	 *
	 * @param ciwtparsestart 解析开始时间
	 */
	public void setCiwtparsestart(String ciwtparsestart) {
		this.ciwtparsestart = ciwtparsestart;
	}

	/**
	 * 解析结束时间取得
	 *
	 * @return 解析结束时间
	 */
	public String getCiwtparseend() {
		return ciwtparseend;
	}

	/**
	 * 解析结束时间设定
	 *
	 * @param ciwtparseend 解析结束时间
	 */
	public void setCiwtparseend(String ciwtparseend) {
		this.ciwtparseend = ciwtparseend;
	}

	/**
	 * CI实体生成开始时间取得
	 *
	 * @return CI实体生成开始时间
	 */
	public String getCiwtcistart() {
		return ciwtcistart;
	}

	/**
	 * CI实体生成开始时间设定
	 *
	 * @param ciwtcistart CI实体生成开始时间
	 */
	public void setCiwtcistart(String ciwtcistart) {
		this.ciwtcistart = ciwtcistart;
	}

	/**
	 * CI实体生成结束时间取得
	 *
	 * @return CI实体生成结束时间
	 */
	public String getCiwtciend() {
		return ciwtciend;
	}

	/**
	 * CI实体生成结束时间设定
	 *
	 * @param ciwtciend CI实体生成结束时间
	 */
	public void setCiwtciend(String ciwtciend) {
		this.ciwtciend = ciwtciend;
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
		return ciwtid;
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
	 * @param eiImportProgrammeTB 导入对象类型信息
	 */
	public void setEiImportProgrammeTB(EiImportProgrammeTB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}

}