/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.dao.ProcessWorkTimeDAO;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTB;


/**
  * ����: �û���Ϣʱ�䶨���ҵ���߼�ʵ��
  * ��������: �û���Ϣʱ�䶨���ҵ���߼�ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public class ProcessWorkTimeBLImpl extends BaseBLImpl implements
		ProcessWorkTimeBL {

	/** �û���Ϣʱ�䶨���DAO�ӿ� */
	protected ProcessWorkTimeDAO processWorkTimeDAO;
	
	/**
	 * �û���Ϣʱ�䶨���DAO�ӿ��趨
	 *
	 * @param processWorkTimeDAO�û���Ϣʱ�䶨���DAO�ӿ�
	 */
	public void setProcessWorkTimeDAO(ProcessWorkTimeDAO processWorkTimeDAO) {
		this.processWorkTimeDAO = processWorkTimeDAO;
	}

	/**
	 * �û���Ϣʱ�䶨���ʵ��ȡ��
	 *
	 * @return �û���Ϣʱ�䶨���ʵ��
	 */
	public ProcessWorkTimeTB getProcessWorkTimeTBInstance() {
		return new ProcessWorkTimeTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime() {
		return processWorkTimeDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ProcessWorkTimeInfo searchProcessWorkTimeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ProcessWorkTimeSearchCond cond) {
		return processWorkTimeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime(
			ProcessWorkTimeSearchCond cond) {
		return processWorkTimeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime(
			ProcessWorkTimeSearchCond cond, int start,
			int count) {
		return processWorkTimeDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ProcessWorkTimeInfo registProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException {
		return processWorkTimeDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProcessWorkTimeInfo updateProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException {
		checkExistInstance(instance.getPwId());
		return processWorkTimeDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteProcessWorkTimeByPK(Integer pk)
		throws BLException {
		processWorkTimeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException {
		processWorkTimeDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public ProcessWorkTimeInfo checkExistInstance(Integer pk)
		throws BLException {
		ProcessWorkTimeInfo instance = processWorkTimeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}