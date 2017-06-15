/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.EiWaitTaskTB;

/**
  * ����: ����������ҵ���߼��ӿ�
  * ��������: ����������ҵ���߼��ӿ�
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public interface EiWaitTaskBL extends BaseBL {

	/**
	 * ����������ʵ��ȡ��
	 *
	 * @return ����������ʵ��
	 */
	public EiWaitTaskTB getEiWaitTaskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiWaitTaskInfo searchEiWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiWaitTaskInfo registEiWaitTask(EiWaitTaskInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiWaitTaskInfo updateEiWaitTask(EiWaitTaskInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiWaitTask(EiWaitTaskInfo instance)
		throws BLException;

}