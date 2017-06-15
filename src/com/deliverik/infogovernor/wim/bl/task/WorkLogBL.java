/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;

/**
  * ����: workLogҵ���߼��ӿ�
  * ��������: workLogҵ���߼��ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkLogBL extends BaseBL {

	/**
	 * workLogʵ��ȡ��
	 *
	 * @return workLogʵ��
	 */
	public WorkLogTB getWorkLogTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkLogInfo> searchWorkLog();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkLogInfo searchWorkLogByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkLogInfo> searchWorkLog(
			WorkLogSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkLogInfo registWorkLog(WorkLogInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkLogInfo updateWorkLog(WorkLogInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkLogByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkLog(WorkLogInfo instance)
		throws BLException;

}