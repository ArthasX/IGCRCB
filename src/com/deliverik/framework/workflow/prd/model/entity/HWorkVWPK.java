/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

@SuppressWarnings("serial")
public class HWorkVWPK extends BasePK implements Serializable {
	protected String prtype ;
	protected Integer hcount;
	protected String propentime;
	/**
	 * 构造函数
	 */
	public HWorkVWPK(){}
	
	/**
	 * 构造函数
	 */
	public HWorkVWPK(String propentime, String prtype ,Integer hcount) {
		this.propentime=propentime;
		this.prtype=prtype;
		this.hcount=hcount;
	}
}
