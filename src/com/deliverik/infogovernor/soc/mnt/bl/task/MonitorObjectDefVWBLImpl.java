/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefVWSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorObjectDefVWDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefVW;

/**
  * ����: ��ض���KPI��Ϣ��ͼҵ���߼�ʵ��
  * ��������: ��ض���KPI��Ϣ��ͼҵ���߼�ʵ��
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
public class MonitorObjectDefVWBLImpl extends BaseBLImpl implements
		MonitorObjectDefVWBL {

	/** ��ض���KPI��Ϣ��ͼDAO�ӿ� */
	protected MonitorObjectDefVWDAO monitorObjectDefVWDAO;
	
	/**
	 * ��ض���KPI��Ϣ��ͼDAO�ӿ��趨
	 *
	 * @param monitorObjectDefVWDAO ��ض���KPI��Ϣ��ͼDAO�ӿ�
	 */
	public void setMonitorObjectDefVWDAO(MonitorObjectDefVWDAO monitorObjectDefVWDAO) {
		this.monitorObjectDefVWDAO = monitorObjectDefVWDAO;
	}

	/**
	 * ��ض���KPI��Ϣ��ͼʵ��ȡ��
	 *
	 * @return ��ض���KPI��Ϣ��ͼʵ��
	 */
	public MonitorObjectDefVW getMonitorObjectDefVWTBInstance() {
		return new MonitorObjectDefVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW() {
		return monitorObjectDefVWDAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorObjectDefVWSearchCond cond) {
		return monitorObjectDefVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW(
			MonitorObjectDefVWSearchCond cond) {
		return monitorObjectDefVWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return monitorObjectDefVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorObjectDefVWInfo registMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException {
		return monitorObjectDefVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorObjectDefVWInfo updateMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException {
		return monitorObjectDefVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException {
		monitorObjectDefVWDAO.delete(instance);
	}

}