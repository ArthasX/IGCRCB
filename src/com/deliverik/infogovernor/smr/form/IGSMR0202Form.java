/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 审批意见查询Form
 *
 */
@SuppressWarnings("serial")
public class IGSMR0202Form extends BaseForm {
	
	/** 流程表单定义主键 */
	protected String pidid;
	
	/** 流程主键 */
	protected Integer prid;
	
	/** 表格式表单行号 */
	protected String rownumber;

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
}