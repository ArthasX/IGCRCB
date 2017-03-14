/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.dao.IG499DAO;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: 合同资产信息视图业务逻辑实现
  * 功能描述: 合同资产信息视图业务逻辑实现
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
public class IG499BLImpl extends BaseBLImpl implements
		IG499BL {

	/** 合同资产信息视图DAO接口 */
	protected IG499DAO ig499DAO;
	
	/**
	 * 合同资产信息视图DAO接口设定
	 *
	 * @param IG499DAO 合同资产信息视图DAO接口
	 */
	public void setIg499DAO(IG499DAO ig499DAO) {
		this.ig499DAO = ig499DAO;
	}

	/**
	 * 合同资产信息视图实例取得
	 *
	 * @return 合同资产信息视图实例
	 */
	public IG499VW getIG499VWInstance() {
		return new IG499VW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG499Info> searchIG499Info() {
		return ig499DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG499SearchCond cond) {
		return ig499DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond) {
		return ig499DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond, int start,
			int count) {
		return ig499DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchImprestCount(final IG499SearchCond cond){
		return ig499DAO.getSearchImprestCount(cond);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG499Info> findImprestByCond(final IG499SearchCond cond, 
			final int start, final int count){
		return ig499DAO.findImprestByCond(cond, start, count);
	}


}