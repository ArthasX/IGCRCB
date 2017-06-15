/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.dao.WorkmanagerDAO;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerTB;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * ����: ��������ҵ���߼�ʵ��
  * ��������: ��������ҵ���߼�ʵ��
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
public class WorkmanagerBLImpl extends BaseBLImpl implements
		WorkmanagerBL {

	/** ��������DAO�ӿ� */
	protected WorkmanagerDAO workmanagerDAO;
	
	/**
	 * ��������DAO�ӿ��趨
	 *
	 * @param workmanagerDAO ��������DAO�ӿ�
	 */
	public void setWorkmanagerDAO(WorkmanagerDAO workmanagerDAO) {
		this.workmanagerDAO = workmanagerDAO;
	}

	/**
	 * ��������ʵ��ȡ��
	 *
	 * @return ��������ʵ��
	 */
	public WorkmanagerTB getWorkmanagerTBInstance() {
		return new WorkmanagerTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkmanagerInfo> searchWorkmanager() {
		return workmanagerDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkmanagerInfo searchWorkmanagerByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkmanagerSearchCond cond) {
		return workmanagerDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond) {
		return workmanagerDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond, int start,
			int count) {
		return workmanagerDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkmanagerInfo registWorkmanager(WorkmanagerInfo instance)
		throws BLException {
		return workmanagerDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkmanagerInfo updateWorkmanager(WorkmanagerInfo instance)
		throws BLException {
		checkExistInstance(instance.getWmid());
		return workmanagerDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkmanagerByPK(Integer pk)
		throws BLException {
		workmanagerDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkmanager(WorkmanagerInfo instance)
		throws BLException {
		workmanagerDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public WorkmanagerInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkmanagerInfo instance = workmanagerDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ��ѯ��ǰ�������ư汾�����µ�һ��
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkmanagerInfo> searchNewWorkmanager(WorkmanagerSearchCond cond) {
		return workmanagerDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ͳ�ƴ�������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkmanagerVW> searchSumByCond(WorkmanagerSearchCond cond) {
		return workmanagerDAO.searchSumByCond(cond);
	}
}