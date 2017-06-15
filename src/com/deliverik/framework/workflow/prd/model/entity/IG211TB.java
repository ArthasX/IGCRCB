/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG211Info;

/**
 * <p>概述:流程状态变量前处理实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG211")
public class IG211TB extends BaseEntity implements Serializable, Cloneable, IG211Info {
	
	/** 流程状态ID */
	@Id
	protected String psidid;
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 流程变量ID
	 */
	protected String pidid;

	/**
	 * 流程变量名称
	 */
	protected String pidname;
	
	/**
	 * 流程变量显示名称
	 */
	protected String pidlabel;
	
	/**
	 * 流程变量描述
	 */
	protected String piddesc;
	
	/**
	 * 流程变量类型
	 */
	protected String pidtype;
	

	/**
	 * 流程变量值
	 */
	protected String pidvalue;
	
	/**
	 * 文本域绑定附件
	 */
	protected String pidattkey;
	
	/**
	 * 流程状态前处理变量
	 */
	@ManyToOne
	@JoinColumn(name = "psdid", insertable=false, updatable=false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB processStatusDef;

	/**
	 * 功能：主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return psidid;
	}

	/**
	 * 功能：流程状态变量前处理ID取得
	 * @return 流程状态变量前处理ID
	 */
	public String getPsidid() {
		return psidid;
	}

	/**
	 * 功能：流程状态变量前处理ID设定
	 * @param psidid 流程状态变量前处理ID
	 */
	public void setPsidid(String psidid) {
		this.psidid = psidid;
	}

	/**
	 * 功能：流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 功能：流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 功能：流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 功能：流程变量ID设定
	 * @param pidid 流程变量ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 功能：流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 功能：流程变量名称设定
	 * @param pidname 流程变量名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 功能：流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 功能：流程变量显示名称设定
	 * @param pidlabel 流程变量显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 功能：流程变量描述取得
	 * @return 流程变量描述
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * 功能：流程变量描述设定
	 * @param piddesc 流程变量描述
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * 功能：流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 功能：流程变量类型设定
	 * @param pidtype 流程变量类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 功能：流程变量值取得
	 * @return 流程变量值
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * 功能：流程变量值设定
	 * @param pidvalue 流程变量值
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	/**
	 * 功能：流程状态前处理变量取得
	 * @return 流程状态前处理变量
	 */
	public IG333TB getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 功能：流程状态前处理变量设定
	 * @param IG333 流程状态前处理变量
	 */
	public void setProcessStatusDef(IG333TB processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * 功能：文本域绑定附件取得
	 * @return 文本域绑定附件
	 */
	public String getPidattkey() {
		return pidattkey;
	}

	/**
	 * 功能：文本域绑定附件设定
	 * @param pidattkey 文本域绑定附件
	 */
	public void setPidattkey(String pidattkey) {
		this.pidattkey = pidattkey;
	}
}
