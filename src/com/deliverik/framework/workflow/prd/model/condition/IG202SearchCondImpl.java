/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>概述:流程共通变量查询条件实现</p>
 * <p>功能描述:</p>
 * <p>创建记录：</p>
 */
public class IG202SearchCondImpl implements IG202SearchCond{
	
	protected String pdid;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/** 流程变量显示名称 */
	protected String pidlabel;
	

	protected Integer pidid_notlike;

	public String getPidlabel() {
		return pidlabel;
	}

	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	public Integer getPidid_notlike() {
		return pidid_notlike;
	}

	public void setPidid_notlike(Integer pidid_notlike) {
		this.pidid_notlike = pidid_notlike;
	}
}
