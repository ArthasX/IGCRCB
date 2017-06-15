/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.csebank.lom.model.dao.PersonLoanSummaryVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�ʵ��
 */
public class PersonLoanSummaryVWBLImpl extends BaseBLImpl implements PersonLoanSummaryVWBL {
	
	static Log log = LogFactory.getLog(PersonLoanSummaryVWBLImpl.class);

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯDAO
	 */
	protected PersonLoanSummaryVWDAO personLoanSummaryVWDAO;

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯDAO�趨
	 * @param personLoanSummaryVWDAO Ԥ֧��Աͳ�Ʋ�ѯDAO
	 */
	public void setPersonLoanSummaryVWDAO(
			PersonLoanSummaryVWDAO personLoanSummaryVWDAO) {
		this.personLoanSummaryVWDAO = personLoanSummaryVWDAO;
	}

	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<PersonLoanSummary>
	 */
	public List<PersonLoanSummary> searchPersonLoanSummaryVW(PersonLoanSummarySearchCond cond,
			int start, int count) {
		List<PersonLoanSummary> ret = personLoanSummaryVWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @return �б��¼����
	 */
	public int getSearchCount(PersonLoanSummarySearchCond cond) {
		return personLoanSummaryVWDAO.getSearchCount(cond);
	}

}
