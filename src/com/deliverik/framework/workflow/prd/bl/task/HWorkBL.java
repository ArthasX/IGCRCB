/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.entity.HWorkVW;

/**
 * 历史工作统计业务逻辑接口
 */
public interface HWorkBL extends BaseBL {
	
	
	public List<HWorkVW> searchHistoryCount(String dto,String pruserid);
	
}
