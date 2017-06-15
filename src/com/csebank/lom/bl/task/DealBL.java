/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.condition.DealSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �Ӵ�����ҵ���߼��ӿ�
 */
public interface DealBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DealSearchCond cond);
	
	

	/**
	 * ������������
	 * 
	 * @param rid �Ӵ�ID
	 * @return �Ӵ�ID
	 */
	public Deal searchDealByKey(Integer rid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��Ӵ���Ϣ
	 */
	public List<Deal> searchDealAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Deal> searchDeal(DealSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Recption ��¼����
	 * @return ֵ��Ӵ���Ϣ
	 */
	public Deal insertDealInfo(Deal deal) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rid �Ӵ�ID
	 * @throws BLException
	 */
	public void deleteDeal(Integer rid) throws BLException;

	/**
	 * �������
	 * 
	 * @param recption �������
	 * @return ֵ��Ӵ���Ϣ
	 */
	public Deal updateDeal(Deal recption) throws BLException;

	/**
 	 * ���ݿͻ��������ͻ���λ��ѯ�Ӵ�������Ϣ
 	 *
 	 * @param cond ��������
 	 * @param start ������¼��ʼ�к�
 	 * @param count ������¼����
 	 * @return �Ӵ�������Ϣ
 	 * @throws BLException
 	 */

}
