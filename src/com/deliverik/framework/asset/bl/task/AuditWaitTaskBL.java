/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.AuditWaitTaskTB;

/**
  * ����: ��ƴ���������ҵ���߼��ӿ�
  * ��������: ��ƴ���������ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditWaitTaskBL extends BaseBL {

	/**
	 * ��ƴ���������ʵ��ȡ��
	 *
	 * @return ��ƴ���������ʵ��
	 */
	public AuditWaitTaskTB getAuditWaitTaskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditWaitTaskInfo searchAuditWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask(
			AuditWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask(
			AuditWaitTaskSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditWaitTaskInfo registAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditWaitTaskInfo updateAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException;

}