/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeTemplateSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTemplateTB;

/**
  * ����: ��Ϣʱ��ģ�嶨���ҵ���߼��ӿ�
  * ��������: ��Ϣʱ��ģ�嶨���ҵ���߼��ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessWorkTimeTemplateBL extends BaseBL {

	/**
	 * ��Ϣʱ��ģ�嶨���ʵ��ȡ��
	 *
	 * @return ��Ϣʱ��ģ�嶨���ʵ��
	 */
	public ProcessWorkTimeTemplateTB getProcessWorkTimeTemplateTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessWorkTimeTemplateInfo> searchProcessWorkTimeTemplate();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ProcessWorkTimeTemplateInfo searchProcessWorkTimeTemplateByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ProcessWorkTimeTemplateSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ProcessWorkTimeTemplateInfo> searchProcessWorkTimeTemplate(
			ProcessWorkTimeTemplateSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ProcessWorkTimeTemplateInfo registProcessWorkTimeTemplate(ProcessWorkTimeTemplateInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProcessWorkTimeTemplateInfo updateProcessWorkTimeTemplate(ProcessWorkTimeTemplateInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteProcessWorkTimeTemplateByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteProcessWorkTimeTemplate(ProcessWorkTimeTemplateInfo instance)
		throws BLException;

}