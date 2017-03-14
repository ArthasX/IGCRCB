/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.csebank.lom.model.dao.AdvanceDetailVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 预支人员统计查询接口实现
 */
public class AdvanceDetailVWBLImpl extends BaseBLImpl implements AdvanceDetailVWBL {
	
	static Log log = LogFactory.getLog(AdvanceDetailVWBLImpl.class);

	/**
	 * 预支人员统计查询DAO
	 */
	protected AdvanceDetailVWDAO advanceDetailVWDAO;

	/**
	 * 预支人员统计查询DAO设定
	 * @param advanceDetailVWDAO 预支人员统计查询DAO
	 */
	public void setAdvanceDetailVWDAO(
			AdvanceDetailVWDAO advanceDetailVWDAO) {
		this.advanceDetailVWDAO = advanceDetailVWDAO;
	}

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
	public List<AdvanceDetail> searchAdvanceDetailVW(AdvanceDetailSearchCond cond,
			int start, int count) {
		List<AdvanceDetail> ret = advanceDetailVWDAO.findByCond(cond,start,count);
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
	public int getSearchCount(AdvanceDetailSearchCond cond) {
		return advanceDetailVWDAO.getSearchCount(cond);
	}

}
