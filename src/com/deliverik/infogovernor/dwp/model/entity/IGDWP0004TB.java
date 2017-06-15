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
import com.deliverik.infogovernor.dwp.model.IGDWP0004Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划参与人信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0004")
public class IGDWP0004TB extends BaseEntity implements IGDWP0004Info{

	/** 主键 */
	@Id
	@TableGenerator(
		    name="IGDWP0004_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0004_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0004_TABLE_GENERATOR")
	protected Integer id;
	
	/** 计划ID */
	protected Integer planid;
	
	/** 流程信息ID */
	protected Integer prid;
	
	/** 状态ID */
	protected String psdid;
	
	/** 用户ID */
	protected String userid;
	
	/** 处理角色ID */
	protected Integer roleid;
	
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
	 * 计划ID取得
	 * @return planid 计划ID
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * 计划ID设定
	 * @param planid 计划ID
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	/**
	 * 流程信息ID取得
	 * @return prid 流程信息ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程信息ID设定
	 * @param prid 流程信息ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态ID取得
	 * @return psdid 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 用户ID取得
	 * @return usersid 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 * @param usersid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 处理角色ID取得
	 * @return roleid 处理角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 处理角色ID设定
	 * @param roleid 处理角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}
