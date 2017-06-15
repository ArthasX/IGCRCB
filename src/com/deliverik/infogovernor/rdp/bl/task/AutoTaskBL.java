/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;
import com.deliverik.infogovernor.rdp.model.condition.AutoTaskSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.AutoTaskTB;

/**
  * ����: AutoTaskҵ���߼��ӿ�
  * ��������: AutoTaskҵ���߼��ӿ�
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public interface AutoTaskBL extends BaseBL {

	/**
	 * AutoTaskʵ��ȡ��
	 *
	 * @return AutoTaskʵ��
	 */
	public AutoTaskTB getAutoTaskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AutoTaskInfo> searchAutoTask();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AutoTaskInfo searchAutoTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AutoTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AutoTaskInfo> searchAutoTask(
			AutoTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AutoTaskInfo> searchAutoTask(
			AutoTaskSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AutoTaskInfo registAutoTask(AutoTaskInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AutoTaskInfo updateAutoTask(AutoTaskInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAutoTaskByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAutoTask(AutoTaskInfo instance)
		throws BLException;

}