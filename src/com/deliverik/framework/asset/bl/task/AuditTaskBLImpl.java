/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.asset.model.dao.AuditTaskDAO;
import com.deliverik.framework.asset.model.entity.AuditTaskTB;

/**
  * ����: ��������ҵ���߼�ʵ��
  * ��������: ��������ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditTaskBLImpl extends BaseBLImpl implements
		AuditTaskBL {

	/** ��������DAO�ӿ� */
	protected AuditTaskDAO auditTaskDAO;
	
	/**
	 * ��������DAO�ӿ��趨
	 *
	 * @param auditTaskDAO ��������DAO�ӿ�
	 */
	public void setAuditTaskDAO(AuditTaskDAO auditTaskDAO) {
		this.auditTaskDAO = auditTaskDAO;
	}

	/**
	 * ��������ʵ��ȡ��
	 *
	 * @return ��������ʵ��
	 */
	public AuditTaskTB getAuditTaskTBInstance() {
		return new AuditTaskTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditTaskInfo> searchAuditTask() {
		return auditTaskDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditTaskInfo searchAuditTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditTaskSearchCond cond) {
		return auditTaskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond) {
		return auditTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond, int start,
			int count) {
		return auditTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditTaskInfo registAuditTask(AuditTaskInfo instance)
		throws BLException {
		return auditTaskDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditTaskInfo updateAuditTask(AuditTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getAutid());
		return auditTaskDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditTaskByPK(Integer pk)
		throws BLException {
		auditTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditTask(AuditTaskInfo instance)
		throws BLException {
		auditTaskDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AuditTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditTaskInfo instance = auditTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}