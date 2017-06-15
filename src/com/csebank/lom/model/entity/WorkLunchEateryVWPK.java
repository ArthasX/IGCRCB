package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * �Ϳ�ʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class WorkLunchEateryVWPK extends BasePK implements Serializable {

	/**���� */
	protected String wldate;

	/** �Ϳ����� */
	protected String lunchcardname;
	
	/**
	 * ���캯��
	 */
	public WorkLunchEateryVWPK(){}
	
	/**
	 * ���캯��
	 */
	public WorkLunchEateryVWPK(String wldate, String lunchcardname) {
		this.wldate = wldate;
		this.lunchcardname = lunchcardname;
	}
}
