/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.CIWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.CIWaitTaskTB;

/**
  * ����: CI�������������ҵ���߼��ӿ�
  * ��������: CI�������������ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIWaitTaskBL extends BaseBL {

	/**
	 * CI�������������ʵ��ȡ��
	 *
	 * @return CI�������������ʵ��
	 */
	public CIWaitTaskTB getCIWaitTaskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIWaitTaskInfo searchCIWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask(
			CIWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask(
			CIWaitTaskSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIWaitTaskInfo registCIWaitTask(CIWaitTaskInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIWaitTaskInfo updateCIWaitTask(CIWaitTaskInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIWaitTask(CIWaitTaskInfo instance)
		throws BLException;

}