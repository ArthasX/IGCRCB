/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;
import com.deliverik.framework.soc.asset.model.condition.SynchronizationAlarmSystemVWSearchCond;
import com.deliverik.framework.soc.asset.model.dao.SynchronizationAlarmSystemVWDAO;

/**
 * ����:ͬ���澯ϵͳ��ͼBLʵ��
 * ��������: ͬ���澯ϵͳ��ͼBLʵ��
 * �����ˣ�����
 * ������¼: 2014/04/03
 * �޸ļ�¼: 
 */

public class SynchronizationAlarmSystemVWBLImpl extends BaseBLImpl implements
	SynchronizationAlarmSystemVWBL {

	/** ͬ���澯ϵͳ��ͼDAO */
	protected SynchronizationAlarmSystemVWDAO synchronizationAlarmSystemVWDAO;

	public void setSynchronizationAlarmSystemVWDAO(
			SynchronizationAlarmSystemVWDAO synchronizationAlarmSystemVWDAO) {
		this.synchronizationAlarmSystemVWDAO = synchronizationAlarmSystemVWDAO;
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SynchronizationAlarmSystemVWInfo> findByCond(final SynchronizationAlarmSystemVWSearchCond cond){
		return synchronizationAlarmSystemVWDAO.findByCond(cond);
	}
}
