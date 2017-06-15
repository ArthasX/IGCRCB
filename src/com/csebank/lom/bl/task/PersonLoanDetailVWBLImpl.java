/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.csebank.lom.model.dao.PersonLoanDetailVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ��Ա�����ϸ��ѯ�ӿ�ʵ��
 */
public class PersonLoanDetailVWBLImpl extends BaseBLImpl implements PersonLoanDetailVWBL {
	
	static Log log = LogFactory.getLog(PersonLoanDetailVWBLImpl.class);

	/**
	 * ��Ա�����ϸ��ѯDAO
	 */
	protected PersonLoanDetailVWDAO personLoanDetailVWDAO;

	/**
	 * ��Ա�����ϸ��ѯDAO�趨
	 * @param personLoanDetailVWDAO ��Ա�����ϸ��ѯDAO
	 */
	public void setPersonLoanDetailVWDAO(
			PersonLoanDetailVWDAO personLoanDetailVWDAO) {
		this.personLoanDetailVWDAO = personLoanDetailVWDAO;
	}

	/**
	 * <p>
	 * Description: ��Ա�����ϸ��ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<PersonLoanDetail>
	 */
	public List<PersonLoanDetail> searchPersonLoanDetailVW(PersonLoanDetailSearchCond cond,
			int start, int count) {
		List<PersonLoanDetail> ret = personLoanDetailVWDAO.findByCond(cond,start,count);
		return ret;
	}
	/**
	 * <p>
	 * Description: ��Ա�����ϸ��ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @return �б��¼����
	 */
	public int getSearchCount(PersonLoanDetailSearchCond cond) {
		return personLoanDetailVWDAO.getSearchCount(cond);
	}
}
