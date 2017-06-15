/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;

/**
 * 概述:知识流程关联信息业务逻辑接口
 * 功能描述：知识流程关联信息业务逻辑接口
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
public interface KnowledgeStatisticsBL extends BaseBL {
	
	/**
	 * 条件检索处理(按贡献人)
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<KnowledgeStatisticsInfo> searchKnprofferStatistics(KnowledgeStatisticsSearchCond cond)
			throws BLException;

	/**
	 * 条件检索处理(按分类)
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<KnowledgeStatisticsInfo> searchKnclassStatistics(KnowledgeStatisticsSearchCond cond)
			throws BLException  ;

}
