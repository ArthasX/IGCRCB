/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;

/**
  * 概述: 对比记录实体
  * 功能描述: 对比记录实体
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareprocess")
public class CompareprocessTB extends BaseEntity implements Serializable,
		Cloneable, CompareprocessInfo {

	/** 主键 */
	@Id
	@GeneratedValue(generator = "cpid")
	@GenericGenerator(name = "cpid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "compareprocess_seq") })
	protected Integer cpid;

	/** 比对域外键 */
	protected Integer fkCsid;
	
	@ManyToOne
	@JoinColumn(name="fkCsid", referencedColumnName="csid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected ComparescopeTB compareScopeTb;

	/** 开始时间 */
	protected String cpstarttime;

	/** 结束时间 */
	protected String cpendtime;

	/** 进度 */
	protected String cpschedule;

	/** 执行结果 */
	protected String cpresulttype;

	/** 错误提示 */
	protected String errorcaption;



	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCpid() {
		return cpid;
	}

	/**
	 * 主键设定
	 *
	 * @param cpid 主键
	 */
	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	/**
	 * 比对域外键取得
	 *
	 * @return 比对域外键
	 */
	public Integer getFkCsid() {
		return fkCsid;
	}

	/**
	 * 比对域外键设定
	 *
	 * @param fk_csid 比对域外键
	 */
	public void setFkCsid(Integer fkCsid) {
		this.fkCsid = fkCsid;
	}

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getCpstarttime() {
		return cpstarttime;
	}

	/**
	 * 开始时间设定
	 *
	 * @param cpstarttime 开始时间
	 */
	public void setCpstarttime(String cpstarttime) {
		this.cpstarttime = cpstarttime;
	}

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getCpendtime() {
		return cpendtime;
	}

	/**
	 * 结束时间设定
	 *
	 * @param cpendtime 结束时间
	 */
	public void setCpendtime(String cpendtime) {
		this.cpendtime = cpendtime;
	}

	/**
	 * 进度取得
	 *
	 * @return 进度
	 */
	public String getCpschedule() {
		return cpschedule;
	}

	/**
	 * 进度设定
	 *
	 * @param cpschedule 进度
	 */
	public void setCpschedule(String cpschedule) {
		this.cpschedule = cpschedule;
	}

	/**
	 * 执行结果取得
	 *
	 * @return 执行结果
	 */
	public String getCpresulttype() {
		return cpresulttype;
	}

	/**
	 * 执行结果设定
	 *
	 * @param cpresulttype 执行结果
	 */
	public void setCpresulttype(String cpresulttype) {
		this.cpresulttype = cpresulttype;
	}

	/**
	 * 错误提示取得
	 *
	 * @return 错误提示
	 */
	public String getErrorcaption() {
		return errorcaption;
	}

	/**
	 * 错误提示设定
	 *
	 * @param errorcaption 错误提示
	 */
	public void setErrorcaption(String errorcaption) {
		this.errorcaption = errorcaption;
	}




	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
	public Serializable getPK() {
		return cpid;
	}

	public ComparescopeTB getCompareScopeTb() {
		return compareScopeTb;
	}

	public void setCompareScopeTb(ComparescopeTB compareScopeTb) {
		this.compareScopeTb = compareScopeTb;
	}

	
}