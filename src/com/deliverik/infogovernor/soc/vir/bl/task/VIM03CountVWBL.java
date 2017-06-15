/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
/**
 * 虚拟化资源统计业务逻辑实现
 *
 */
public interface VIM03CountVWBL extends BaseBL {

	/**
	 * 检索条数取得
	 *
	 * @param cond 检索条件
	 * @return 检索条数
	 */
	public Integer getCount(final VIM03CountVWSearchCond cond);
	/**
	 * 检索条数取得
	 *
	 * @param cond 检索条件
	 * @return 检索条数
	 */
	public Integer getCountByCond(final VIM03CountVWSearchCond cond);
}
