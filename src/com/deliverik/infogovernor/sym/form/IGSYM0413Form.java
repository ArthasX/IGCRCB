/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * 报表信息查询Form
 * 
 */
@SuppressWarnings("serial")
public class IGSYM0413Form extends BaseForm implements ReportFileDefinitionSearchCond {

	/** 报表显示名称(模糊匹配) */
	protected String rfdtitle_like;
	
	/** 报表显示名称 */
	protected String rfdtitle;
	
	/**  报表分类 */
	protected String rfdtype;
	
	/** 报表删除主键 */
	protected String[] deleteRfdid;
	
	/** 报表主键 */
	protected Integer rfdid;
	
	/** 报表分类显示名称 */
	protected String rfdtypename;
	
	/** 报表发布名称 */
	protected String rfdfilename;
	
	/** 报表说明 */
	protected String rfddesc;
	
	/** 报表类型 */
	protected String rfdpictype;

	/**
	 * 报表显示名称(模糊匹配)取得
	 * @return 报表显示名称(模糊匹配)
	 */
	public String getRfdtitle_like() {
		return rfdtitle_like;
	}
	
	/**
	 * 报表显示名称(模糊匹配)设定
	 * @param rfdtitle_like 报表显示名称(模糊匹配)
	 */
	public void setRfdtitle_like(String rfdtitle_like) {
		this.rfdtitle_like = rfdtitle_like;
	}
	
	/**
	 * 报表显示名称取得
	 * @return 报表显示名称
	 */
	public String getRfdtitle() {
		return rfdtitle;
	}

	/**
	 * 报表显示名称设定
	 * @param rfdtitle 报表显示名称
	 */
	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}

	/**
	 * 报表分类取得
	 * @return 报表分类
	 */
	public String getRfdtype() {
		return rfdtype;
	}

	/**
	 * 报表分类设定
	 * @param rfdtype 报表分类
	 */
	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}
	
	/**
	 * 报表删除主键取得
	 * @return 报表删除主键
	 */
	public String[] getDeleteRfdid() {
		return deleteRfdid;
	}

	/**
	 * 报表删除主键设定
	 * @param deleteRfdid 报表删除主键
	 */
	public void setDeleteRfdid(String[] deleteRfdid) {
		this.deleteRfdid = deleteRfdid;
	}
	
	/**
	 * 初始化处理
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteRfdid = null;
		this.rfdid = null;
	}
	
	/**
	 * 报表分类显示名称取得
	 * 
	 * @return 报表分类显示名称
	 */
	public String getRfdtypename() {
		return rfdtypename;
	}

	/**
	 * 报表分类显示名称设定
	 *
	 * @param rfdtypename 报表分类显示名称
	 */
	public void setRfdtypename(String rfdtypename) {
		this.rfdtypename = rfdtypename;
	}
	
	/**
	 * 报表主键取得
	 * @return 报表主键
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * 报表主键设定
	 * @param rfdid 报表主键
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}
	
	/**
	 * 报表发布名称取得
	 * @return 报表发布名称
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * 报表发布名称设定
	 * @param rfdfilename 报表发布名称
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}

	public String getRfddesc() {
		return rfddesc;
	}

	public void setRfddesc(String rfddesc) {
		this.rfddesc = rfddesc;
	}

	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}
	
	
}
