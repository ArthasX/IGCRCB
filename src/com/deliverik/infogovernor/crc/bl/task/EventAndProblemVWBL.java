/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;
import com.deliverik.infogovernor.crc.model.condition.EventAndProblemVWSearchCond;
/**
 * 概述: 事件和问题联合查询业务逻辑接口
 * 功能描述: 事件和问题联合查询业务逻辑接口
 * 创建记录: 2017/08/02
 * 修改记录: 
 */
public interface EventAndProblemVWBL extends BaseBL{

	/**
	 * 查询事件和问题
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<EventAndProblemVWInfo> findByCond( EventAndProblemVWSearchCond cond,  int start,  int count);
	
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount( EventAndProblemVWSearchCond cond);
}
