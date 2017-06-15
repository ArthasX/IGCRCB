/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
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
import com.deliverik.framework.workflow.prr.model.IG715Info;

/**
 * <p>概述:服务工单关联流程实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG715")
public class IG715TB extends BaseEntity implements Serializable, Cloneable, IG715Info {
	/** 服务工单ID */
	@Id
	@TableGenerator(
		    name="IG715_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG715_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG715_TABLE_GENERATOR")
	protected Integer sprrid;

	/** 服务工单ID*/
	protected Integer sprrsfid;

	/** 流程ID*/
	protected Integer sprrprid;

	/** 时间*/
	protected String sprrinstime;

	
	/** 服务工单数据实体 */
	@OneToOne
	@JoinColumn(name="sprrsfid", referencedColumnName="sfid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG933TB ServiceFormTB;
	
	/** 流程数据实体 */
	@OneToOne
	@JoinColumn(name="sprrprid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB ProcessRecordTB;
	
	/**
	 * 功能：主键取得
	 * @return sprrid 主键
	 */
	public Serializable getPK() {
		return sprrid;
	}
	
	/**
	 * 功能：主键取得
	 * @return sprrid 主键
	 */
	public Integer getSprrid() {
		return sprrid;
	}

	/**
	 * 功能：主键设置
	 * @param sprrid 主键
	 */
	public void setSprrid(Integer sprrid) {
		this.sprrid = sprrid;
	}
	
	/**
	 * 功能：服务工单ID取得
	 * @return 服务工单ID
	 */
	public Integer getSprrsfid() {
		return sprrsfid;
	}

	/**
	 * 功能：服务工单ID设置
	 * @param sprrsfid 服务工单ID
	 */
	public void setSprrsfid(Integer sprrsfid) {
		this.sprrsfid = sprrsfid;
	}
	
	/**
	 * 功能：流程ID取得
	 * @return 流程ID 
	 */
	public Integer getSprrprid() {
		return sprrprid;
	}

	/**
	 * 功能：流程ID设置
	 * @param sprrprid 流程ID
	 */
	public void setSprrprid(Integer sprrprid) {
		this.sprrprid = sprrprid;
	}
	
	/**
	 * 功能：时间取得
	 * @return 时间 
	 */
	public String getSprrinstime() {
		return sprrinstime;
	}

	/**
	 * 功能：时间设置
	 * @param sprrinstime 时间
	 */
	public void setSprrinstime(String sprrinstime) {
		this.sprrinstime = sprrinstime;
	}
	
	/**
	 * 功能：服务工单对象取得
	 * @return 服务工单对象 
	 */
	public IG933TB getServiceFormTB() {
		return ServiceFormTB;
	}

	/**
	 * 功能：服务工单对象设置
	 * @param serviceFormTB 服务工单对象
	 */
	public void setServiceFormTB(IG933TB serviceFormTB) {
		ServiceFormTB = serviceFormTB;
	}
	
	/**
	 * 功能：流程对象取得
	 * @return 流程对象 
	 */
	public IG500TB getProcessRecordTB() {
		return ProcessRecordTB;
	}

	/**
	 * 功能：流程对象设置
	 * @param processRecordTB 流程对象
	 */
	public void setProcessRecordTB(IG500TB processRecordTB) {
		ProcessRecordTB = processRecordTB;
	}
	
}
