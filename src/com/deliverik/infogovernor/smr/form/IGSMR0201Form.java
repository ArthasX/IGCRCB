/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 审批意见新增Form
 *
 */
@SuppressWarnings("serial")
public class IGSMR0201Form extends BaseForm {
	
	/** 审批意见主键 */
	protected Integer id;
	
	/** 流程表单定义主键 */
	protected String pidid;
	
	/** 流程主键 */
	protected Integer prid;
	
	/** 状态标识 */
	protected String psdcode;
	
	/** 状态名称 */
	protected String psdname;
	
	/** 审批意见 */
	protected String suggestion;
	
	/** 表格式表单审批意见 */
	protected String rownumber;

	/**
	 * 审批意见主键取得
	 *
	 * @return id 审批意见主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 审批意见主键设定
	 *
	 * @param id 审批意见主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 流程表单定义主键取得
	 *
	 * @return pidid 流程表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程表单定义主键设定
	 *
	 * @param pidid 流程表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程主键取得
	 *
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 *
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态标识取得
	 *
	 * @return psdcode 状态标识
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
	 * @return psdname 状态名称
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
	 * 审批意见取得
	 *
	 * @return suggestion 审批意见
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * 审批意见设定
	 *
	 * @param suggestion 审批意见
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * 表格式表单审批意见取得
	 * @return rownumber 表格式表单审批意见
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * 表格式表单审批意见设定
	 * @param rownumber 表格式表单审批意见
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}
	

}