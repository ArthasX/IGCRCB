/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
	 * ���캯��
	 */
	public HWorkVWPK(){}
	
	/**
	 * ���캯��
	 */
	public HWorkVWPK(String propentime, String prtype ,Integer hcount) {
		this.propentime=propentime;
		this.prtype=prtype;
		this.hcount=hcount;
	}
}
