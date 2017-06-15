/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTB;

/**
  * ����: �û���Ϣʱ�䶨���ҵ���߼��ӿ�
  * ��������: �û���Ϣʱ�䶨���ҵ���߼��ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessWorkTimeBL extends BaseBL {

	/**
	 * �û���Ϣʱ�䶨���ʵ��ȡ��
	 *
	 * @return �û���Ϣʱ�䶨���ʵ��
	 */
	public ProcessWorkTimeTB getProcessWorkTimeTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ProcessWorkTimeInfo searchProcessWorkTimeByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ProcessWorkTimeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime(
			ProcessWorkTimeSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ProcessWorkTimeInfo registProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProcessWorkTimeInfo updateProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteProcessWorkTimeByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException;

}