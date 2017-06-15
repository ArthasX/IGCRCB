/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * 部门接待统计业务逻辑接口
 */
public interface DeptEentertainmentBL extends BaseBL {
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DeptEentertainment> searchDeptEentertainment(DeptEentertainmentSearchCond cond, int start, int count);

}
