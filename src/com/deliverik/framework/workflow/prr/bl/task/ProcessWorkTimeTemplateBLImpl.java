/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeTemplateSearchCond;
import com.deliverik.framework.workflow.prr.model.dao.ProcessWorkTimeTemplateDAO;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTemplateTB;


/**
  * ����: ��Ϣʱ��ģ�嶨���ҵ���߼�ʵ��
  * ��������: ��Ϣʱ��ģ�嶨���ҵ���߼�ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public class ProcessWorkTimeTemplateBLImpl extends BaseBLImpl implements
		ProcessWorkTimeTemplateBL {

	/** ��Ϣʱ��ģ�嶨���DAO�ӿ� */
	protected ProcessWorkTimeTemplateDAO processWorkTimeTemplateDAO;
	
	/**
	 * ��Ϣʱ��ģ�嶨���DAO�ӿ��趨
	 *
	 * @param processWorkTimeTemplateDAO��Ϣʱ��ģ�嶨���DAO�ӿ�
	 */
	public void setProcessWorkTimeTemplateDAO(ProcessWorkTimeTemplateDAO processWorkTimeTemplateDAO) {
		this.processWorkTimeTemplateDAO = processWorkTimeTemplateDAO;
	}

	/**
	 * ��Ϣʱ��ģ�嶨���ʵ��ȡ��
	 *
	 * @return ��Ϣʱ��ģ�嶨���ʵ��
	 */
	public ProcessWorkTimeTemplateTB getProcessWorkTimeTemplateTBInstance() {
		return new ProcessWorkTimeTemplateTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessWorkTimeTemplateInfo> searchProcessWorkTimeTemplate() {
		return processWorkTimeTemplateDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ProcessWorkTimeTemplateInfo searchProcessWorkTimeTemplateByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ProcessWorkTimeTemplateSearchCond cond) {
		return processWorkTimeTemplateDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ProcessWorkTimeTemplateInfo> searchProcessWorkTimeTemplate(
			ProcessWorkTimeTemplateSearchCond cond) {
		return processWorkTimeTemplateDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ProcessWorkTimeTemplateInfo> searchProcessWorkTimeTemplate(
			ProcessWorkTimeTemplateSearchCond cond, int start,
			int count) {
		return processWorkTimeTemplateDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ProcessWorkTimeTemplateInfo registProcessWorkTimeTemplate(ProcessWorkTimeTemplateInfo instance)
		throws BLException {
		return processWorkTimeTemplateDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProcessWorkTimeTemplateInfo updateProcessWorkTimeTemplate(ProcessWorkTimeTemplateInfo instance)
		throws BLException {
		checkExistInstance(instance.getPwtId());
		return processWorkTimeTemplateDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteProcessWorkTimeTemplateByPK(Integer pk)
		throws BLException {
		processWorkTimeTemplateDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteProcessWorkTimeTemplate(ProcessWorkTimeTemplateInfo instance)
		throws BLException {
		processWorkTimeTemplateDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public ProcessWorkTimeTemplateInfo checkExistInstance(Integer pk)
		throws BLException {
		ProcessWorkTimeTemplateInfo instance = processWorkTimeTemplateDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}