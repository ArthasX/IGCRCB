/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * Ԥ֧��ϸͳ��Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0317Form extends BaseForm implements AdvanceDetailSearchCond {
	
	/**
	 * ��ѯʱ�俪ʼ
	 */
	protected String date_from;
	
	/**
	 * ��ѯʱ�����
	 */
	protected String date_to;

	/**
	 * ��ѯʱ�俪ʼ�趨
	 * @return ��ѯʱ�俪ʼ
	 */
	public String getDate_from() {
		return date_from;
	}

	/**
	 * ��ѯʱ�俪ʼ�趨
	 * @param date_from ��ѯʱ�俪ʼ
	 */
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	/**
	 * ��ѯʱ������趨
	 * @return ��ѯʱ�����
	 */
	public String getDate_to() {
		return date_to;
	}

	/**
	 * ��ѯʱ������趨
	 * @param date_to ��ѯʱ�����
	 */
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}
}
