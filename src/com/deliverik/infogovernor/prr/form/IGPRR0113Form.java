/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 流程处理Form
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0113Form extends BaseForm {

	/** 流程ID */
	protected Integer prid;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 角色ID */
	protected Integer roleid;
	
	/**节点模式*/
	protected String psdmode;
	
	/** 流程状态ID */
	protected String psdid;
	
	/** 参与者ID（格式：roleid_userid）*/
	protected String[] participants;
	
	/** 流程状态 */
	protected String prstatus;
	
	/** 主办部门角色ID */
	protected Integer ppsuperid;
	
	/** 主办部门机构码 */
	protected String ppsuperorgid;
	
	/** 分派参与者类型（0人员，1角色 ） */
	protected String psdassign;
	
	/** 节点类型 */
	protected String psdtype;
	
	/** 页面类型（0角色，1用户） */
	protected String flag;
	
	/** 改派页面初始化选择人员标识 */
	protected String selected_participants;
	
	/**页面跳转标识*/
	protected String jump;
	
	/** 分支状态编号 */
	protected String psdnum;
	
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
	 *
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
	 * 节点模式取得
	 * @return 节点模式
	 */
	public String getPsdmode() {
		return psdmode;
	}

	/**
	 * 节点模式设定
	 * @param psdmode节点模式
	 */
	public void setPsdmode(String psdmode) {
		this.psdmode = psdmode;
	}

	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * @param roleid角色ID
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
	
	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}


	/**
	 * 流程状态ID设定
	 *
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * 流程状态取得
	 * 
	 * @return 流程状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 * 
	 * @param prstatus 流程状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	
	/**
	 * 主办部门角色ID取得
	 * 
	 * @return 主办部门角色ID
	 */
	public Integer getPpsuperid() {
		return ppsuperid;
	}

	/**
	 * 主办部门角色ID设定
	 * 
	 * @param ppsuperid 主办部门角色ID
	 */
	public void setPpsuperid(Integer ppsuperid) {
		this.ppsuperid = ppsuperid;
	}
	
	/**
	 * 分派参与者类型取得
	 * 
	 * @return 分派参与者类型
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * 分派参与者类型设定
	 * 
	 * @param psdassign 分派参与者类型
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	
	/**
	 * 节点类型取得
	 * 
	 * @return 节点类型
	 */
	public String getPsdtype() {
		return psdtype;
	}

	/**
	 * 节点类型设定
	 * 
	 * @param psdtype 节点类型
	 */
	public void setPsdtype(String psdtype) {
		this.psdtype = psdtype;
	}
	
	/**
	 * 页面类型取得
	 * 
	 * @return 页面类型
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 页面类型设定
	 * 
	 * @param flag 页面类型
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.participants = null;
	}
	
	/**
	 * 改派页面初始化选择人员标识取得
	 * 
	 * @return 改派页面初始化选择人员标识
	 */
	public String getSelected_participants() {
		return selected_participants;
	}

	/**
	 * 改派页面初始化选择人员标识设定
	 * 
	 * @param selected_participants 改派页面初始化选择人员标识
	 */
	public void setSelected_participants(String selected_participants) {
		this.selected_participants = selected_participants;
	}

	/**
	 * 主办部门机构码取得
	 * @return 主办部门机构码
	 */
	public String getPpsuperorgid() {
		return ppsuperorgid;
	}

	/**
	 * 主办部门机构码设定
	 * @param ppsuperorgid 主办部门机构码
	 */
	public void setPpsuperorgid(String ppsuperorgid) {
		this.ppsuperorgid = ppsuperorgid;
	}
	
	/**
	 * 页面跳转标识取得
	 * @return 页面跳转标识
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * 页面跳转标识设定
	 * @param jump 页面跳转标识
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * 分支状态编号取得
	 * @return 分支状态编号
	 */
	public String getPsdnum() {
		return psdnum;
	}

	/**
	 * 分支状态编号设定
	 * @param psdnum 分支状态编号
	 */
	public void setPsdnum(String psdnum) {
		this.psdnum = psdnum;
	}
	
}
