/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;

/**
 * 概述: 表单初始化配置查询Form
 * 功能描述: 表单初始化配置查询Form
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD0165Form extends BaseForm implements IG373SearchCond{
	
	/** 流程定义ID */
	protected String pdid;

	/** 流程状态ID */
	protected String psdid;

	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;
	
	/** 主键 */
	protected String piidid;

	/** 上级状态ID */
	protected String ppsdid;

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
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

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPiidid() {
		return piidid;
	}

	/**
	 * 主键设定
	 *
	 * @param piidid 主键
	 */
	public void setPiidid(String piidid) {
		this.piidid = piidid;
	}

	/**
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级状态ID设定
	 * @param ppsdid 上级状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
}
