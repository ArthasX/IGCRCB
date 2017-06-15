/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.orl.model.OrealPMVWInfo;
import com.deliverik.orl.model.condition.OrealPMVWSearchCond;
import com.deliverik.orl.model.dao.OrealPMVWDAO;
import com.deliverik.orl.model.entity.OrealPMVW;

/**
 * 概述：欧莱雅监控指标视图业务逻辑实现
 * 功能描述：欧莱雅监控指标视图业务逻辑实现
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
public class OrealPMVWBLImpl extends BaseBLImpl implements OrealPMVWBL {

	/** 监控指标视图DAO接口 */
	protected OrealPMVWDAO orealPMVWDAO;
	
	/**
	 * 监控指标视图DAO接口设定
	 *
	 * @param orealPMVWDAO  监控指标视图DAO接口
	 */
	public void setOrealPMVWDAO(OrealPMVWDAO orealPMVWDAO) {
		this.orealPMVWDAO = orealPMVWDAO;
	}

	/**
	 * 监控指标视图实例取得
	 *
	 * @return 监控指标视图实例
	 */
	public OrealPMVW getOrealPMVWInstance() {
		return new OrealPMVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OrealPMVWInfo> searchOrealPMVW() {
		return orealPMVWDAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws Exception 
	 */
	public int getSearchCount(OrealPMVWSearchCond cond) throws BLException {
		return orealPMVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 * @throws Exception 
	 */
	public List<OrealPMVWInfo> searchOrealPMVWByCond(OrealPMVWSearchCond cond) throws BLException {
		return orealPMVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws Exception 
	 */
	public List<OrealPMVWInfo> searchOrealPMVWByCond(OrealPMVWSearchCond cond, int start, int count) throws BLException {
		return orealPMVWDAO.findByCond(cond, start, count);
	}
}