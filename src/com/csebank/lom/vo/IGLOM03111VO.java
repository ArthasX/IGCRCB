/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.PersonLoanDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ��Ա�����ϸͳ��VO
 *
 */
public class IGLOM03111VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** ��Ա�����ϸͳ�Ʋ�ѯ����б� */
	protected List<PersonLoanDetail> personLoanDetailList;

	/**
	 * ��Ա�����ϸͳ�Ʋ�ѯ����б�ȡ��
	 * @return ��Ա�����ϸͳ�Ʋ�ѯ����б�
	 */
	public List<PersonLoanDetail> getPersonLoanDetailList() {
		return personLoanDetailList;
	}

	/**
	 * ��Ա�����ϸͳ�Ʋ�ѯ����б��趨
	 * @param personLoanDetailList ��Ա�����ϸͳ�Ʋ�ѯ����б�
	 */
	public void setPersonLoanDetailList(
			List<PersonLoanDetail> personLoanDetailList) {
		this.personLoanDetailList = personLoanDetailList;
	}

}
