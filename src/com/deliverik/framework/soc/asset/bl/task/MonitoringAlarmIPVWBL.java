/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;


/**
 * ����:��ظ澯ip��ͼBL�ӿ�
 * ��������: ��ظ澯ip��ͼBL�ӿ�
 * �����ˣ�����
 * ������¼: 2014/04/01
 * �޸ļ�¼: 
 */

public interface MonitoringAlarmIPVWBL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond);
	
}
