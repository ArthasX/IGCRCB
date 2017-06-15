/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.csebank.lom.model.dao.PersonLoanSummaryVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 预支人员统计查询接口实现
 */
public class PersonLoanSummaryVWBLImpl extends BaseBLImpl implements PersonLoanSummaryVWBL {
	
	static Log log = LogFactory.getLog(PersonLoanSummaryVWBLImpl.class);

	/**
	 * 预支人员统计查询DAO
	 */
	protected PersonLoanSummaryVWDAO personLoanSummaryVWDAO;

	/**
	 * 预支人员统计查询DAO设定
	 * @param personLoanSummaryVWDAO 预支人员统计查询DAO
	 */
	public void setPersonLoanSummaryVWDAO(
			PersonLoanSummaryVWDAO personLoanSummaryVWDAO) {
		this.personLoanSummaryVWDAO = personLoanSummaryVWDAO;
	}

	/**
	 * <p>
	 * Description: 预支人员统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<PersonLoanSummary>
	 */
	public List<PersonLoanSummary> searchPersonLoanSummaryVW(PersonLoanSummarySearchCond cond,
			int start, int count) {
		List<PersonLoanSummary> ret = personLoanSummaryVWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: 预支人员统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @return 列表记录件数
	 */
	public int getSearchCount(PersonLoanSummarySearchCond cond) {
		return personLoanSummaryVWDAO.getSearchCount(cond);
	}

}
