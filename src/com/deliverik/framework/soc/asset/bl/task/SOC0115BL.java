/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0115SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0115TB;

/**
  * ����: ����������ҵ���߼��ӿ�
  * ��������: ����������ҵ���߼��ӿ�
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public interface SOC0115BL extends BaseBL {

	/**
	 * ����������ʵ��ȡ��
	 *
	 * @return ����������ʵ��
	 */
	public SOC0115TB getEiWaitTaskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0115Info> searchEiWaitTask();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0115Info searchEiWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0115SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0115Info> searchEiWaitTask(
			SOC0115SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0115Info> searchEiWaitTask(
			SOC0115SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0115Info registEiWaitTask(SOC0115Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0115Info updateEiWaitTask(SOC0115Info instance)
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
	public void deleteEiWaitTask(SOC0115Info instance)
		throws BLException;

}