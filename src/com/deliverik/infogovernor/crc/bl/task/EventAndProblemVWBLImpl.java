/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;
import com.deliverik.infogovernor.crc.model.condition.EventAndProblemVWSearchCond;
import com.deliverik.infogovernor.crc.model.dao.EventAndProblemVWDAO;

/**
 * 概述: 事件和问题联合查询业务逻辑
 * 功能描述: 事件和问题联合查询业务逻辑
 * 创建记录: 2017/08/02
 * 修改记录: 
 */
public class EventAndProblemVWBLImpl extends BaseBLImpl implements
		EventAndProblemVWBL {

	/** 变更流程DAO接口 */
	protected EventAndProblemVWDAO eventAndProblemVWDAO;
	
	
	
		
	public void setEventAndProblemVWDAO(EventAndProblemVWDAO eventAndProblemVWDAO) {
		this.eventAndProblemVWDAO = eventAndProblemVWDAO;
	}




	public List<EventAndProblemVWInfo> findByCond(
			EventAndProblemVWSearchCond cond, int start, int count) {
		return eventAndProblemVWDAO.findByCond(cond, start, count);
	}





	public int getSearchCount(EventAndProblemVWSearchCond cond) {
		return eventAndProblemVWDAO.getSearchCount(cond);
	}



}
