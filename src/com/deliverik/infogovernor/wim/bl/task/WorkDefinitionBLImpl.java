/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkDefinitionSearchCond;
import com.deliverik.infogovernor.wim.model.dao.WorkDefinitionDAO;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;

/**
  * ����: WorkDefinitionҵ���߼�ʵ��
  * ��������: WorkDefinitionҵ���߼�ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkDefinitionBLImpl extends BaseBLImpl implements
		WorkDefinitionBL {

	/** WorkDefinitionDAO�ӿ� */
	protected WorkDefinitionDAO workDefinitionDAO;
	
	/**
	 * WorkDefinitionDAO�ӿ��趨
	 *
	 * @param workDefinitionDAO WorkDefinitionDAO�ӿ�
	 */
	public void setWorkDefinitionDAO(WorkDefinitionDAO workDefinitionDAO) {
		this.workDefinitionDAO = workDefinitionDAO;
	}

	/**
	 * WorkDefinitionʵ��ȡ��
	 *
	 * @return WorkDefinitionʵ��
	 */
	public WorkDefinitionTB getWorkDefinitionTBInstance() {
		return new WorkDefinitionTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition() {
		return workDefinitionDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkDefinitionInfo searchWorkDefinitionByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkDefinitionSearchCond cond) {
		return workDefinitionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition(
			WorkDefinitionSearchCond cond) {
		return workDefinitionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition(
			WorkDefinitionSearchCond cond, int start,
			int count) {
		return workDefinitionDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkDefinitionInfo registWorkDefinition(WorkDefinitionInfo instance)
		throws BLException {
		return workDefinitionDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkDefinitionInfo updateWorkDefinition(WorkDefinitionInfo instance)
		throws BLException {
		checkExistInstance(instance.getWdid());
		return workDefinitionDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkDefinitionByPK(Integer pk)
		throws BLException {
		workDefinitionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkDefinition(WorkDefinitionInfo instance)
		throws BLException {
		workDefinitionDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public WorkDefinitionInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkDefinitionInfo instance = workDefinitionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}