/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.sms.model.SendSmsLogInfo;
import com.deliverik.plugin.sms.model.condition.SendSmsLogSearchCond;
import com.deliverik.plugin.sms.model.dao.SendSmsLogDAO;
import com.deliverik.plugin.sms.model.entity.SendSmsLogTB;

/**
  * ����: ���Ŷ��б�ҵ���߼�ʵ��
  * ��������: ���Ŷ��б�ҵ���߼�ʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public class SendSmsLogImpl extends BaseBLImpl implements SendSmsLogBL {

	/** ���Ŷ��б�DAO�ӿ� */
	protected SendSmsLogDAO sendSmsLogDAO;
	


	/**
	 * ���Ŷ��б�ʵ��ȡ��
	 *
	 * @return ���Ŷ��б�ʵ��
	 */
	public SendSmsLogTB getSendSmsLogTBInstance() {
		return new SendSmsLogTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo() {
		return sendSmsLogDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SendSmsLogInfo searchSendSmsLogInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SendSmsLogSearchCond cond) {
		return sendSmsLogDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo(
			SendSmsLogSearchCond cond) {
		return sendSmsLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo(
			SendSmsLogSearchCond cond, int start,
			int count) {
		return sendSmsLogDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SendSmsLogInfo registSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException {
		return sendSmsLogDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SendSmsLogInfo updateSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return sendSmsLogDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSendSmsLogInfoByPK(Integer pk)
		throws BLException {
		sendSmsLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException {
		sendSmsLogDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SendSmsLogInfo checkExistInstance(Integer pk)
		throws BLException {
		SendSmsLogInfo instance = sendSmsLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public SendSmsLogDAO getSendSmsLogDAO() {
		return sendSmsLogDAO;
	}

	public void setSendSmsLogDAO(SendSmsLogDAO sendSmsLogDAO) {
		this.sendSmsLogDAO = sendSmsLogDAO;
	}

}