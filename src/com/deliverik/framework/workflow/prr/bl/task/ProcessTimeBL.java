/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessTimeTB;



/**
  * ����: ���̼�ʱ��ҵ���߼��ӿ�
  * ��������: ���̼�ʱ��ҵ���߼��ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessTimeBL extends BaseBL {

	/**
	 * ���̼�ʱ��ʵ��ȡ��
	 *
	 * @return ���̼�ʱ��ʵ��
	 */
	public ProcessTimeTB getProcessTimeTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessTimeInfo> searchProcessTime();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ProcessTimeInfo searchProcessTimeByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ProcessTimeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ProcessTimeInfo> searchProcessTime(
			ProcessTimeSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ProcessTimeInfo registProcessTime(ProcessTimeInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProcessTimeInfo updateProcessTime(ProcessTimeInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteProcessTimeByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteProcessTime(ProcessTimeInfo instance)
		throws BLException;

}