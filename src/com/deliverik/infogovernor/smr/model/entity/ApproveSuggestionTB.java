/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
  * 概述: 审批意见表实体
  * 功能描述: 审批意见表实体
  * 创建记录: 2013/07/22
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ApproveSuggestion")
public class ApproveSuggestionTB extends BaseEntity implements Serializable,
		Cloneable, ApproveSuggestionInfo {

	/** 自增ID */
	@Id
	@TableGenerator(
		name="APPROVESUGGESTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="APPROVESUGGESTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="APPROVESUGGESTION_TABLE_GENERATOR")
	protected Integer id;

	/** 表单定义ID */
	protected String pidid;

	/** 流程ID */
	protected Integer prid;
	
	/** 状态标识 */
	protected String psdcode;

	/** 状态名称 */
	protected String psdname;

	/** 意见 */
	protected String suggestion;

	/** 意见状态 */
	protected String status;

	/** 驳回时间 */
	protected String inserttime;

	/** 驳回人ID */
	protected String userid;

	/** 驳回人姓名 */
	protected String username;
	
	/** 表格式表单行号 */
	protected String rownumber;

	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 自增ID设定
	 *
	 * @param id 自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}
	
	/**
	 * 表单定义ID设定
	 *
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程ID取得
	 *
	 * @return prid 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态标识取得
	 *
	 * @return 状态标识
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 状态标识设定
	 *
	 * @param psdcode 状态标识
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 状态名称取得
	 *
	 * @return 状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 状态名称设定
	 *
	 * @param psdname 状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * 意见取得
	 *
	 * @return 意见
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * 意见设定
	 *
	 * @param suggestion 意见
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * 意见状态取得
	 *
	 * @return 意见状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 意见状态设定
	 *
	 * @param status 意见状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 驳回时间取得
	 *
	 * @return 驳回时间
	 */
	public String getInserttime() {
		return inserttime;
	}

	/**
	 * 驳回时间设定
	 *
	 * @param inserttime 驳回时间
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}

	/**
	 * 驳回人ID取得
	 *
	 * @return 驳回人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 驳回人ID设定
	 *
	 * @param userid 驳回人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 驳回人姓名取得
	 *
	 * @return 驳回人姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 驳回人姓名设定
	 *
	 * @param username 驳回人姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 表格式表单行号取得
	 * @return rownumber 表格式表单行号
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * 表格式表单行号设定
	 * @param rownumber 表格式表单行号
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
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