/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;
import com.deliverik.infogovernor.prj.model.dao.PbsummaryVWDAO;


/**
 * <p>
 * 预算及工程分类信息视图业务逻辑实现
 * </p>
 */
public class PbsummaryVWBLImpl extends BaseBLImpl implements PbsummaryVWBL{
	
	/**预算及工程分类信息视图DAO*/
	protected PbsummaryVWDAO pbsummaryVWDAO;

	/**
	 * 预算及工程分类信息视图DAO设定
	 * @param pbsummaryVWDAO 预算及工程分类信息视图DAO
	 */
	public void setPbsummaryVWDAO(PbsummaryVWDAO pbsummaryVWDAO) {
		this.pbsummaryVWDAO = pbsummaryVWDAO;
	}
	
	/**
	 * 预算及工程分类信息视图统计
	 * 
	 * @return 预算及工程分类信息视图统计列表
	 */	
	public List<Pbsummary> searchPbsummary(final PbsummaryVWSearchCond cond, final int start, final int count) {
		return pbsummaryVWDAO.findByCond(cond, start, count);
	}
}
