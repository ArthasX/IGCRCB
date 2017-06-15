package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * Ԥ֧����ʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class AdvanceSummaryTBPK extends BasePK implements Serializable {

	/** ���ȡ�� */
	protected String asyear;

	/** �·�ȡ�� */
	protected String asmonth;
	
	/**
	 * ���캯��
	 */
	public AdvanceSummaryTBPK(){}
	
	/**
	 * ���캯��
	 */
	public AdvanceSummaryTBPK(String asyear, String asmonth) {
		this.asyear = asyear;
		this.asmonth = asmonth;
	}
}
