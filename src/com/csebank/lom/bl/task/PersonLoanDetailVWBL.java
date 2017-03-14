/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ��Ա�����ϸ��ѯ�ӿ�
 */
public interface PersonLoanDetailVWBL extends BaseBL {

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
	public List<PersonLoanDetail> searchPersonLoanDetailVW(PersonLoanDetailSearchCond cond,int start, int count);
	
	/**
	 * <p>
	 * Description: ��Ա�����ϸ��ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @return �б��¼����
	 */
	public int getSearchCount(PersonLoanDetailSearchCond cond);
	
}
