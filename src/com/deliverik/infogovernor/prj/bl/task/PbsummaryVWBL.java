/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;


/**
 * <p>
 * 预算及工程分类信息视图业务逻辑接口
 * </p>
 */

public interface PbsummaryVWBL extends BaseBL{
	/**
	 * 预算及工程分类信息视图统计
	 * 
	 * @return 预算及工程分类信息视图统计列表
	 */	
	public List<Pbsummary> searchPbsummary(final PbsummaryVWSearchCond cond, final int start, final int count);
}
