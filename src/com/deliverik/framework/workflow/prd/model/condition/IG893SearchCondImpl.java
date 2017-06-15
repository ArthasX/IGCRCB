package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程参与者变量权限视图检索条件实现
 * 
 */
public class IG893SearchCondImpl implements IG893SearchCond {
	
	/** 流程状态ID */
	protected String psdid;

	/** 流程参与者角色ID */
	protected Integer roleid;
	
	/** 表单全局控制节点集合id */
    protected String formGlobalPsdids;

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}
	
	/**
	 * 流程状态ID设定
	 * @param psdid流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程参与者角色ID取得
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 流程参与者角色ID设定
	 * @param roleid流程参与者角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * 表单全局控制节点id集合取得
	 * @return 表单全局控制节点id
	 */
	public String getFormGlobalPsdids() {
		return formGlobalPsdids;
	}

	/**
	 * 表单全局控制节点id设定
	 * @param formGlobalPsdList 表单全局控制节点id
	 */
	public void setFormGlobalPsdids(String formGlobalPsdids) {
		this.formGlobalPsdids = formGlobalPsdids;
	}
	
}
