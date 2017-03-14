/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;

/**
 * <p>
 * 流程相关人员汇总统计业务逻辑
 * </p>
 */
public interface IG160BL extends BaseBL{
	
	/**
	 * 流程相关人员汇总统计
	 * 
	 * @return 流程相关人员汇总统计列表
	 */
	
	public List<IG160Info> searchIG160Info(final IG160SearchCond cond, final int start, final int count);
}
