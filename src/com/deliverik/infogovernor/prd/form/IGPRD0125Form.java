/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * 流程定义_参与者Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0125Form extends BaseForm implements IG286Info,IG286SearchCond{
	
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

	/** 流程定义id */
	protected String pldpdid;
	
	/**表单按钮id  */
	protected String pldactionid;
	
	/**流程id */
	protected String pdid;

	/**流程名称 */
	protected String pdname;
	
	/**流程描述 */
	protected String pddesc;
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return plid;
	}
	
	/**
	 * 主键ID
	 * @return 主键ID
	 */
	public String getPlid() {
		return plid;
	}

	/**
	 * 主键ID设定
	 *
	 * @param srid 主键ID
	 */
	public void setPlid(String plid) {
		this.plid = plid;
	}

	/**
	 * 主动id
	 * @return 主动id
	 */
	public String getInitiativepidid() {
		return initiativepidid;
	}

	/**
	 * 主动id设定
	 *
	 * @param initiativepidid 主动id
	 */
	public void setInitiativepidid(String initiativepidid) {
		this.initiativepidid = initiativepidid;
	}

	/**
	 * 被动id
	 * @return 被动id
	 */
	public String getPassivitypidid() {
		return passivitypidid;
	}

	/**
	 * 被动id设定
	 *
	 * @param passivitypidid 被动id
	 */
	public void setPassivitypidid(String passivitypidid) {
		this.passivitypidid = passivitypidid;
	}

	/**
	 * 关联描述
	 * @return 关联描述
	 */
	public String getPldesc() {
		return pldesc;
	}

	/**
	 * 关联描述设定
	 *
	 * @param pldesc 关联描述
	 */
	public void setPldesc(String pldesc) {
		this.pldesc = pldesc;
	}

	/**
	 * bl名称
	 * @return bl名称
	 */
	public String getPlblname() {
		return plblname;
	}

	/**
	 * bl名称设定
	 *
	 * @param plblname bl名称
	 */
	public void setPlblname(String plblname) {
		this.plblname = plblname;
	}

	/**
	 * js事件名称
	 * @return js事件名称
	 */
	public String getPljsevent() {
		return pljsevent;
	}

	/**
	 * js事件名称设定
	 *
	 * @param pljsevent js事件名称
	 */
	public void setPljsevent(String pljsevent) {
		this.pljsevent = pljsevent;
	}

	/**
	 * 表单关联类型
	 * @return 表单关联类型
	 */
	public String getPljtype() {
		return pljtype;
	}

	/**
	 * 表单关联类型
	 * @param  pljtype
	 */
	public void setPljtype(String pljtype) {
		this.pljtype = pljtype;
	}

	/**
	 * 流程定义id
	 * @return 流程定义id
	 */
	public String getPldpdid() {
		return pldpdid;
	}

	/**
	 * 流程定义id
	 * @param  pldpdid
	 */
	public void setPldpdid(String pldpdid) {
		this.pldpdid = pldpdid;
	}

	/**
	 * 表单按钮id
	 * @return 表单按钮id
	 */
	public String getPldactionid() {
		return pldactionid;
	}

	/**
	 * 表单按钮id
	 * @param  pldactionid
	 */
	public void setPldactionid(String pldactionid) {
		this.pldactionid = pldactionid;
	}

	/**
	 * 主动表单名称
	 * @return 主动表单名称
	 */
	public String getInitiativepidname() {
		return initiativepidname;
	}

	/**
	 * 主动表单名称
	 * @param  initiativepidname
	 */
	public void setInitiativepidname(String initiativepidname) {
		this.initiativepidname = initiativepidname;
	}

	/**
	 * 被动表单名称
	 * @return 被动表单名称
	 */
	public String getPassivitypidname() {
		return passivitypidname;
	}

	/**
	 * 被动表单名称
	 * @param  passivitypidname
	 */
	public void setPassivitypidname(String passivitypidname) {
		this.passivitypidname = passivitypidname;
	}
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	public String getPdname() {
		return pdname;
	}

	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	public String getPddesc() {
		return pddesc;
	}

	public void setPddesc(String pddesc) {
		this.pddesc = pddesc;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public IG380TB getProcessDefinitionTB() {
		// TODO Auto-generated method stub
		return null;
	}
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/**
	 * 查看模式
	 *
	 * @return 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式
	 *
	 * @param viewHistory  0：最新，1历史
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	public String getPlid_like() {
		// TODO Auto-generated method stub
		return null;
	}
}
