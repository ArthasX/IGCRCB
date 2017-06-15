/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefVWSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefVW;

/**
  * ����: ��ض���KPI��Ϣ��ͼҵ���߼��ӿ�
  * ��������: ��ض���KPI��Ϣ��ͼҵ���߼��ӿ�
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
public interface MonitorObjectDefVWBL extends BaseBL {

	/**
	 * ��ض���KPI��Ϣ��ͼʵ��ȡ��
	 *
	 * @return ��ض���KPI��Ϣ��ͼʵ��
	 */
	public MonitorObjectDefVW getMonitorObjectDefVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorObjectDefVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW(
			MonitorObjectDefVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW(
			MonitorObjectDefVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorObjectDefVWInfo registMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorObjectDefVWInfo updateMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException;


	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException;

}