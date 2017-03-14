/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;


/**
  * 概述: PDF报表XML中表格式表单节点定义表检索条件实现
  * 功能描述: PDF报表XML中表格式表单节点定义表检索条件实现
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
public class PdfTableNodeSearchCondImpl implements
		PdfTableNodeSearchCond {
    
    /** 流程定义id*/ 
    String pdid;
    /** 绑定名称 */
	protected String databinding;
	/** 父绑定名称 */
	protected String pdatabinding;
	/**  报表节点类型：0固定，1可变*/
	protected String nodetype;
    /**
     * @return the pdid
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param pdid the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

	/**
	 * @return the 绑定名称
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * @param 绑定名称 the databinding to set
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

	/**
	 * @return the 父绑定名称
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * @param 父绑定名称 the pdatabinding to set
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
	}

	/**
	 * @return the 报表节点类型：0固定，1可变
	 */
	public String getNodetype() {
		return nodetype;
	}

	/**
	 * @param 报表节点类型：0固定，1可变 the nodetype to set
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
    
    
}