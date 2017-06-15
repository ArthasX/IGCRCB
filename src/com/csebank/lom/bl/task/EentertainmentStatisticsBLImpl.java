/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.csebank.lom.model.dao.EentertainmentStatisticsDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 食堂接待统计业务逻辑接口实现
 */
public class EentertainmentStatisticsBLImpl extends BaseBLImpl implements EentertainmentStatisticsBL {
	
	/** EentertainmentStatistics DAO */
	protected EentertainmentStatisticsDAO eentertainmentStatisticsDAO;
	
	public void setEentertainmentStatisticsDAO(
			EentertainmentStatisticsDAO eentertainmentStatisticsDAO) {
		this.eentertainmentStatisticsDAO = eentertainmentStatisticsDAO;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EentertainmentStatistics> searchEentertainmentStatistics(EentertainmentStatisticsSearchCond cond, int start, int count){
		
		return eentertainmentStatisticsDAO.findByCond(cond,start,count);
	}

}
