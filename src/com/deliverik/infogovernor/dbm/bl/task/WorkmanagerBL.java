/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerTB;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * ����: ��������ҵ���߼��ӿ�
  * ��������: ��������ҵ���߼��ӿ�
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
public interface WorkmanagerBL extends BaseBL {

	/**
	 * ��������ʵ��ȡ��
	 *
	 * @return ��������ʵ��
	 */
	public WorkmanagerTB getWorkmanagerTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkmanagerInfo> searchWorkmanager();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkmanagerInfo searchWorkmanagerByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkmanagerSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkmanagerInfo registWorkmanager(WorkmanagerInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkmanagerInfo updateWorkmanager(WorkmanagerInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkmanagerByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkmanager(WorkmanagerInfo instance)
		throws BLException;

	/**
	 * ��ѯ��ǰ�������ư汾�����µ�һ��
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkmanagerInfo> searchNewWorkmanager(WorkmanagerSearchCond cond);
	
	/**
	 * ͳ�ƴ�������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkmanagerVW> searchSumByCond(WorkmanagerSearchCond cond);
	
}