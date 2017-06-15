package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * ��Ա�����ϸͳ��ʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class PersonLoanDetailVWPK extends BasePK implements Serializable {

	/** ID */
	protected String id;

	/** �������� */
	protected String type;
	
	/**
	 * ���캯��
	 */
	public PersonLoanDetailVWPK(){}
	
	/**
	 * ���캯��
	 */
	public PersonLoanDetailVWPK(String id, String type) {
		this.id = id;
		this.type = type;
	}
}
