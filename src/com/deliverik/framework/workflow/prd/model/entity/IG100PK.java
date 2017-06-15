/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;


/**
 * 流程参与者变量权限主键类
 *
 */
@SuppressWarnings("serial")
public class IG100PK extends BasePK implements Serializable {
	
	/** 流程参与者变量权限ID */
	protected String pipdid;
	
	/** 类型（0：已设定权限表单，1：未设定权限表单） */
	protected String type;
	
	/**
	 * 构造函数
	 */
	public IG100PK(){}
	
	/**
	 * 构造函数
	 */
	public IG100PK(String pipdid, String type) {
		this.pipdid = pipdid;
		this.type = type;
	}
}
