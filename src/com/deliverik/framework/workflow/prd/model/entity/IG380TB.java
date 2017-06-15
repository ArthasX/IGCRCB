package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG380Info;


/**
 * 流程类型定义信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG380")
public class IG380TB extends BaseEntity implements Serializable, Cloneable, IG380Info {
	/**
	 * 流程类型定义ID
	 */
	@Id
	protected String pdid;

	/**
	 * 流程模板ID
	 */
	protected Integer ptid;

	/**
	 * 流程类型定义名称
	 */
	protected String pdname;

	/**
	 * 流程类型定义描述
	 */
	protected String pddesc;

	/**
	 * 流程类型定义创建时间
	 */
	protected String pdcrtdate;

	/**
	 * 流程类型定义状态（a启用，i停用）
	 */
	protected String pdstatus;
	
	/**
	 * 流程图xml信息
	 */
	protected String pdxml;

	/**
	 * 流程日志权限
	 */
	protected String permission;
	
	/**
	 * 工单号生成器
	 */
	protected String serialgenerator;

	/**
     * 菜单ID
     */
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
	 * 主键取得
	 * @return pdid
	 */
	public Serializable getPK() {
		return pdid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG380TB))
			return false;
		IG380Info target = (IG380Info) obj;
		if (!(getPdid()==target.getPdid()))
			return false;
		return true;
	}

	
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
	 * 流程类型定义ID取得
	 * @return 流程类型定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型定义ID设定
	  * @param pdid 流程类型定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模板ID设定
	  * @param ptid 流程模板ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 流程类型定义名称取得
	 * @return 流程类型定义名称
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * 流程类型定义名称设定
	  * @param pdname 流程类型定义名称
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * 流程类型定义描述取得
	 * @return 流程类型定义描述
	 */
	public String getPddesc() {
		return pddesc;
	}

	/**
	 * 流程类型定义描述设定
	  * @param pddesc 流程类型定义描述
	 */
	public void setPddesc(String pddesc) {
		this.pddesc = pddesc;
	}

	/**
	 * 流程类型定义创建时间取得
	 * @return 流程类型定义创建时间
	 */
	public String getPdcrtdate() {
		return pdcrtdate;
	}

	/**
	 * 流程类型定义创建时间设定
	  * @param pdcrtdate 流程类型定义创建时间
	 */
	public void setPdcrtdate(String pdcrtdate) {
		this.pdcrtdate = pdcrtdate;
	}

	/**
	 * 流程类型定义状态取得
	 * @return 流程类型定义状态
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * 流程类型定义状态设定
	  * @param pdstatus 流程类型定义状态
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}

	/**
	 * 流程图xml信息取得
	 * @return 流程图xml信息
	 */
	public String getPdxml() {
		return pdxml;
	}

	/**
	 * 流程图xml信息设定
	  * @param pdxml 流程图xml信息
	 */
	public void setPdxml(String pdxml) {
		this.pdxml = pdxml;
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


	/**
     * 菜单ID取得
     * 
     * @return 菜单ID
     */
    public String getPdactname() {
        return pdactname;
    }


    /**
     * 菜单ID设定
     * 
     * @param pdactname 菜单ID
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
