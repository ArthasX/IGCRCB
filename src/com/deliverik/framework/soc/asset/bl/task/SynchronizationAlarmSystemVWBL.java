/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;
import com.deliverik.framework.soc.asset.model.condition.SynchronizationAlarmSystemVWSearchCond;

/**
 * ����:ͬ���澯ϵͳ��ͼBL�ӿ�
 * ��������: ͬ���澯ϵͳ��ͼBL�ӿ�
 * �����ˣ�����
 * ������¼: 2014/04/03
 * �޸ļ�¼: 
 */

public interface SynchronizationAlarmSystemVWBL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SynchronizationAlarmSystemVWInfo> findByCond(final SynchronizationAlarmSystemVWSearchCond cond);
	
}
