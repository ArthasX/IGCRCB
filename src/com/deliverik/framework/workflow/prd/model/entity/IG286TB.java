/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG286Info;

/**
 * <p>概述:表单联动实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG286")
public class IG286TB extends BaseEntity implements Serializable, Cloneable, IG286Info {

	/** 主键ID */
	@Id
	protected String plid;
	
	/** 主动id */
	protected String initiativepidid;
	
	/** 主动表单名称 */
	protected String initiativepidname;
	
	/** 被动id */
	protected String passivitypidid;
	
	/** 被动表单名称 */
	protected String passivitypidname;

	/** 关联描述 */
	protected String pldesc;
	
	/** bl名称 */
	protected String plblname;
	
	/** js事件名称 */
	protected String pljsevent;
	/** 表单关联类型 */
	protected String pljtype;

	@ManyToOne
	@JoinColumn(name="pldpdid", referencedColumnName="pdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG380TB processDefinitionTB;
	
	/** 流程定义id */
	protected String pldpdid;
	
	/**表单按钮id  */
	protected String pldactionid;

	/**
	 * 功能：主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return plid;
	}
	
	/**
	 * 功能：主键ID取得
	 * @return 主键ID
	 */
	public String getPlid() {
		return plid;
	}

	/**
	 * 功能：主键ID设定
	 *
	 * @param srid 主键ID
	 */
	public void setPlid(String plid) {
		this.plid = plid;
	}

	/**
	 * 功能：主动id取得
	 * @return 主动id
	 */
	public String getInitiativepidid() {
		return initiativepidid;
	}

	/**
	 * 功能：主动id设定
	 *
	 * @param initiativepidid 主动id
	 */
	public void setInitiativepidid(String initiativepidid) {
		this.initiativepidid = initiativepidid;
	}

	/**
	 * 功能：被动id取得
	 * @return 被动id
	 */
	public String getPassivitypidid() {
		return passivitypidid;
	}

	/**
	 * 功能：被动id设定
	 *
	 * @param passivitypidid 被动id
	 */
	public void setPassivitypidid(String passivitypidid) {
		this.passivitypidid = passivitypidid;
	}

	/**
	 * 功能：关联描述取得
	 * @return 关联描述
	 */
	public String getPldesc() {
		return pldesc;
	}

	/**
	 * 功能：关联描述设定
	 *
	 * @param pldesc 关联描述
	 */
	public void setPldesc(String pldesc) {
		this.pldesc = pldesc;
	}

	/**
	 * 功能：bl名称
	 * @return bl名称
	 */
	public String getPlblname() {
		return plblname;
	}

	/**
	 * 功能：bl名称设定
	 *
	 * @param plblname bl名称
	 */
	public void setPlblname(String plblname) {
		this.plblname = plblname;
	}

	/**
	 * 功能：js事件名称取得
	 * @return js事件名称
	 */
	public String getPljsevent() {
		return pljsevent;
	}

	/**
	 * 功能：js事件名称设定
	 *
	 * @param pljsevent js事件名称
	 */
	public void setPljsevent(String pljsevent) {
		this.pljsevent = pljsevent;
	}

	/**
	 * 功能：表单关联类型取得
	 * @return 表单关联类型
	 */
	public String getPljtype() {
		return pljtype;
	}

	/**
	 * 功能：表单关联类型设定
	 * @param  pljtype 表单关联类型
	 */
	public void setPljtype(String pljtype) {
		this.pljtype = pljtype;
	}

	/**
	 * 功能：流程定义id取得
	 * @return 流程定义id
	 */
	public String getPldpdid() {
		return pldpdid;
	}

	/**
	 * 功能：流程定义id设定
	 * @param  pldpdid 流程定义id
	 */
	public void setPldpdid(String pldpdid) {
		this.pldpdid = pldpdid;
	}

	/**
	 * 功能：表单按钮id取得
	 * @return 表单按钮id
	 */
	public String getPldactionid() {
		return pldactionid;
	}

	/**
	 * 功能：表单按钮id设定
	 * @param  pldactionid 表单按钮id
	 */
	public void setPldactionid(String pldactionid) {
		this.pldactionid = pldactionid;
	}
	
	/**
	 * 功能：流程定义取得
	 * @return processDefinitionTB 流程定义
	 */
	public IG380TB getProcessDefinitionTB() {
		return processDefinitionTB;
	}

	/**
	 * 功能：流程定义设定
	 * @param  processDefinitionTB 流程定义
	 */
	public void setProcessDefinitionTB(IG380TB processDefinitionTB) {
		this.processDefinitionTB = processDefinitionTB;
	}

	/**
	 * 功能：主动表单名称取得
	 * @return 主动表单名称
	 */
	public String getInitiativepidname() {
		return initiativepidname;
	}

	/**
	 * 功能：主动表单名称设定
	 * @param  initiativepidname 主动表单名称
	 */
	public void setInitiativepidname(String initiativepidname) {
		this.initiativepidname = initiativepidname;
	}

	/**
	 * 功能：被动表单名称取得
	 * @return 被动表单名称
	 */
	public String getPassivitypidname() {
		return passivitypidname;
	}

	/**
	 * 功能：被动表单名称设定
	 * @param  passivitypidname 被动表单名称
	 */
	public void setPassivitypidname(String passivitypidname) {
		this.passivitypidname = passivitypidname;
	}


	
	
}
