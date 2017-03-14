/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.sms.model.SmsQueueInfo;
import com.deliverik.plugin.sms.model.condition.SmsQueueSearchCond;
import com.deliverik.plugin.sms.model.entity.SmsQueueTB;

/**
  * ����: ���Ŷ��б�ҵ���߼��ӿ�
  * ��������: ���Ŷ��б�ҵ���߼��ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface SmsQueueBL extends BaseBL {

	/**
	 * ���Ŷ��б�ʵ��ȡ��
	 *
	 * @return ���Ŷ��б�ʵ��
	 */
	public SmsQueueTB getSmsQueueTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SmsQueueInfo searchSmsQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SmsQueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo(
			SmsQueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo(
			SmsQueueSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SmsQueueInfo registSmsQueueInfo(SmsQueueInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SmsQueueInfo updateSmsQueueInfo(SmsQueueInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSmsQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSmsQueueInfo(SmsQueueInfo instance)
		throws BLException;

}