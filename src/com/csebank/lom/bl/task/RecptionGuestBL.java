/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �Ӵ�����ҵ���߼��ӿ�
 */
public interface RecptionGuestBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RecptionGuestSearchCond cond);
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RecptionGuestInfoCond cond);

	/**
	 * ������������
	 * 
	 * @param rgid �Ӵ�ID
	 * @return �Ӵ�ID
	 */
	public RecptionGuest searchRecptionGuestByKey(Integer rgid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��Ӵ���Ϣ
	 */
	public List<RecptionGuest> searchRecptionGuestAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionGuest> searchRecptionGuest(RecptionGuestSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param RecptionGuest ��¼����
	 * @return ֵ��Ӵ���Ϣ
	 */
	public RecptionGuest registRecptionGuest(RecptionGuest recptionguest) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rgid �Ӵ�ID
	 * @throws BLException
	 */
	public void deleteRecptionGuest(Integer rgid) throws BLException;

	/**
	 * �������
	 * 
	 * @param recptionguest �������
	 * @return ֵ��Ӵ���Ϣ
	 */
	public RecptionGuest updateRecptionGuest(RecptionGuest recptionguest) throws BLException;
   
	
	/**
	 * �Ӵ����˲�ѯ����
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionGuestInfo> searchRecptionGuestInfo(RecptionGuestInfoCond cond, int start, int count);
}
