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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG941Info;

/**
 * <p>概述:服务工单日志实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG941")
public class IG941TB extends BaseEntity implements Serializable, Cloneable, IG941Info {
	
	/** 服务工单日志ID */
	@Id
	@TableGenerator(
		    name="IG941_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG941_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG941_TABLE_GENERATOR")
	protected Integer sflid;
	
	/** 服务工单ID */
	protected Integer sfid;
	
	/** 服务工单处理记录 */
	protected String sfldesc;

	/** 服务工单处理人ID */
	protected String sfluserid;
	
	/** 服务工单日志登记时间 */
	protected String sflinstime;
	/** 服务工单附件 */
	protected String sflattkey;

	/** 服务工单处理人 */
	@OneToOne
	@JoinColumn(name="sfluserid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB sfluser;
	
	/**
	 * 功能：主键取得
	 * @return sflid 主键
	 */
	public Serializable getPK() {
		return sflid;
	}

	/**
	 * 功能：服务工单日志ID取得
	 * @return 服务工单日志ID
	 */
	public Integer getSflid() {
		return sflid;
	}

	/**
	 * 功能：服务工单日志ID设定
	 * @param sflid 服务工单日志ID
	 */
	public void setSflid(Integer sflid) {
		this.sflid = sflid;
	}

	/**
	 * 功能：服务工单ID取得
	 * @return 服务工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * 功能：服务工单ID设定
	 * @param sfid 服务工单ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	/**
	 * 功能：服务工单处理记录取得
	 * @return 服务工单处理记录
	 */
	public String getSfldesc() {
		return sfldesc;
	}

	/**
	 * 功能：服务工单处理记录设定
	 * @param sfldesc 服务工单处理记录
	 */
	public void setSfldesc(String sfldesc) {
		this.sfldesc = sfldesc;
	}

	/**
	 * 功能：服务工单处理人ID取得
	 * @return 服务工单处理人ID
	 */
	public String getSfluserid() {
		return sfluserid;
	}

	/**
	 * 功能：服务工单处理人ID设定
	 * @param sfluserid 服务工单处理人ID
	 */
	public void setSfluserid(String sfluserid) {
		this.sfluserid = sfluserid;
	}

	/**
	 * 功能：服务工单日志登记时间取得
	 * @return 服务工单日志登记时间
	 */
	public String getSflinstime() {
		return sflinstime;
	}

	/**
	 * 功能：服务工单日志登记时间设定
	 * @param sflinstime 服务工单日志登记时间
	 */
	public void setSflinstime(String sflinstime) {
		this.sflinstime = sflinstime;
	}


	/**
	 * 功能：服务工单处理人取得
	 * @return 服务工单处理人
	 */
	public User getSfluser() {
		return sfluser;
	}

	/**
	 * 功能：服务工单附件取得
	 * @return  sflattkey
	 */
	public String getSflattkey() {
		return sflattkey;
	}

	/**
	 * 功能：服务工单附件设置
	 * @param sflattkey
	 */
	public void setSflattkey(String sflattkey) {
		this.sflattkey = sflattkey;
	}



}
