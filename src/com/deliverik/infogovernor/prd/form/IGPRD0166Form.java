/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;

/**
 * 概述: 表单初始化配置查询Form
 * 功能描述: 表单初始化配置查询Form
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD0166Form extends BaseForm implements IG373Info{
	
	/** 主键 */
	protected String piidid;

	/** 流程定义ID */
	protected String pdid;

	/** 状态ID */
	protected String psdid;

	/** BL名称 */
	protected String piidblid;

	/** 描述 */
	protected String piiddec;
	
	/** 记录时间戳 */
	protected String fingerPrint;

	/** 上级状态ID */
	protected String ppsdid;

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
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 *
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * BL名称取得
	 *
	 * @return BL名称
	 */
	public String getPiidblid() {
		return piidblid;
	}

	/**
	 * BL名称设定
	 *
	 * @param piidblid BL名称
	 */
	public void setPiidblid(String piidblid) {
		this.piidblid = piidblid;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPiiddec() {
		return piiddec;
	}

	/**
	 * 描述设定
	 *
	 * @param piiddec 描述
	 */
	public void setPiiddec(String piiddec) {
		this.piiddec = piiddec;
	}

	/**
	 * 记录时间戳取得
	 *
	 * @return 记录时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 记录时间戳设定
	 *
	 * @param fingerPrint 记录时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public IG333Info getIg333Info() {
		// TODO Auto-generated method stub
		return null;
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
