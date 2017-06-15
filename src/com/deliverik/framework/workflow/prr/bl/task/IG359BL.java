/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;

/**
 * <p>
 * 相关资产流程统计汇总统计业务逻辑
 * </p>
 */
public interface IG359BL extends BaseBL{
	
	/**
	 * 相关资产流程统计汇总统计
	 * 
	 * @return 相关资产流程统计汇总统计列表
	 */
	
	public List<IG359Info> searchIG359Info(final IG359SearchCond cond, final int start, final int count);
}
