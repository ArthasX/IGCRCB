/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * 预支人员统计查询接口
 */
public interface AdvanceDetailVWBL extends BaseBL {

	/**
	 * <p>
	 * Description: 预支人员统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<AdvanceDetail>
	 */
	public List<AdvanceDetail> searchAdvanceDetailVW(AdvanceDetailSearchCond cond,int start, int count);
	
	/**
	 * <p>
	 * Description: 预支人员统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @return 列表记录件数
	 */
	public int getSearchCount(AdvanceDetailSearchCond cond);
	
}
