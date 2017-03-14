/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.condition.StatisticsSearchCond;
import com.deliverik.infogovernor.drm.model.dao.StatisticsDAO;

/**
 * ������Ӧ������ͳ�Ʋ�ѯBL�ӿ�ʵ��
 * ����������Ӧ������ͳ�Ʋ�ѯBL�ӿ�ʵ��
 * ������¼��2015/5/23
 * zhangjian
 */
public class StatisticsBLImpl extends BaseBLImpl implements StatisticsBL {
	
	private StatisticsDAO statisticsDao;

	public void setStatisticsDao(StatisticsDAO statisticsDAO) {
		this.statisticsDao = statisticsDAO;
	}

	/**
	 * Ԥ��ͳ�Ʋ�ѯ
	 * ͳ��Ԥ������,�޶�����,��������
	 * @return
	 */
	public List<Map<String,Object>> planStatistics(StatisticsSearchCond cond) throws BLException{
		return statisticsDao.planStatistics(cond);
		
	}
	
	/**
	 * ����ͳ�Ʋ�ѯ
	 * �����ƻ�ͳ��,��������ͳ��,����ִ��ͳ��
	 * @return
	 */
	public List<Map<String,Object>> drillStatistics(StatisticsSearchCond cond )throws BLException{
		return statisticsDao.drillStatistics(cond);
	}
	/**
	 * ������ʽͳ��
	 * 
	 * @return
	 */
	public List<Map<String,Object>> drillTypeStatistics(StatisticsSearchCond cond ) throws BLException{
		return statisticsDao.drillTypeStatistics(cond);
	}
	/**
	 * Ԥ��ͳ��-��ѯԤ���ʲ�eiid
	 * @return
	 */
	public List<Map<String, Object>> getSceneEiids(StatisticsSearchCond cond ) throws BLException{
		return statisticsDao.getSceneEiids(cond);
	}
	

	
}