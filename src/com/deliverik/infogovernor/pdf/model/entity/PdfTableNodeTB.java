/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;

/**
  * 概述: PDF报表XML中表格式表单节点定义表实体
  * 功能描述: PDF报表XML中表格式表单节点定义表实体
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfTableNodePK.class)
@Table(name="PdfTableNode")
public class PdfTableNodeTB extends BaseEntity implements Serializable,
		Cloneable, PdfTableNodeInfo {

	/** 流程定义ID */
	@Id
	protected String pdid;

	/** 绑定名称 */
	@Id
	protected String databinding;

	/** 父绑定名称 */
	protected String pdatabinding;
	
	/**  报表节点类型：0固定，1可变*/
	protected String nodetype;

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
	 * 绑定名称取得
	 *
	 * @return 绑定名称
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * 绑定名称设定
	 *
	 * @param databinding 绑定名称
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

	/**
	 * 父绑定名称取得
	 *
	 * @return 父绑定名称
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * 父绑定名称设定
	 *
	 * @param pdatabinding 父绑定名称
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new PdfTableNodePK(pdid, databinding);
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