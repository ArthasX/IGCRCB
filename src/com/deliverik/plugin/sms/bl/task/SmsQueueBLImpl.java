/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.sms.model.SmsQueueInfo;
import com.deliverik.plugin.sms.model.condition.SmsQueueSearchCond;
import com.deliverik.plugin.sms.model.dao.SmsQueueDAO;
import com.deliverik.plugin.sms.model.entity.SmsQueueTB;

/**
  * ����: ���Ŷ��б�ҵ���߼�ʵ��
  * ��������: ���Ŷ��б�ҵ���߼�ʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public class SmsQueueBLImpl extends BaseBLImpl implements SmsQueueBL {

	/** ���Ŷ��б�DAO�ӿ� */
	protected SmsQueueDAO smsQueueDAO;
	

	/**
	 * ���Ŷ��б�ʵ��ȡ��
	 *
	 * @return ���Ŷ��б�ʵ��
	 */
	public SmsQueueTB getSmsQueueTBInstance() {
		return new SmsQueueTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo() {
		return smsQueueDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SmsQueueInfo searchSmsQueueInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SmsQueueSearchCond cond) {
		return smsQueueDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo(
			SmsQueueSearchCond cond) {
		return smsQueueDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return smsQueueDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SmsQueueInfo registSmsQueueInfo(SmsQueueInfo instance)
		throws BLException {
		return smsQueueDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SmsQueueInfo updateSmsQueueInfo(SmsQueueInfo instance)
		throws BLException {
		checkExistInstance(instance.getQid());
		return smsQueueDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSmsQueueInfoByPK(Integer pk)
		throws BLException {
		smsQueueDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSmsQueueInfo(SmsQueueInfo instance)
		throws BLException {
		smsQueueDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SmsQueueInfo checkExistInstance(Integer pk)
		throws BLException {
		SmsQueueInfo instance = smsQueueDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public SmsQueueDAO getSmsQueueDAO() {
		return smsQueueDAO;
	}

	public void setSmsQueueDAO(SmsQueueDAO smsQueueDAO) {
		this.smsQueueDAO = smsQueueDAO;
	}

}