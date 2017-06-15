/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * 概述: Priority实体主键
 * 功能描述：优先级priorityTB实体主键
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class PriorityTBPK extends BasePK implements Serializable{

	/***
	 * 对应流程类型
	 */
	protected String pprtype;
	/***
	 * 紧急程度KEY
	 */
	protected String uvalue;
	/***
	 * 影响度KEY	
	 */
	protected String ivalue;
	
	
	/**
	 * 实体主键构造函数
	 * 
	 */
	public PriorityTBPK() {
	}

	/**
	 * 实体主键构造函数
	 * 
	 * @param pprtype流程类型
	 * @param uvalue紧急度
	 * @param ivalue影响度
	 */
	public PriorityTBPK(String pprtype, String uvalue, String ivalue) {
		super();
		this.pprtype = pprtype;
		this.uvalue = uvalue;
		this.ivalue = ivalue;
	}

	public String getPprtype() {
		return pprtype;
	}

	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}

	public String getUvalue() {
		return uvalue;
	}

	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}

	public String getIvalue() {
		return ivalue;
	}

	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}

}
