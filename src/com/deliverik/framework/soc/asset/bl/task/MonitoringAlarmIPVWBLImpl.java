/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.dao.MonitoringAlarmIPVWDAO;

/**
 * ����:��ظ澯ip��ͼBLʵ��
 * ��������: ��ظ澯ip��ͼBLʵ��
 * �����ˣ�����
 * ������¼: 2014/04/01
 * �޸ļ�¼: 
 */

public class MonitoringAlarmIPVWBLImpl extends BaseBLImpl implements
	MonitoringAlarmIPVWBL {

	/** ��ظ澯ip��ͼDAO */
	protected MonitoringAlarmIPVWDAO monitoringAlarmIPVWDAO;

	public void setMonitoringAlarmIPVWDAO(
			MonitoringAlarmIPVWDAO monitoringAlarmIPVWDAO) {
		this.monitoringAlarmIPVWDAO = monitoringAlarmIPVWDAO;
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond){
		return monitoringAlarmIPVWDAO.findByCond(cond);
	}
}
