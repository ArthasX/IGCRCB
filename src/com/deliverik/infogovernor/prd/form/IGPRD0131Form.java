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
 * Description: 机构范围选择action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0131Form extends BaseForm{

	/** 流程定义主键 */
	protected String pdid;
	
	/** 要删除机构配置ID集合 */
	protected String[] orgid_del;
	
	/** 要添加的机构信息集合 */
	protected String[] orgid_add;
	
	/** 操作标识 0删除  1新增 */
	protected String model;
	
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/**
	 * 流程定义主键取得
	 * @return 流程定义主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义主键设定
	 * @param pdid 流程定义主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 要删除机构配置ID集合取得
	 * @return 要删除机构配置ID集合
	 */
	public String[] getOrgid_del() {
		return orgid_del;
	}

	/**
	 * 要删除机构配置ID集合设定
	 * @param orgid_del 要删除机构配置ID集合
	 */
	public void setOrgid_del(String[] orgid_del) {
		this.orgid_del = orgid_del;
	}

	/**
	 * 要添加的机构信息集合取得
	 * @return 要添加的机构信息集合
	 */
	public String[] getOrgid_add() {
		return orgid_add;
	}

	/**
	 * 要添加的机构信息集合设定
	 * @param orgid_add 要添加的机构信息集合
	 */
	public void setOrgid_add(String[] orgid_add) {
		this.orgid_add = orgid_add;
	}

	/**
	 * 操作标识取得
	 * @return 操作标识
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 操作标识设定
	 * @param model 操作标识
	 */
	public void setModel(String model) {
		this.model = model;
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
}
