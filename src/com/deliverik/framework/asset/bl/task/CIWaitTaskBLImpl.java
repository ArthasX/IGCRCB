/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.CIWaitTaskSearchCond;
import com.deliverik.framework.asset.model.dao.CIWaitTaskDAO;
import com.deliverik.framework.asset.model.entity.CIWaitTaskTB;

/**
  * ����: CI�������������ҵ���߼�ʵ��
  * ��������: CI�������������ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CIWaitTaskBLImpl extends BaseBLImpl implements
		CIWaitTaskBL {

	/** CI�������������DAO�ӿ� */
	protected CIWaitTaskDAO ciWaitTaskDAO;
	
	/**
	 * CI�������������DAO�ӿ��趨
	 *
	 * @param ciWaitTaskDAO CI�������������DAO�ӿ�
	 */
	public void setCiWaitTaskDAO(CIWaitTaskDAO ciWaitTaskDAO) {
		this.ciWaitTaskDAO = ciWaitTaskDAO;
	}

	/**
	 * CI�������������ʵ��ȡ��
	 *
	 * @return CI�������������ʵ��
	 */
	public CIWaitTaskTB getCIWaitTaskTBInstance() {
		return new CIWaitTaskTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask() {
		return ciWaitTaskDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIWaitTaskInfo searchCIWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIWaitTaskSearchCond cond) {
		return ciWaitTaskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask(
			CIWaitTaskSearchCond cond) {
		return ciWaitTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask(
			CIWaitTaskSearchCond cond, int start,
			int count) {
		return ciWaitTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIWaitTaskInfo registCIWaitTask(CIWaitTaskInfo instance)
		throws BLException {
		return ciWaitTaskDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIWaitTaskInfo updateCIWaitTask(CIWaitTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getCiwtid());
		return ciWaitTaskDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIWaitTaskByPK(Integer pk)
		throws BLException {
		ciWaitTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIWaitTask(CIWaitTaskInfo instance)
		throws BLException {
		ciWaitTaskDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CIWaitTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		CIWaitTaskInfo instance = ciWaitTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}