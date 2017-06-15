/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:服务工单查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG933SearchCondImpl implements IG933SearchCond {
	
	/** 服务工单ID */
	protected Integer sfid;
	
	/** 服务工单编码 */
	protected String sfcode;
	
	/** 登记人部门ID */
	protected String sforgid;
	
	/** 登记人ID */
	protected String sfregisterid;
	
	/** 登记人NAME */
	protected String sfregistername;

	/** 登记开始时间 */
	protected String sfinstimebegin;

	/** 登记结束时间 */
	protected String sfinstimeend;
	
	/** 记录类别 */
	protected String sftype;

	/** 记录名称 */
	protected String sftitle;
	
	/** 记录状态 */
	protected String sfstatus;

	/** 报告人NAME */
	protected String sfreportname;
	
	/** 登记人NAME */
	protected String sfusername;
	
	/**
	 * 功能：服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	
	/**
	 * 功能：服务工单编码取得
	 * 
	 * @return 服务工单编码
	 */
	public String getSfcode() {
		return sfcode;
	}

	/**
	 * 功能：服务工单编码设置
	 * @param sfcode 服务工单编码
	 */
	public void setSfcode(String sfcode) {
		this.sfcode = sfcode;
	}
	
	/**
	 * 功能：登记人部门ID取得
	 * 
	 * @return 登记人部门ID
	 */
	public String getSforgid() {
		return sforgid;
	}

	public void setSforgid(String sforgid) {
		this.sforgid = sforgid;
	}

	/**
	 * 功能：登记人ID取得
	 * 
	 * @return 登记人ID
	 */
	public String getSfregisterid() {
		return sfregisterid;
	}

	/**
	 * 功能：登记人ID设置
	 * @param sfregisterid 登记人ID
	 */
	public void setSfregisterid(String sfregisterid) {
		this.sfregisterid = sfregisterid;
	}
	
	/**
	 * 功能：登记人NAME取得
	 * 
	 * @return 登记人NAME
	 */
	public String getSfregistername() {
		return sfregistername;
	}

	/**
	 * 功能：登记人NAME设置
	 * @param sfregistername 登记人NAME
	 */
	public void setSfregistername(String sfregistername) {
		this.sfregistername = sfregistername;
	}

	/**
	 * 功能：服务工单记录开始时间取得
	 * 
	 * @return 服务工单记录开始时间
	 */
	public String getSfinstimebegin() {
		return sfinstimebegin;
	}

	/**
	 * 功能：服务工单记录开始时间设置
	 * @param sfinstimebegin 服务工单记录开始时间
	 */
	public void setSfinstimebegin(String sfinstimebegin) {
		this.sfinstimebegin = sfinstimebegin;
	}

	/**
	 * 功能：服务工单记录结束时间取得
	 * 
	 * @return 服务工单记录结束时间
	 */
	public String getSfinstimeend() {
		return sfinstimeend;
	}

	/**
	 * 功能：服务工单记录结束时间设置
	 * @param sfinstimeend 服务工单记录结束时间
	 */
	public void setSfinstimeend(String sfinstimeend) {
		this.sfinstimeend = sfinstimeend;
	}
	
	/** 
	 * 功能：服务工单记录分类取得
	 * 
	 * @return 服务工单记录分类
	 */
	public String getSftype() {
		return sftype;
	}

	/**
	 * 功能：服务工单记录分类设置
	 * @param sftype 服务工单记录分类
	 */
	public void setSftype(String sftype) {
		this.sftype = sftype;
	}
	
	/** 
	 * 功能：服务工单记录名称取得
	 * 
	 * @return 服务工单记录名称
	 */
	public String getSftitle() {
		return sftitle;
	}

	/**
	 * 功能：服务工单记录名称设置
	 * @param sftitle 服务工单记录名称
	 */
	public void setSftitle(String sftitle) {
		this.sftitle = sftitle;
	}
	
	/** 
	 * 功能：服务工单记录状态取得
	 * 
	 * @return 服务工单记录状态
	 */
	public String getSfstatus() {
		return sfstatus;
	}

	/**
	 * 功能：服务工单记录状态设置
	 * @param sfstatus 服务工单记录状态
	 */
	public void setSfstatus(String sfstatus) {
		this.sfstatus = sfstatus;
	}

	
	/** 
	 * 功能：服务工单报告人NAME取得
	 * 
	 * @return 服务工单报告人NAME
	 */
	public String getSfreportname() {
		return sfreportname;
	}

	/**
	 * 功能：服务工单报告人NAME设置
	 * @param sfreportname 服务工单报告人NAME
	 */
	public void setSfreportname(String sfreportname) {
		this.sfreportname = sfreportname;
	}	
	/**
	 * 功能：服务工单登记人NAME取得
	 * 
	 * @return 服务工单报告人NAME
	 */
	public String getSfusername(){
		return sfusername;
	}
	
	/**
	 * 功能：服务工单登记人NAME设置
	 * @param sfusername 服务工单登记人NAME
	 */
	public void setSfusername(String sfusername) {
		this.sfusername = sfusername;
	}
}
