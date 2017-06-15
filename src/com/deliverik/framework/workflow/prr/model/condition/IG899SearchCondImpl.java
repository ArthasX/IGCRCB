/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程私有变量表检索条件实现
  * 功能描述: 流程私有变量表检索条件实现
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
public class IG899SearchCondImpl implements IG899SearchCond {
	
	/** 流程变量定义ID */
	protected String pidid;
	
	/** 流程变量值ID */
	protected Integer piid;

	/** 流程参与者的角色ID */
	protected Integer roleid;
	
	/** 流程参与者ID */
	protected String userid;
	
	/** 机构码 */
	protected String orgid;
	
	/**
	 * 流程变量定义ID取得
	 *
	 * @return 流程变量定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程变量定义ID设定
	 *
	 * @param Pidid 流程变量定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	/**
	 * 流程变量值ID取得
	 *
	 * @return 流程变量值ID
	 */
	public Integer getPiid() {
		return piid;
	}
	
	/**
	 * 流程变量值ID设定
	 *
	 * @param Piid 流程变量值ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * 流程参与者的角色ID取得
	 *
	 * @return 流程参与者的角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 流程参与者的角色ID设定
	 *
	 * @param roleid 流程参与者的角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * 流程参与者ID取得
	 * 
	 * @return 流程参与者ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 流程参与者ID设定
	 * 
	 * @param userid 流程参与者ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 机构码取得
	 * @return 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构码设定
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

}