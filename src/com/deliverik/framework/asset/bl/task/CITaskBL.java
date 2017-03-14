/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.asset.model.entity.CITaskTB;

/**
  * ����: CI��������ҵ���߼��ӿ�
  * ��������: CI��������ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CITaskBL extends BaseBL {

	/**
	 * CI��������ʵ��ȡ��
	 *
	 * @return CI��������ʵ��
	 */
	public CITaskTB getCITaskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CITaskInfo> searchCITask();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CITaskInfo searchCITaskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CITaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CITaskInfo> searchCITask(
			CITaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CITaskInfo> searchCITask(
			CITaskSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CITaskInfo registCITask(CITaskInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CITaskInfo updateCITask(CITaskInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCITaskByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCITask(CITaskInfo instance)
		throws BLException;

}