/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;

/**
 * 流程定义基本信息编辑画面Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0102Form extends BaseForm implements IG380Info,IG243Info {
	
	/** 流程类型的创建时间 */
	protected String pdcrtdate;
	
	/** 流程类型的描述 */
	protected String pddesc;

	/** 流程定义的ID */
	protected String pdid;
	
	/** 流程类型的名称 */
	protected String pdname;
	
	/** 流程类型的名称 */
	protected String pdname_bak;
	
	/** 流程类型的状态 */
	protected String pdstatus;
	
	/** 流程状态停用类型 TEST:为测试停用 CHANGE:为发布 */
	protected String flag;
	
	/** 流程模板的ID */
	protected Integer ptid;
	
	/** 流程定义记录的时间戳 */
	protected String fingerPrint;
	
	/** 模式 0登记，1编辑 */
	protected String mode = "0";
	
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;
	
	protected String pdxml;
	
	protected String pttype;
	
	/**
	 * 流程日志权限
	 */
	protected String permission;
	
	protected String ptdid;

	/** 主题名称定义 */
	protected String ptitlename;

	/** 主题名称权限 0可见；1不可见 */
	protected String ptitleaccess;

	/** 描述字段名称 */
	protected String pdescname;

	/** 描述字段权限 0：可见，1不可见 */
	protected String pdescaccess;
	
	/** 工单号生成器 */
	protected String serialgenerator;
	
	/** 菜单ID */
	protected String pdactname;
	
	  /** 监管报表填报说明 */
    protected String reportdesc;
    
    /** 提醒信息生成器 */
    protected String messagegenerator;
    
    /** 流程编号 */
    protected String pdserialnumber;
    
    /** 服务目录层次码 */
    protected String pdservicecatalog;
    
    /** 服务目录显示名称 */
    protected String pdservicecatalogname;
	
	/**
	 * 流程日志权限取得
	 * @return 流程日志权限
	 */
	public String getPermission() {
		return permission;
	}


	/**
	 * 流程日志权限设定
	  * @param permission 流程日志权限
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	/**
	 * 流程类型的创建时间取得
	 * 
	 * @return 流程类型的创建时间
	 */
	public String getPdcrtdate() {
		return pdcrtdate;
	}

	/**
	 * 流程类型的创建时间设定
	 *
	 * @param pdcrtdate 流程类型的创建时间
	 */
	public void setPdcrtdate(String pdcrtdate) {
		this.pdcrtdate = pdcrtdate;
	}

	/**
	 * 流程类型的描述取得
	 * 
	 * @return 流程类型的描述
	 */
	public String getPddesc() {
		return pddesc;
	}

	/**
	 * 流程类型的描述设定
	 *
	 * @param pddesc 流程类型的描述
	 */
	public void setPddesc(String pddesc) {
		this.pddesc = pddesc;
	}

	/**
	 * 流程类型的ID取得
	 * 
	 * @return 流程类型的ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型的ID设定
	 *
	 * @param pdid 流程类型的ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程类型的名称取得
	 * 
	 * @return 流程类型的名称
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * 流程类型的名称设定
	 *
	 * @param pdname 流程类型的名称
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * 流程类型的状态取得
	 * 
	 * @return 流程类型的状态
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * 流程类型的状态设定
	 *
	 * @param pdstatus 流程类型的状态
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}


	/**
	 * 流程模板的ID取得
	 * 
	 * @return 流程模板的ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模板的ID设定
	 *
	 * @param ptid 流程模板的ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 流程定义记录的时间戳取得
	 * 
	 * @return 流程定义记录的时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 流程定义记录的时间戳设定
	 *
	 * @param fingerPrint 流程定义记录的时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 模式取得
	 * 
	 * @return 模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 模式设定
	 *
	 * @param mode 模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 流程类型的名称取得
	 * 
	 * @return 流程类型的名称
	 */
	public String getPdname_bak() {
		return pdname_bak;
	}

	/**
	 * 流程类型的名称设定
	 *
	 * @param pdname_bak 流程类型的名称
	 */
	public void setPdname_bak(String pdname_bak) {
		this.pdname_bak = pdname_bak;
	}

	public String getPdxml() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPttype() {
		return pttype;
	}

	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * 主键设定
	 *
	 * @param ptdid 主键
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * 主题名称定义取得
	 *
	 * @return 主题名称定义
	 */
	public String getPtitlename() {
		return ptitlename;
	}

	/**
	 * 主题名称定义设定
	 *
	 * @param ptitlename 主题名称定义
	 */
	public void setPtitlename(String ptitlename) {
		this.ptitlename = ptitlename;
	}

	/**
	 * 主题名称权限 0可见；1不可见取得
	 *
	 * @return 主题名称权限 0可见；1不可见
	 */
	public String getPtitleaccess() {
		return ptitleaccess;
	}

	/**
	 * 主题名称权限 0可见；1不可见设定
	 *
	 * @param ptitleaccess 主题名称权限 0可见；1不可见
	 */
	public void setPtitleaccess(String ptitleaccess) {
		this.ptitleaccess = ptitleaccess;
	}

	/**
	 * 描述字段名称取得
	 *
	 * @return 描述字段名称
	 */
	public String getPdescname() {
		return pdescname;
	}

	/**
	 * 描述字段名称设定
	 *
	 * @param pdescname 描述字段名称
	 */
	public void setPdescname(String pdescname) {
		this.pdescname = pdescname;
	}

	/**
	 * 描述字段权限 0：可见，1不可见取得
	 *
	 * @return 描述字段权限 0：可见，1不可见
	 */
	public String getPdescaccess() {
		return pdescaccess;
	}

	/**
	 * 描述字段权限 0：可见，1不可见设定
	 *
	 * @param pdescaccess 描述字段权限 0：可见，1不可见
	 */
	public void setPdescaccess(String pdescaccess) {
		this.pdescaccess = pdescaccess;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ptdid;
	}

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


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 工单号生成器取得
	 * 
	 * @return 工单号生成器
	 */
	public String getSerialgenerator() {
		return serialgenerator;
	}

	/**
	 * 工单号生成器设定
	 * 
	 * @param serialgenerator 工单号生成器
	 */
	public void setSerialgenerator(String serialgenerator) {
		this.serialgenerator = serialgenerator;
	}

	/** 所属一级菜单列表 */
    protected List<LabelValueBean> actionLabelValueList;

    /**
     * @return the 所属一级菜单列表
     */
    public List<LabelValueBean> getActionLabelValueList() {
        return actionLabelValueList;
    }

    /**
     * @param 所属一级菜单列表 the actionLabelValueList to set
     */
    public void setActionLabelValueList(List<LabelValueBean> actionLabelValueList) {
        this.actionLabelValueList = actionLabelValueList;
    }
    
    /**
     * @return the 菜单ID
     */
    public String getPdactname() {
        return pdactname;
    }


    /**
     * @param 菜单ID the pdactname to set
     */
    public void setPdactname(String pdactname) {
        this.pdactname = pdactname;
    }


	/**
	 * 监管报表填报说明取得
	 * @return reportdesc 监管报表填报说明
	 */
	public String getReportdesc() {
		return reportdesc;
	}


	/**
	 * 监管报表填报说明设定
	 * @param reportdesc 监管报表填报说明
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}


	/**
	 * 提醒信息生成器取得
	 * @return messagegenerator 提醒信息生成器
	 */
	public String getMessagegenerator() {
		return messagegenerator;
	}


	/**
	 * 提醒信息生成器设定
	 * @param messagegenerator 提醒信息生成器
	 */
	public void setMessagegenerator(String messagegenerator) {
		this.messagegenerator = messagegenerator;
	}


	/**
	 * 流程编号取得
	 * @return pdserialnumber 流程编号
	 */
	public String getPdserialnumber() {
		return pdserialnumber;
	}


	/**
	 * 流程编号设定
	 * @param pdserialnumber 流程编号
	 */
	public void setPdserialnumber(String pdserialnumber) {
		this.pdserialnumber = pdserialnumber;
	}


	/**
	 * 服务目录层次码取得
	 * @return pdservicecatalog 服务目录层次码
	 */
	public String getPdservicecatalog() {
		return pdservicecatalog;
	}


	/**
	 * 服务目录层次码设定
	 * @param pdservicecatalog 服务目录层次码
	 */
	public void setPdservicecatalog(String pdservicecatalog) {
		this.pdservicecatalog = pdservicecatalog;
	}


	/**
	 * 服务目录显示名称取得
	 * @return pdservicecatalogname 服务目录显示名称
	 */
	public String getPdservicecatalogname() {
		return pdservicecatalogname;
	}


	/**
	 * 服务目录显示名称设定
	 * @param pdservicecatalogname 服务目录显示名称
	 */
	public void setPdservicecatalogname(String pdservicecatalogname) {
		this.pdservicecatalogname = pdservicecatalogname;
	}
    
}
