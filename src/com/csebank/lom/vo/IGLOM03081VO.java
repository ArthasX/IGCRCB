/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.PersonLoanSummary;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * Ԥ֧��Աͳ��VO
 *
 */
public class IGLOM03081VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** Ԥ֧��Աͳ�Ʋ�ѯ����б� */
	protected List<PersonLoanSummary> personLoanSummaryList;

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯ����б�ȡ��
	 * @return Ԥ֧��Աͳ�Ʋ�ѯ����б�
	 */
	public List<PersonLoanSummary> getPersonLoanSummaryList() {
		return personLoanSummaryList;
	}

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯ����б��趨
	 * @param personLoanSummaryList Ԥ֧��Աͳ�Ʋ�ѯ����б�
	 */
	public void setPersonLoanSummaryList(
			List<PersonLoanSummary> personLoanSummaryList) {
		this.personLoanSummaryList = personLoanSummaryList;
	}

}
