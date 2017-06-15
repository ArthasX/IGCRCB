/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * 人员借款明细查询接口
 */
public interface PersonLoanDetailVWBL extends BaseBL {

	/**
	 * <p>
	 * Description: 人员借款明细查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<PersonLoanDetail>
	 */
	public List<PersonLoanDetail> searchPersonLoanDetailVW(PersonLoanDetailSearchCond cond,int start, int count);
	
	/**
	 * <p>
	 * Description: 人员借款明细查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @return 列表记录件数
	 */
	public int getSearchCount(PersonLoanDetailSearchCond cond);
	
}
