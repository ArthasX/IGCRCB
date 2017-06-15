package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * Ԥ֧��ϸͳ��ʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class AdvanceDetailVWPK extends BasePK implements Serializable {

	/** ID */
	protected String id;

	/** �������� */
	protected String type;
	
	/**
	 * ���캯��
	 */
	public AdvanceDetailVWPK(){}
	
	/**
	 * ���캯��
	 */
	public AdvanceDetailVWPK(String id, String type) {
		this.id = id;
		this.type = type;
	}
}
