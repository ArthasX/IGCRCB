/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.dao.WorkInstanceDAO;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;

/**
  * ����: workInstanceҵ���߼�ʵ��
  * ��������: workInstanceҵ���߼�ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkInstanceBLImpl extends BaseBLImpl implements
		WorkInstanceBL {

	/** workInstanceDAO�ӿ� */
	protected WorkInstanceDAO workInstanceDAO;
	
	/**
	 * workInstanceDAO�ӿ��趨
	 *
	 * @param workInstanceDAO workInstanceDAO�ӿ�
	 */
	public void setWorkInstanceDAO(WorkInstanceDAO workInstanceDAO) {
		this.workInstanceDAO = workInstanceDAO;
	}

	/**
	 * workInstanceʵ��ȡ��
	 *
	 * @return workInstanceʵ��
	 */
	public WorkInstanceTB getWorkInstanceTBInstance() {
		return new WorkInstanceTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkInstanceInfo> searchWorkInstance() {
		return workInstanceDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkInstanceInfo searchWorkInstanceByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkInstanceSearchCond cond) {
		return workInstanceDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond) {
		return workInstanceDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond, int start,
			int count) {
		return workInstanceDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkInstanceInfo registWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		return workInstanceDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkInstanceInfo updateWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		checkExistInstance(instance.getWiid());
		return workInstanceDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkInstanceByPK(Integer pk)
		throws BLException {
		workInstanceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		workInstanceDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public WorkInstanceInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkInstanceInfo instance = workInstanceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}