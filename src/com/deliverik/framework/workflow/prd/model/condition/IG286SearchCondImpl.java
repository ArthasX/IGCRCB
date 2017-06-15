/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * <p>概述:流程级联表单查询条件实现</p>
 * <p>功能描述:</p>
 * <p>创建记录：</p>
 */
public class IG286SearchCondImpl implements IG286SearchCond {
	
	/** 级联表单ID*/
	protected String plid;

	/** 主动表单ID*/
	protected String initiativepidid;
	
	/** 被动表单ID*/
	protected String passivitypidid;
	
	/** 联动表单说明*/
	protected String pldesc;
	
	/** 联动表单BL */
	protected String plblname;
	
	/** 联动表单JS */
	protected String pljsevent;
	
	/** 联动表单类型 */
	protected String pljtype;

	/** 流程id*/
	protected String pldpdid;
	
	/** 联动ActionID */
	protected String pldactionid;
	
	/** 主键 */
	protected String plid_like;
	
	/**
	 * 功能：级联表单ID取得
	 * @return plid 级联表单ID
	 */
	public String getPlid() {
		return plid;
	}

	/**
	 * 功能：级联表单ID设定
	 * @param  plid 级联表单ID
	 */
	public void setPlid(String plid) {
		this.plid = plid;
	}

	/**
	 * 功能：主动表单ID取得
	 * @return initiativepidid 主动表单ID
	 */
	public String getInitiativepidid() {
		return initiativepidid;
	}

	/**
	 * 功能：主动表单ID设定
	 * @param  initiativepidid 主动表单ID
	 */
	public void setInitiativepidid(String initiativepidid) {
		this.initiativepidid = initiativepidid;
	}

	/**
	 * 功能：联动表单ID取得
	 * @return passivitypidid 联动表单ID
	 */
	public String getPassivitypidid() {
		return passivitypidid;
	}

	/**
	 * 功能：联动表单ID设定
	 * @param  passivitypidid 联动表单ID
	 */
	public void setPassivitypidid(String passivitypidid) {
		this.passivitypidid = passivitypidid;
	}

	/**
	 * 功能：联动表单说明取得
	 * @return pldesc 联动表单说明
	 */
	public String getPldesc() {
		return pldesc;
	}

	/**
	 * 功能：联动表单说明设定
	 * @param  pldesc 联动表单说明
	 */
	public void setPldesc(String pldesc) {
		this.pldesc = pldesc;
	}

	/**
	 * 功能：联动表单BL名称取得
	 * @return plblname 联动表单BL名称
	 */
	public String getPlblname() {
		return plblname;
	}

	/**
	 * 功能：联动表单BL名称设定
	 * @param  plblname 联动表单BL名称
	 */
	public void setPlblname(String plblname) {
		this.plblname = plblname;
	}

	/**
	 * 功能：联动表单JS事件取得
	 * @return pljsevent 联动表单JS事件
	 */
	public String getPljsevent() {
		return pljsevent;
	}

	/**
	 * 功能：联动表单JS事件设定
	 * @param  pljsevent 联动表单JS事件
	 */
	public void setPljsevent(String pljsevent) {
		this.pljsevent = pljsevent;
	}
	
	/**
	 * 功能：联动表单类型取得
	 * @return pljtype 联动表单类型
	 */
	public String getPljtype() {
		return pljtype;
	}

	/**
	 * 功能：联动表单类型设定
	 * @param  pljtype 联动表单类型
	 */
	public void setPljtype(String pljtype) {
		this.pljtype = pljtype;
	}

	/**
	 * 功能：流程ID取得
	 * @return pldpdid 流程ID
	 */
	public String getPldpdid() {
		return pldpdid;
	}

	/**
	 * 功能：流程ID设定
	 * @param  pldpdid 流程ID
	 */
	public void setPldpdid(String pldpdid) {
		this.pldpdid = pldpdid;
	}

	/**
	 * 功能：流程actionID取得
	 * @return pldactionid 流程actionID
	 */
	public String getPldactionid() {
		return pldactionid;
	}

	/**
	 * 功能：流程actionID设定
	 * @param  pldactionid 流程actionID
	 */
	public void setPldactionid(String pldactionid) {
		this.pldactionid = pldactionid;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPlid_like() {
		return plid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param plid_like 主键
	 */
	public void setPlid_like(String plid_like) {
		this.plid_like = plid_like;
	}
	
}
