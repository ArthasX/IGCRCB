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
 * Description: 流程分派form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0103Form extends BaseForm{

	/** 流程主键 */
	protected Integer prid;
	
	/** 流程定义主键 */
	protected String pdid;
	
	/** 状态节点主键 */
	protected String psdid;
	
	/** 操作按钮标识 */
	protected String action;
	
	/** 操作角色 */
	protected Integer prroleid;
	
	/** 参与者ID（格式：roleid_userid）*/
	protected String[] participants;
	
	/** 参与者ID（格式：roleid_）*/
	protected String[] participants_;
	
	/** 主办部门 */
	protected String[] ppsupers;
	
	/** 快捷发起标识 */
	protected String isServiceStart;

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程定义主键取得
	 * @return pdid 流程定义主键
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
	 * 状态节点主键取得
	 * @return psdid 状态节点主键
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态节点主键设定
	 * @param psdid 状态节点主键
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 操作按钮标识取得
	 * @return action 操作按钮标识
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 操作按钮标识设定
	 * @param action 操作按钮标识
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 操作角色取得
	 * @return prroleid 操作角色
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 操作角色设定
	 * @param prroleid 操作角色
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 参与者ID（格式：roleid_userid）取得
	 * @return participants 参与者ID（格式：roleid_userid）
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * 参与者ID（格式：roleid_userid）设定
	 * @param participants 参与者ID（格式：roleid_userid）
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	/**
	 * 参与者ID（格式：roleid_）取得
	 * @return participants_ 参与者ID（格式：roleid_）
	 */
	public String[] getParticipants_() {
		return participants_;
	}

	/**
	 * 参与者ID（格式：roleid_）设定
	 * @param participants_ 参与者ID（格式：roleid_）
	 */
	public void setParticipants_(String[] participants_) {
		this.participants_ = participants_;
	}

	/**
	 * 主办部门取得
	 * @return ppsupers 主办部门
	 */
	public String[] getPpsupers() {
		return ppsupers;
	}

	/**
	 * 主办部门设定
	 * @param ppsupers 主办部门
	 */
	public void setPpsupers(String[] ppsupers) {
		this.ppsupers = ppsupers;
	}

	/**
	 * 快捷发起标识取得
	 * @return isServiceStart 快捷发起标识
	 */
	public String getIsServiceStart() {
		return isServiceStart;
	}

	/**
	 * 快捷发起标识设定
	 * @param isServiceStart 快捷发起标识
	 */
	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}
}
