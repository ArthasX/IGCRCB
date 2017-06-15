/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>概述:日志信息检索条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG036SearchCondImpl implements IG036SearchCond {

	/** 流程记录ID */
	protected Integer prid;
	
	/** 日志处理人ID */
	protected String rluserid;
	
	/** 日志处理人姓名 */
	protected String rlusername;
	
	/** 用户角色 */
	protected List<Integer> roleid;
	
	/** 按角色查询排序标识 */
	protected boolean roleorder;
	
	/** 排除掉的日志类型 */
	protected String notEqualrlType;
	
	/** 日志类型 */
	protected String rlType;

	/** 流程状态编码 */
	protected String psdcode;
	
	/** 排序标识 */
	protected String roleorder_type;
	
	/** 角色负责人标识 */
	protected String rolemanger;
	
	/** 流程状态ID */
	protected String psdid;
	
	/** 流程状态分支编号 */
	protected Integer psdnum;
	
	/**
	 * 功能：角色负责人标识取得
	 * @return 角色负责人标识
	 */
	public String getRolemanger() {
		return rolemanger;
	}

	/**
	 * 功能：角色负责人标识设定
	 * @param rolemanger 角色负责人标识
	 */
	public void setRolemanger(String rolemanger) {
		this.rolemanger = rolemanger;
	}
	
	/**
	 * 功能：排序标识取得
	 * @return 排序标识
	 */
	public String getRoleorder_type() {
		return roleorder_type;
	}

	/**
	 * 功能：排序标识设定
	 * @param roleorder_type 排序标识
	 */
	public void setRoleorder_type(String roleorder_type) {
		this.roleorder_type = roleorder_type;
	}

	/**
	 * 功能：流程状态编码取得
	 * @return 流程状态编码
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 功能：流程状态编码设定
	 * @param psdcode 流程状态编码
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 功能：获取排除掉的日志类型
	 * @return notEqualrlType
	 */
	public String getNotEqualrlType() {
		return notEqualrlType;
	}

	/**
	 * 功能：设置排除掉的日志类型
	 * @param notEqualrlType
	 */
	public void setNotEqualrlType(String notEqualrlType) {
		this.notEqualrlType = notEqualrlType;
	}

	/**
	 * 功能：获取日志类型
	 * @return rlType
	 */
	public String getRlType() {
		return rlType;
	}

	/**
	 * 功能：设置日志类型
	 * @param rlType
	 */
	public void setRlType(String rlType) {
		this.rlType = rlType;
	}

	/**
	 * 功能：获取按角色查询排序标识
	 * @return roleorder
	 */
	public boolean isRoleorder() {
		return roleorder;
	}

	/**
	 * 功能：设置按角色查询排序标识
	 * @param roleorder
	 */
	public void setRoleorder(boolean roleorder) {
		this.roleorder = roleorder;
	}

	/**
	 * 功能：获取用户角色
	 * @return roleid
	 */
	public List<Integer> getRoleid() {
		return roleid;
	}

	/**
	 * 功能：设置用户角色
	 * @param roleid
	 */
	public void setRoleid(List<Integer> roleid) {
		this.roleid = roleid;
	}

	/**
	 * 功能：流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 功能：流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 功能：日志处理人ID取得
	 * @return 日志处理人ID
	 */
	public String getRluserid() {
		return rluserid;
	}

	/**
	 * 功能：日志处理人ID设定
	 * @param rluserid 日志处理人ID
	 */
	public void setRluserid(String rluserid) {
		this.rluserid = rluserid;
	}
	
	/**
	 * 功能：日志处理人姓名取得
	 * @return 日志处理人姓名
	 */
	public String getRlusername() {
		return rlusername;
	}

	/**
	 * 功能：日志处理人姓名设定
	 * @param rlusername 日志处理人姓名
	 */
	public void setRlusername(String rlusername) {
		this.rlusername = rlusername;
	}

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程状态分支编号取得
	 * @return 流程状态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 流程状态分支编号
	 * @param psdnum 流程状态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}
	
}
