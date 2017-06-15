/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCond;
import com.deliverik.infogovernor.wim.model.dao.WorkLogDAO;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;

/**
  * ����: workLogҵ���߼�ʵ��
  * ��������: workLogҵ���߼�ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkLogBLImpl extends BaseBLImpl implements
		WorkLogBL {

	/** workLogDAO�ӿ� */
	protected WorkLogDAO workLogDAO;
	
	/**
	 * workLogDAO�ӿ��趨
	 *
	 * @param workLogDAO workLogDAO�ӿ�
	 */
	public void setWorkLogDAO(WorkLogDAO workLogDAO) {
		this.workLogDAO = workLogDAO;
	}

	/**
	 * workLogʵ��ȡ��
	 *
	 * @return workLogʵ��
	 */
	public WorkLogTB getWorkLogTBInstance() {
		return new WorkLogTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkLogInfo> searchWorkLog() {
		return workLogDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkLogInfo searchWorkLogByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkLogSearchCond cond) {
		return workLogDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkLogInfo> searchWorkLog(
			WorkLogSearchCond cond) {
		return workLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkLogInfo> searchWorkLog(
			WorkLogSearchCond cond, int start,
			int count) {
		return workLogDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkLogInfo registWorkLog(WorkLogInfo instance)
		throws BLException {
		return workLogDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkLogInfo updateWorkLog(WorkLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getWlid());
		return workLogDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkLogByPK(Integer pk)
		throws BLException {
		workLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkLog(WorkLogInfo instance)
		throws BLException {
		workLogDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public WorkLogInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkLogInfo instance = workLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}