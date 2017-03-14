/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCond;
import com.deliverik.framework.asset.model.dao.AuditWaitTaskDAO;
import com.deliverik.framework.asset.model.entity.AuditWaitTaskTB;

/**
  * ����: ��ƴ���������ҵ���߼�ʵ��
  * ��������: ��ƴ���������ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditWaitTaskBLImpl extends BaseBLImpl implements
		AuditWaitTaskBL {

	/** ��ƴ���������DAO�ӿ� */
	protected AuditWaitTaskDAO auditWaitTaskDAO;
	
	/**
	 * ��ƴ���������DAO�ӿ��趨
	 *
	 * @param auditWaitTaskDAO ��ƴ���������DAO�ӿ�
	 */
	public void setAuditWaitTaskDAO(AuditWaitTaskDAO auditWaitTaskDAO) {
		this.auditWaitTaskDAO = auditWaitTaskDAO;
	}

	/**
	 * ��ƴ���������ʵ��ȡ��
	 *
	 * @return ��ƴ���������ʵ��
	 */
	public AuditWaitTaskTB getAuditWaitTaskTBInstance() {
		return new AuditWaitTaskTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask() {
		return auditWaitTaskDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditWaitTaskInfo searchAuditWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditWaitTaskSearchCond cond) {
		return auditWaitTaskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask(
			AuditWaitTaskSearchCond cond) {
		return auditWaitTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask(
			AuditWaitTaskSearchCond cond, int start,
			int count) {
		return auditWaitTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditWaitTaskInfo registAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException {
		return auditWaitTaskDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditWaitTaskInfo updateAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getAuwtid());
		return auditWaitTaskDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditWaitTaskByPK(Integer pk)
		throws BLException {
		auditWaitTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException {
		auditWaitTaskDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AuditWaitTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditWaitTaskInfo instance = auditWaitTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}