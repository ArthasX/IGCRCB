/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.sms.model.SendSmsLogInfo;
import com.deliverik.plugin.sms.model.condition.SendSmsLogSearchCond;

/**
  * ����: ���Ŷ��б�ҵ���߼��ӿ�
  * ��������: ���Ŷ��б�ҵ���߼��ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface SendSmsLogBL extends BaseBL {

	/**
	 * ���Ŷ��б�ʵ��ȡ��
	 *
	 * @return ���Ŷ��б�ʵ��
	 */
	public SendSmsLogInfo getSendSmsLogTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SendSmsLogInfo searchSendSmsLogInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SendSmsLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo(SendSmsLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo(SendSmsLogSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SendSmsLogInfo registSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SendSmsLogInfo updateSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSendSmsLogInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException;

}