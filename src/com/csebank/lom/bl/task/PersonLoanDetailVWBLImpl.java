/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.csebank.lom.model.dao.PersonLoanDetailVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 人员借款明细查询接口实现
 */
public class PersonLoanDetailVWBLImpl extends BaseBLImpl implements PersonLoanDetailVWBL {
	
	static Log log = LogFactory.getLog(PersonLoanDetailVWBLImpl.class);

	/**
	 * 人员借款明细查询DAO
	 */
	protected PersonLoanDetailVWDAO personLoanDetailVWDAO;

	/**
	 * 人员借款明细查询DAO设定
	 * @param personLoanDetailVWDAO 人员借款明细查询DAO
	 */
	public void setPersonLoanDetailVWDAO(
			PersonLoanDetailVWDAO personLoanDetailVWDAO) {
		this.personLoanDetailVWDAO = personLoanDetailVWDAO;
	}

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
	public List<PersonLoanDetail> searchPersonLoanDetailVW(PersonLoanDetailSearchCond cond,
			int start, int count) {
		List<PersonLoanDetail> ret = personLoanDetailVWDAO.findByCond(cond,start,count);
		return ret;
	}
	/**
	 * <p>
	 * Description: 人员借款明细查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @return 列表记录件数
	 */
	public int getSearchCount(PersonLoanDetailSearchCond cond) {
		return personLoanDetailVWDAO.getSearchCount(cond);
	}
}
