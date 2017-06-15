/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG273Info;

/**
 * 流程状态跃迁规则
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG273")
public class IG273TB extends BaseEntity implements Serializable, Cloneable, IG273Info {
	
	/** 流程状态跃迁规则ID */
	@Id
	protected String ptdid;
	
	/**
	 * 流程状态ID（From）
	 */
	protected String fpsdid;
	
	/**
	 * 流程状态ID（To）
	 */
	protected String tpsdid;

	/**
	 * 流程状态跃迁规则名称
	 */
	protected String ptdname;
	
	/**
	 * 流程状态跃迁规则描述
	 */
	protected String ptddesc;
	
	/**
	 * 流程状态跃迁规则类型
	 */
	protected String ptdtype;
	
	/**
	 * 流程状态跃迁条件
	 */
	protected String ptdcond;
	
	/**
	 * 流程状态跃迁条件
	 */
	@Transient
	protected String ptdcondinfo;
	
	/** 流程当前状态 */
	@OneToOne
	@JoinColumn(name="fpsdid", referencedColumnName="psdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB fromPSDTB;
	
	/** 流程跃迁状态 */
	@OneToOne
	@JoinColumn(name="tpsdid", referencedColumnName="psdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB toPSDTB;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return ptdid;
	}

	/**
	 * 流程状态跃迁规则ID取得
	 * @return 流程状态跃迁规则ID
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * 流程状态跃迁规则ID设定
	 * @param ptdid 流程状态跃迁规则ID
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * 流程状态ID（From）取得
	 * @return 流程状态ID（From）
	 */
	public String getFpsdid() {
		return fpsdid;
	}

	/**
	 * 流程状态ID（From）设定
	 * @param fpsdid 流程状态ID（From）
	 */
	public void setFpsdid(String fpsdid) {
		this.fpsdid = fpsdid;
	}

	/**
	 * 流程状态ID（To）取得
	 * @return 流程状态ID（To）
	 */
	public String getTpsdid() {
		return tpsdid;
	}

	/**
	 * 流程状态ID（To）设定
	 * @param tpsdid 流程状态ID（To）
	 */
	public void setTpsdid(String tpsdid) {
		this.tpsdid = tpsdid;
	}

	/**
	 * 流程状态跃迁规则名称取得
	 * @return 流程状态跃迁规则名称
	 */
	public String getPtdname() {
		return ptdname;
	}

	/**
	 * 流程状态跃迁规则名称设定
	 * @param ptdname 流程状态跃迁规则名称
	 */
	public void setPtdname(String ptdname) {
		this.ptdname = ptdname;
	}

	/**
	 * 流程状态跃迁规则描述取得
	 * @return 流程状态跃迁规则描述
	 */
	public String getPtddesc() {
		return ptddesc;
	}

	/**
	 * 流程状态跃迁规则描述设定
	 * @param ptddesc 流程状态跃迁规则描述
	 */
	public void setPtddesc(String ptddesc) {
		this.ptddesc = ptddesc;
	}

	/**
	 * 流程状态跃迁规则类型取得
	 * @return 流程状态跃迁规则类型
	 */
	public String getPtdtype() {
		return ptdtype;
	}

	/**
	 * 流程状态跃迁规则类型设定
	 * @param ptdtype 流程状态跃迁规则类型
	 */
	public void setPtdtype(String ptdtype) {
		this.ptdtype = ptdtype;
	}

	/**
	 * 流程状态跃迁条件取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcond() {
		return ptdcond;
	}

	/**
	 * 流程状态跃迁条件设定
	 * @param ptdcond 流程状态跃迁条件
	 */
	public void setPtdcond(String ptdcond) {
		this.ptdcond = ptdcond;
	}

	/**
	 * 流程当前状态取得
	 * @return 流程当前状态
	 */
	public IG333TB getFromPSDTB() {
		return fromPSDTB;
	}

	/**
	 * 流程当前状态设定
	 * @param fromPSDTB 流程当前状态
	 */
	public void setFromPSDTB(IG333TB fromPSDTB) {
		this.fromPSDTB = fromPSDTB;
	}

	/**
	 * 流程跃迁状态取得
	 * @return 流程跃迁状态
	 */
	public IG333TB getToPSDTB() {
		return toPSDTB;
	}

	/**
	 * 流程跃迁状态设定
	 * @param toPSDTB 流程跃迁状态
	 */
	public void setToPSDTB(IG333TB toPSDTB) {
		this.toPSDTB = toPSDTB;
	}
	
	/**
	 * 流程状态跃迁条件取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcondinfo() {
		return ptdcondinfo;
	}

	/**
	 * 流程状态跃迁条件设定
	 * @param ptdcondinfo 流程状态跃迁条件
	 */
	public void setPtdcondinfo(String ptdcondinfo) {
		this.ptdcondinfo = ptdcondinfo;
	}

}
