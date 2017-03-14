/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCond;

/**
 * 
 * 值班日报业务逻辑接口
 *
 */
public interface DutyResultVWBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyResultVWSearchCond cond);
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查内容
	 */
	public List<DutyResultVWInfo> searchDutyResultVWAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyResultVWInfo> searchDutyResultVW(DutyResultVWSearchCond cond, int start, int count);

	

}
