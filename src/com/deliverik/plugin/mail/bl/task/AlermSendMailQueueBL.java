/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;
import com.deliverik.plugin.mail.model.condition.AlermSendMailQueueSearchCond;
import com.deliverik.plugin.mail.model.entity.AlermSendMailQueueTB;

/**
  * ����: �ʼ����б�ҵ���߼��ӿ�
  * ��������: �ʼ����б�ҵ���߼��ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface AlermSendMailQueueBL extends BaseBL {

	/**
	 * �ʼ����б�ʵ��ȡ��
	 *
	 * @return �ʼ����б�ʵ��
	 */
	public AlermSendMailQueueTB getAlermSendMailQueueTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AlermSendMailQueueInfo searchAlermSendMailQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AlermSendMailQueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo(
			AlermSendMailQueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo(
			AlermSendMailQueueSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AlermSendMailQueueInfo registAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AlermSendMailQueueInfo updateAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAlermSendMailQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException;

}