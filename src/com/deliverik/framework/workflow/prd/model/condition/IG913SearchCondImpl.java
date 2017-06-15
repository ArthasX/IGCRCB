package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程缺省变量权限视图检索条件实现
 * 
 */
public class IG913SearchCondImpl implements IG913SearchCond {
	
	/** 流程状态ID */
	protected String psdid;

	/** 流程类型ID */
	protected String pdid;
	
	/** 角色ID */
	protected Integer roleid;

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
	 * 流程类型ID取得
	 * 
	 * @return 流程类型ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型ID设定
	 * 
	 * @param pdid 流程类型ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

    /**
     * @return the 角色ID
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param 角色ID the roleid to set
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
	
}
