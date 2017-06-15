/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prr.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 流程OA执行人Form
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0109Form extends BaseForm {

	/**参与者用户ID*/
	protected String[] ppuserids;
	
	/**变更编号*/
	protected Integer prid;

	/**操作角色ID*/
	protected Integer roleid;
	
	/**流程定义ID*/
	protected String pdid;
	
	/** 角色名称 */
	protected String rolename;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.ppuserids = null;
	}

	/**
	 * 获取变更编号
	 * @return 变更编号
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 设置变更编号
	 * @param prid 变更编号
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 获取操作角色ID
	 * @return 操作角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 设置操作角色ID
	 * @param roleid 操作角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 获取参与者用户ID
	 * @return 参与者用户ID
	 */
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * 设置参与者用户ID
	 * @param ppuserids 参与者用户ID
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}
	
	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}
	
	/**
	 * 角色名称设定
	 * @param rolename角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
