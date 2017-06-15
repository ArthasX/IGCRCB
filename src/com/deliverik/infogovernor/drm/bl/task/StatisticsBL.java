/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.condition.StatisticsSearchCond;

/**
 * ������Ӧ������ͳ�Ʋ�ѯBL�ӿ�
 * ����������Ӧ������ͳ�Ʋ�ѯBL�ӿ�
 * ������¼��2015/5/23
 * zhangjian
 */
public interface StatisticsBL extends BaseBL {
	/**
	 * Ԥ��ͳ�Ʋ�ѯ
	 * ͳ��Ԥ������,�޶�����,��������
	 * @return
	 */
	public List<Map<String,Object>> planStatistics(StatisticsSearchCond cond)throws BLException;
	/**
	 * ����ͳ�Ʋ�ѯ
	 * �����ƻ�ͳ��,��������ͳ��,����ִ��ͳ��
	 * @return
	 */
	public List<Map<String,Object>> drillStatistics(StatisticsSearchCond cond )throws BLException;
	/**
	 * ������ʽͳ��
	 * 
	 * @return
	 */
	public List<Map<String,Object>> drillTypeStatistics(StatisticsSearchCond cond )throws BLException;
	/**
	 * Ԥ��ͳ��-��ѯԤ���ʲ�eiid
	 * @return
	 */
	public List<Map<String, Object>> getSceneEiids(StatisticsSearchCond cond ) throws BLException;
}