/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.dao.ProcessTimeDAO;
import com.deliverik.framework.workflow.prr.model.entity.ProcessTimeTB;


/**
  * ����: ���̼�ʱ��ҵ���߼�ʵ��
  * ��������: ���̼�ʱ��ҵ���߼�ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public class ProcessTimeBLImpl extends BaseBLImpl implements
		ProcessTimeBL {

	/** ���̼�ʱ��DAO�ӿ� */
	protected ProcessTimeDAO processTimeDAO;
	
	/**
	 * ���̼�ʱ��DAO�ӿ��趨
	 *
	 * @param processTimeDAO���̼�ʱ��DAO�ӿ�
	 */
	public void setProcessTimeDAO(ProcessTimeDAO processTimeDAO) {
		this.processTimeDAO = processTimeDAO;
	}

	/**
	 * ���̼�ʱ��ʵ��ȡ��
	 *
	 * @return ���̼�ʱ��ʵ��
	 */
	public ProcessTimeTB getProcessTimeTBInstance() {
		return new ProcessTimeTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessTimeInfo> searchProcessTime() {
		return processTimeDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ProcessTimeInfo searchProcessTimeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ProcessTimeSearchCond cond) {
		return processTimeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ProcessTimeInfo> searchProcessTime(
			ProcessTimeSearchCond cond) {
		return processTimeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ProcessTimeInfo> searchProcessTime(
			ProcessTimeSearchCond cond, int start,
			int count) {
		return processTimeDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ProcessTimeInfo registProcessTime(ProcessTimeInfo instance)
		throws BLException {
		return processTimeDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProcessTimeInfo updateProcessTime(ProcessTimeInfo instance)
		throws BLException {
		checkExistInstance(instance.getPrtid());
		return processTimeDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteProcessTimeByPK(Integer pk)
		throws BLException {
		processTimeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteProcessTime(ProcessTimeInfo instance)
		throws BLException {
		processTimeDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public ProcessTimeInfo checkExistInstance(Integer pk)
		throws BLException {
		ProcessTimeInfo instance = processTimeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}