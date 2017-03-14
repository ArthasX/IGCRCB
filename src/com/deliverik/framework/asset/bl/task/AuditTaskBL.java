/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.asset.model.entity.AuditTaskTB;

/**
  * ����: ��������ҵ���߼��ӿ�
  * ��������: ��������ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditTaskBL extends BaseBL {

	/**
	 * ��������ʵ��ȡ��
	 *
	 * @return ��������ʵ��
	 */
	public AuditTaskTB getAuditTaskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditTaskInfo> searchAuditTask();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditTaskInfo searchAuditTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditTaskInfo registAuditTask(AuditTaskInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditTaskInfo updateAuditTask(AuditTaskInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditTask(AuditTaskInfo instance)
		throws BLException;

}