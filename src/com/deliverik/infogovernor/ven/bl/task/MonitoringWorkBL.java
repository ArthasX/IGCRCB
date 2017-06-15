/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCond;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;

/**
  * ����: ��⹤�����ҵ���߼��ӿ�
  * ��������: ��⹤�����ҵ���߼��ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface MonitoringWorkBL extends BaseBL {

	/**
	 * ��⹤�����ʵ��ȡ��
	 *
	 * @return ��⹤�����ʵ��
	 */
	public MonitoringWorkTB getMonitoringWorkTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitoringWorkInfo searchMonitoringWorkByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitoringWorkSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork(
			MonitoringWorkSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork(
			MonitoringWorkSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitoringWorkInfo registMonitoringWork(MonitoringWorkInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitoringWorkInfo updateMonitoringWork(MonitoringWorkInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitoringWorkByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitoringWork(MonitoringWorkInfo instance)
		throws BLException;

}