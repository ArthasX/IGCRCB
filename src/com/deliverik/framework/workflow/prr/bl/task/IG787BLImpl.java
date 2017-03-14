/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG787DAO;

/**
 * <p>概述:流程共同变量视图业务逻辑实现</p>
 * <p>功能描述：1.根据查询条件查询流程的共通变量信息</p>
 *           
 * <p>创建记录：</p>
 */
public class IG787BLImpl extends BaseBLImpl implements IG787BL{
	
	/** 流程共通变量视图DAO*/
	protected IG787DAO ig787DAO;

	/**
	 * 功能：流程共通变量视图DAO
	 * 
	 * @param ig787DAO 流程共通变量视图DAO
	 */
	public void setIg787DAO(
			IG787DAO ig787DAO) {
		this.ig787DAO = ig787DAO;
	}


	/**
	 * 功能：根据查询条件查询流程的共通变量信息
	 * @param cond 流程共通变量视图查询条件
	 * @param start 检索记录起始号
	 * @param count 检索记录条数
	 * @return 流程共同变量List
	 * 
	 */
	public List<IG787Info> findByCond(final IG787SearchCond cond, final int start, final int count) {
		return ig787DAO.findByCond(cond, start, count);
	}

}
