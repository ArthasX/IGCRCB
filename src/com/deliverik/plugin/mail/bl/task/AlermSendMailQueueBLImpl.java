/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;
import com.deliverik.plugin.mail.model.condition.AlermSendMailQueueSearchCond;
import com.deliverik.plugin.mail.model.dao.AlermSendMailQueueDAO;
import com.deliverik.plugin.mail.model.entity.AlermSendMailQueueTB;

/**
  * ����: �ʼ����б�ҵ���߼�ʵ��
  * ��������: �ʼ����б�ҵ���߼�ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public class AlermSendMailQueueBLImpl extends BaseBLImpl implements AlermSendMailQueueBL {

	/** �ʼ����б�DAO�ӿ� */
	protected AlermSendMailQueueDAO alermSendMailQueueDAO;
	

	/**
	 * ���Ŷ��б�ʵ��ȡ��
	 *
	 * @return ���Ŷ��б�ʵ��
	 */
	public AlermSendMailQueueTB getAlermSendMailQueueTBInstance() {
		return new AlermSendMailQueueTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo() {
		return alermSendMailQueueDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AlermSendMailQueueInfo searchAlermSendMailQueueInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AlermSendMailQueueSearchCond cond) {
		return alermSendMailQueueDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo(
			AlermSendMailQueueSearchCond cond) {
		return alermSendMailQueueDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return alermSendMailQueueDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AlermSendMailQueueInfo registAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException {
		return alermSendMailQueueDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AlermSendMailQueueInfo updateAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException {
		checkExistInstance(instance.getMid());
		return alermSendMailQueueDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAlermSendMailQueueInfoByPK(Integer pk)
		throws BLException {
		alermSendMailQueueDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException {
		alermSendMailQueueDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AlermSendMailQueueInfo checkExistInstance(Integer pk)
		throws BLException {
		AlermSendMailQueueInfo instance = alermSendMailQueueDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public AlermSendMailQueueDAO getAlermSendMailQueueDAO() {
		return alermSendMailQueueDAO;
	}

	public void setAlermSendMailQueueDAO(AlermSendMailQueueDAO alermSendMailQueueDAO) {
		this.alermSendMailQueueDAO = alermSendMailQueueDAO;
	}

}