/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCond;
/**
 * 虚拟化资源统计业务逻辑实现
 *
 */
public interface VIM03CountByProjVWBL extends BaseBL {
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM03CountByProjVWInfo> findByCond(final VIM03CountByProjVWSearchCond cond,final int start,final int count);
}
