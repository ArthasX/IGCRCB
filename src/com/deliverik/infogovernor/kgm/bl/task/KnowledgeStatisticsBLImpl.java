/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowLedgeStatisticsDAO;

/**
  * 概述: 知识库统计业务逻辑实现
  * 功能描述: 知识库统计业务逻辑实现
  * 创建记录: 2014/3/13
  * 修改记录: 
  */
public class KnowledgeStatisticsBLImpl extends BaseBLImpl implements
	KnowledgeStatisticsBL {

	/** knowLedgeStatisticsDAO接口 */
	protected KnowLedgeStatisticsDAO knowLedgeStatisticsDAO;
	
	/**
	 * knowLedgeStatisticsDAO接口设定
	 *
	 * @param knowLedgeStatisticsDAO knowLedgeStatisticsDAO接口
	 */
	public void setKnowLedgeStatisticsDAO(
			KnowLedgeStatisticsDAO knowLedgeStatisticsDAO) {
		this.knowLedgeStatisticsDAO = knowLedgeStatisticsDAO;
	}
	
	/**
	 * 条件检索处理(按贡献人)
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<KnowledgeStatisticsInfo> searchKnprofferStatistics(KnowledgeStatisticsSearchCond cond) 
			throws BLException  {
		return knowLedgeStatisticsDAO.findByKnprofferCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理(按分类)
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<KnowledgeStatisticsInfo> searchKnclassStatistics(KnowledgeStatisticsSearchCond cond) 
			throws BLException {
		return knowLedgeStatisticsDAO.findByKnclassCond(cond, 0, 0);
	}
}