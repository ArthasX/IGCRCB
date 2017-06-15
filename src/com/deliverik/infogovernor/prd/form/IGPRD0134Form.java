/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 参与者支持机构选择form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0134Form extends BaseForm{

	/** 流程ID */
	protected String pdid;
	
	/** 流程状态ID */
	protected String psdid;
	
	/** 机构码集合 */
	protected String [] orgids;
	
	/** 用户id集合 */
	protected String [] ppuserids;
	
	/** 参与者配置信息主键集合 */
	protected String [] ppdids;
	
	/**处理方式：0-删除，1-增加*/
	protected String mode;
	
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/** 上级状态ID */
	protected String ppsdid;

	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程ID设定
	 * @param pdid 流程ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态ID取得
	 * @return 状态ID
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
	 * 机构码集合取得
	 * @return 机构码集合
	 */
	public String[] getOrgids() {
		return orgids;
	}

	/**
	 * 机构码集合设定
	 * @param orgids 机构码集合
	 */
	public void setOrgids(String[] orgids) {
		this.orgids = orgids;
	}

	/**
	 * 用户id集合取得
	 * @return 用户id集合
	 */
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * 用户id集合设定
	 * @param ppuserids 用户id集合
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	/**
	 * 参与者配置信息主键集合取得
	 * @return 参与者配置信息主键集合
	 */
	public String[] getPpdids() {
		return ppdids;
	}

	/**
	 * 参与者配置信息主键集合设定
	 * @param ppdids 参与者配置信息主键集合
	 */
	public void setPpdids(String[] ppdids) {
		this.ppdids = ppdids;
	}

	/**
	 * 处理方式取得
	 * @return 处理方式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 处理方式设定
	 * @param mode 处理方式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 查看模式取得
	 * @return viewHistory 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式设定
	 * @param viewHistory  查看模式
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
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
