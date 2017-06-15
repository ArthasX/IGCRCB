/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;

/**
  * 概述: 虚拟资源项目信息表实体
  * 功能描述: 虚拟资源项目信息表实体
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VIM02")
public class VIM02TB extends BaseEntity implements Serializable,
		Cloneable, VIM02Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VIM02_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM02_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM02_TABLE_GENERATOR")
	protected Integer id;

	/** 项目名称 */
	protected String projectName;

	/** 期望部署时间 */
	protected String expectDeployTime;

	/** 项目到期时间 */
	protected String projectExpireTime;

	/** 项目类别 */
	protected String projectType;

	/** 项目说明 */
	protected String projectDesc;

	/** 申请说明 */
	protected String projectApplyReason;

	/** 机构层次码 */
	protected String orgsyscoding;
	
	/** 机构名称 */
	protected String orgname;
	
	/** 自动部署进度 */
    protected String progress;
    
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 项目名称取得
	 *
	 * @return 项目名称
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 项目名称设定
	 *
	 * @param projectName 项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 期望部署时间取得
	 *
	 * @return 期望部署时间
	 */
	public String getExpectDeployTime() {
		return expectDeployTime;
	}

	/**
	 * 期望部署时间设定
	 *
	 * @param expectDeployTime 期望部署时间
	 */
	public void setExpectDeployTime(String expectDeployTime) {
		this.expectDeployTime = expectDeployTime;
	}

	/**
	 * 项目到期时间取得
	 *
	 * @return 项目到期时间
	 */
	public String getProjectExpireTime() {
		return projectExpireTime;
	}

	/**
	 * 项目到期时间设定
	 *
	 * @param projectExpireTime 项目到期时间
	 */
	public void setProjectExpireTime(String projectExpireTime) {
		this.projectExpireTime = projectExpireTime;
	}

	/**
	 * 项目类别取得
	 *
	 * @return 项目类别
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * 项目类别设定
	 *
	 * @param projectType 项目类别
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * 项目说明取得
	 *
	 * @return 项目说明
	 */
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * 项目说明设定
	 *
	 * @param projectDesc 项目说明
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	/**
	 * 申请说明取得
	 *
	 * @return 申请说明
	 */
	public String getProjectApplyReason() {
		return projectApplyReason;
	}

	/**
	 * 申请说明设定
	 *
	 * @param projectApplyReason 申请说明
	 */
	public void setProjectApplyReason(String projectApplyReason) {
		this.projectApplyReason = projectApplyReason;
	}

	/**
     * 获取机构层次码
     * @return 机构层次码 
     */
    public String getOrgsyscoding() {
        return orgsyscoding;
    }

    /**
     * 设置机构层次码
     * @param orgsyscoding 机构层次码
     */
    public void setOrgsyscoding(String orgsyscoding) {
        this.orgsyscoding = orgsyscoding;
    }

    /**
     * 获取机构名称
     * @return 机构名称 
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 设置机构名称
     * @param orgname 机构名称
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    /**
     * 获取自动部署进度
     * @return 自动部署进度 
     */
    public String getProgress() {
        return progress;
    }

    /**
     * 设置自动部署进度
     * @param progress 自动部署进度
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

}