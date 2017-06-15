/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * 概述: 表单策略表检索条件实现
  * 功能描述: 表单策略表检索条件实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public class IG335SearchCondImpl implements
		IG335SearchCond {
	/** 状态定义ID */
	protected String psdid_eq;
	
	/** 状态定义IDLike */
	protected String psdid_like;

	/** 表单定义ID */
	protected String pidid_eq;
	
	/** 表单定义ID */
	protected String pidid_like;

	/** 表单值 */
	protected String pivalue_eq;

	/**流程定义ID(完全匹配)*/
	protected String pdid_eq;

	/**流程定义ID(模糊匹配)*/
	protected String pdid_like;

	/**
	 * 状态定义ID取得
	 * @return psdid_eq 状态定义ID
	 */
	public String getPsdid_eq() {
		return psdid_eq;
	}

	/**
	 * 状态定义ID设定
	 * @param psdid_eq 状态定义ID
	 */
	public void setPsdid_eq(String psdid_eq) {
		this.psdid_eq = psdid_eq;
	}

	/**
	 * 状态定义IDLike取得
	 * @return psdid_like 状态定义IDLike
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * 状态定义IDLike设定
	 * @param psdid_like 状态定义IDLike
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	/**
	 * 表单定义ID取得
	 * @return pidid_eq 表单定义ID
	 */
	public String getPidid_eq() {
		return pidid_eq;
	}

	/**
	 * 表单定义ID设定
	 * @param pidid_eq 表单定义ID
	 */
	public void setPidid_eq(String pidid_eq) {
		this.pidid_eq = pidid_eq;
	}

	/** 
     * 表单定义ID 取得
     * @return pidid_like 表单定义ID 
     */
    public String getPidid_like() {
        return pidid_like;
    }

    /** 
     * 表单定义ID 设定
     * @param pidid_like 表单定义ID 
     */
    public void setPidid_like(String pidid_like) {
        this.pidid_like = pidid_like;
    }

    /**
	 * 表单值取得
	 * @return pivalue_eq 表单值
	 */
	public String getPivalue_eq() {
		return pivalue_eq;
	}

	/**
	 * 表单值设定
	 * @param pivalue_eq 表单值
	 */
	public void setPivalue_eq(String pivalue_eq) {
		this.pivalue_eq = pivalue_eq;
	}

	/**
	 * 流程定义ID(完全匹配)取得
	 * @return pdid_eq 流程定义ID(完全匹配)
	 */
	public String getPdid_eq() {
		return pdid_eq;
	}
	/**
	 * 流程定义ID(完全匹配)设定
	 * @param pdid_eq
	 */
	public void setPdid_eq(String pdid_eq) {
		this.pdid_eq = pdid_eq;
	}
	
	/**
	 * 流程定义ID(模糊匹配)取得
	 * @return pdid_like 流程定义ID(模糊匹配)
	 */
	public String getPdid_like() {
		return pdid_like;
	}
	/**
	 * 流程定义ID(模糊匹配)设定
	 * @param pdid_like
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

}