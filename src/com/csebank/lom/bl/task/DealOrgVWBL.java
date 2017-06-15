/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * 模块：后勤管理=外出就餐管理
 * 说明：部门外出就餐汇总业务逻辑接口
 * 作者：唐晓娜
 */
public interface DealOrgVWBL extends BaseBL {
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DealOrg> searchDealOrgVW(DealOrgVWSearchCond cond, int start, int count);
	

}
