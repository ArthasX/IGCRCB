/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_变更KPI统计接口
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public interface ChangeKpiBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: 变更KPI统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<ChangeKpi>
	 * @author maozhipeng@deliverik.com
	 */
	public List<ChangeKpi> searchChangeKpi(ChangeKpiSearchCond cond,int start, int count);
	
}
