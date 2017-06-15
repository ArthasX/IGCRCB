/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.change.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCond;
import com.deliverik.plugin.change.model.dao.InitiateChangLogDAO;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
  * ����: ������������־ҵ���߼�ʵ��
  * ��������: ������������־ҵ���߼�ʵ��
  * ������¼: 2015/07/02
  * �޸ļ�¼: 
  */
public class InitiateChangLogBLImpl extends BaseBLImpl implements
		InitiateChangLogBL {

	/** ������������־DAO�ӿ� */
	protected InitiateChangLogDAO initiateChangLogDAO;
	
	/**
	 * ������������־DAO�ӿ��趨
	 *
	 * @param initiateChangLogDAO ������������־DAO�ӿ�
	 */
	public void setInitiateChangLogDAO(InitiateChangLogDAO initiateChangLogDAO) {
		this.initiateChangLogDAO = initiateChangLogDAO;
	}

	/**
	 * ������������־ʵ��ȡ��
	 *
	 * @return ������������־ʵ��
	 */
	public InitiateChangLogTB getInitiateChangLogTBInstance() {
		return new InitiateChangLogTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog() {
		return initiateChangLogDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InitiateChangLogInfo searchInitiateChangLogByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InitiateChangLogSearchCond cond) {
		return initiateChangLogDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog(
			InitiateChangLogSearchCond cond) {
		return initiateChangLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog(
			InitiateChangLogSearchCond cond, int start,
			int count) {
		return initiateChangLogDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InitiateChangLogInfo registInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException {
		return initiateChangLogDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InitiateChangLogInfo updateInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getIcid());
		return initiateChangLogDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInitiateChangLogByPK(Integer pk)
		throws BLException {
		initiateChangLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException {
		initiateChangLogDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public InitiateChangLogInfo checkExistInstance(Integer pk)
		throws BLException {
		InitiateChangLogInfo instance = initiateChangLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}