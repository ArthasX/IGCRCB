/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �Ӵ�����ҵ���߼��ӿ�
 */
public interface RecptionBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RecptionSearchCond cond);
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchGuestInfoCount(RecptionGuestInfoCond cond);
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getRecptionCostCount(RecptionSearchCond cond);
	
	/**
	 * ������������
	 * 
	 * @param rid �Ӵ�ID
	 * @return �Ӵ�ID
	 */
	public Recption searchRecptionByKey(Integer rid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��Ӵ���Ϣ
	 */
	public List<Recption> searchRecptionAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Recption> searchRecption(RecptionSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Recption ��¼����
	 * @return ֵ��Ӵ���Ϣ
	 */
	public Recption registRecption(Recption recption) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rid �Ӵ�ID
	 * @throws BLException
	 */
	public void deleteRecption(Integer rid) throws BLException;

	/**
	 * �������
	 * 
	 * @param recption �������
	 * @return ֵ��Ӵ���Ϣ
	 */
	public Recption updateRecption(Recption recption) throws BLException;

	/**
 	 * ���ݿͻ��������ͻ���λ��ѯ�Ӵ�������Ϣ
 	 *
 	 * @param cond ��������
 	 * @param start ������¼��ʼ�к�
 	 * @param count ������¼����
 	 * @return �Ӵ�������Ϣ
 	 * @throws BLException
 	 */
	public List<GuestRecption> searchRecptionByGuset(RecptionGuestInfoCond cond, int start, int count);
	
	/**
 	 * ���ݿͻ��������ͻ���λ��ѯ�������ȡ��
 	 *
 	 * @param cond ��������
 	 * @return �����������
 	 * @throws BLException
 	 */
	public int getRecptionSearchCount(RecptionGuestInfoCond cond);
	
	/**
	 * ���ݽӴ���ʼ�������ڲ�ѯ�Ӵ�������Ϣ�ͷ�����Ϣ
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �Ӵ�������Ϣ�ͷ�����Ϣ�б�
	 */
	public List<RecptionCost> searchRecptionCost(RecptionSearchCond cond, int start, int count);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionAmount> searchRecptionAmount(RecptionSearchCond cond, int start, int count);
}
