/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.QueueInfo;
import com.deliverik.infogovernor.sym.model.condition.QueueSearchCond;
import com.deliverik.infogovernor.sym.model.dao.QueueDAO;
import com.deliverik.infogovernor.sym.model.entity.QueueTB;

/**
  * ����: ���Ŷ��б�ҵ���߼�ʵ��
  * ��������: ���Ŷ��б�ҵ���߼�ʵ��
  * ������¼: 2012/11/13
  * �޸ļ�¼: 
  */
public class QueueBLImpl extends BaseBLImpl implements
		QueueBL {

	/** ���Ŷ��б�DAO�ӿ� */
	protected QueueDAO queueDAO;
	
	/**
	 * ���Ŷ��б�DAO�ӿ��趨
	 *
	 * @param queueDAO ���Ŷ��б�DAO�ӿ�
	 */
	public void setQueueDAO(QueueDAO queueDAO) {
		this.queueDAO = queueDAO;
	}

	/**
	 * ���Ŷ��б�ʵ��ȡ��
	 *
	 * @return ���Ŷ��б�ʵ��
	 */
	public QueueTB getQueueTBInstance() {
		return new QueueTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<QueueInfo> searchQueueInfo() {
		return queueDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public QueueInfo searchQueueInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(QueueSearchCond cond) {
		return queueDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<QueueInfo> searchQueueInfo(
			QueueSearchCond cond) {
		return queueDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return queueDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public QueueInfo registQueueInfo(QueueInfo instance)
		throws BLException {
		return queueDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public QueueInfo updateQueueInfo(QueueInfo instance)
		throws BLException {
		checkExistInstance(instance.getQid());
		return queueDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteQueueInfoByPK(Integer pk)
		throws BLException {
		queueDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteQueueInfo(QueueInfo instance)
		throws BLException {
		queueDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public QueueInfo checkExistInstance(Integer pk)
		throws BLException {
		QueueInfo instance = queueDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}