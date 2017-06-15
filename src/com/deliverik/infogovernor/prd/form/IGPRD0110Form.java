/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;

/**
 * 表单信息查询画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0110Form extends BaseForm implements IG007SearchCond {
	
	/** 表单信息是否是系统默认 */
	protected String isDefault;
	
	/** 表单信息的ID */
	protected String pidid;

	/** 表单信息的显示名称 */
	protected String pidlabel;

	/** 表单信息的后台显示名称 */
	protected String pidname;

	/** 表单信息的后台显示名称like查询条件 */
	protected String pidname_like;
	
	/** 表单信息是否必填项 */
	protected String pidrequired;

	/** 表单信息的类型 */
	protected String pidtype;
	
	/** 流程定义的ID */
	protected String pdid;
	
	protected Integer pidgid;
	
	/** 表单信息的模式 */
	protected String pidmode;
	
	protected String pidid_notlike;
	
	/** 父表单定义主键 */
    protected String ppidid;
    
    protected String tableColumn;
    
    /** 表格类表单显示模式 */
    protected String piddisplay;
    
    /** 返回地址 */
    protected String backURL;
	
	public String getPidid_notlike() {
		return pidid_notlike;
	}

	public void setPidid_notlike(String pidid_notlike) {
		this.pidid_notlike = pidid_notlike;
	}

	public Integer getPidgid() {
		return pidgid;
	}

	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}
	/**
	 * 表单信息是否是系统默认取得
	 * 
	 * @return 表单信息是否是系统默认
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * 表单信息是否是系统默认设定
	 *
	 * @param isDefault 表单信息是否是系统默认
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * 表单信息的ID取得
	 * 
	 * @return 表单信息的ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单信息的ID设定
	 *
	 * @param pidid 表单信息的ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单信息的显示名称取得
	 * 
	 * @return 表单信息德显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 表单信息德显示名称设定
	 *
	 * @param pidlabel 表单信息德显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 表单信息的后台显示名称取得
	 * 
	 * @return 表单信息的后台显示名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单信息的后台显示名称设定
	 *
	 * @param pidname 表单信息的后台显示名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 表单信息的后台显示名称like查询条件取得
	 * 
	 * @return 表单信息的后台显示名称like查询条件
	 */
	public String getPidname_like() {
		return pidname_like;
	}

	/**
	 * 表单信息的后台显示名称like查询条件设定
	 *
	 * @param pidname_like 表单信息的后台显示名称like查询条件
	 */
	public void setPidname_like(String pidname_like) {
		this.pidname_like = pidname_like;
	}

	/**
	 * 表单信息是否必填项取得
	 * 
	 * @return 表单信息是否必填项
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 表单信息是否必填项设定
	 *
	 * @param pidname_like 表单信息是否必填项
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * 表单信息的类型取得
	 * 
	 * @return 表单信息的类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 表单信息的类型设定
	 *
	 * @param pidtype 表单信息的类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 流程定义的ID取得
	 * 
	 * @return 流程定义的ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义的ID设定
	 *
	 * @param pdid 流程定义的ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 表单信息的模式取得
	 *
	 * @return 表单信息的模式
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * 表单信息的模式设定
	 *
	 * @param pidmode 表单信息的模式
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.pidmode = null;
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

	public String getPpdid_like() {
		return null;
	}

	public String getPsdid_like() {
		return null;
	}
	
	public String getPsdcode_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidid_like() {
		// TODO Auto-generated method stub
		return null;
	}

    public String[] getPidtypes() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
	 * 父表单定义主键取得
	 * @return ppidid 父表单定义主键
	 */
	public String getPpidid() {
		return ppidid;
	}

	/**
	 * 父表单定义主键设定
	 * @param ppidid 父表单定义主键
	 */
	public void setPpidid(String ppidid) {
		this.ppidid = ppidid;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}
	
	/**
	 * 表格类表单显示模式取得
	 * @return 表格类表单显示模式
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * 表格类表单显示模式设定
	 * @param piddisplay 表格类表单显示模式
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	public String getIsExport() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 返回地址取得
	 * @return backURL 返回地址
	 */
	public String getBackURL() {
		return backURL;
	}

	/**
	 * 返回地址设定
	 * @param backURL 返回地址
	 */
	public void setBackURL(String backURL) {
		this.backURL = backURL;
	}

	public String getPiduse() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
