/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划流程信息表
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0002")
public class IGDWP0002TB extends BaseEntity implements IGDWP0002Info{
	
	/** 主键 */
	@Id
	@TableGenerator(
		    name="IGDWP0002_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0002_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0002_TABLE_GENERATOR")
	protected Integer id;
	
	/** 计划主键 */
	protected Integer planid;
	
	/** 流程标题 */
	protected String prtitle;
	
	/** 流程描述 */
	protected String prdesc;
	
	/** 联系方式 */
	protected String prinfo;
	
	/** 发起人角色ID */
	protected Integer prroleid;

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 计划主键取得
	 * @return planid 计划主键
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * 计划主键设定
	 * @param planid 计划主键
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	/**
	 * 流程标题取得
	 * @return prtitle 流程标题
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程标题设定
	 * @param prtitle 流程标题
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程描述取得
	 * @return prdesc 流程描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 流程描述设定
	 * @param prdesc 流程描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 联系方式取得
	 * @return prinfo 联系方式
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * 联系方式设定
	 * @param prinfo 联系方式
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * 发起人角色ID取得
	 * @return prroleid 发起人角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 发起人角色ID设定
	 * @param prroleid 发起人角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}
