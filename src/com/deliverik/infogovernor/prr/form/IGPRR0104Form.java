/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prr.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 流程改派Form
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0104Form extends BaseForm {

	/** 流程ID */
	protected Integer prid;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 角色ID */
	protected Integer roleid;

	/** 参与者ID（格式：roleid_userid）*/
	protected String[] participants;

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.participants = null;
	}
	
	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
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
	 * 角色ID取得
	 * 
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * 
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 参与者ID取得
	 * 
	 * @return 参与者ID
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * 参与者ID设定
	 * 
	 * @param participants 参与者ID
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
	
}
