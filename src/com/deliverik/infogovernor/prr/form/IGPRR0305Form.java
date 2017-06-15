/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 相关发起选择列表Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0305Form extends BaseForm{
	
	/** 流程实例ID */
	protected Integer prid;

	/** 流程定义ID */
	protected String pdid;
	
	/** 状态节点定义ID */
	protected String psdid;
	
	/** 发起角色ID */
	protected Integer roleid;
	
	/** 扩展参数 */
	protected String parameters;

	/**
	 * 流程实例ID取得
	 * @return prid 流程实例ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程实例ID设定
	 * @param prid 流程实例ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态节点定义ID取得
	 * @return psdid 状态节点定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态节点定义ID设定
	 * @param psdid 状态节点定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 发起角色ID取得
	 * @return roleid 发起角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 发起角色ID设定
	 * @param roleid 发起角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 扩展参数取得
	 * @return parameters 扩展参数
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * 扩展参数设定
	 * @param parameters 扩展参数
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
