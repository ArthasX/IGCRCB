/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.QueueInfo;
import com.deliverik.infogovernor.sym.model.condition.QueueSearchCond;
import com.deliverik.infogovernor.sym.model.entity.QueueTB;

/**
  * ����: ���Ŷ��б�ҵ���߼��ӿ�
  * ��������: ���Ŷ��б�ҵ���߼��ӿ�
  * ������¼: 2012/11/13
  * �޸ļ�¼: 
  */
public interface QueueBL extends BaseBL {

	/**
	 * ���Ŷ��б�ʵ��ȡ��
	 *
	 * @return ���Ŷ��б�ʵ��
	 */
	public QueueTB getQueueTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<QueueInfo> searchQueueInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public QueueInfo searchQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(QueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<QueueInfo> searchQueueInfo(
			QueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<QueueInfo> searchQueueInfo(
			QueueSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public QueueInfo registQueueInfo(QueueInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public QueueInfo updateQueueInfo(QueueInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteQueueInfo(QueueInfo instance)
		throws BLException;

}