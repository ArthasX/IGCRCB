/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.orl.model.OrealAlertInfo;
import com.deliverik.orl.model.condition.OrealAlertSearchCond;
import com.deliverik.orl.model.dao.OrealAlertDAO;
import com.deliverik.orl.model.entity.OrealAlertTB;

/**
 * 概述：欧莱雅告警表业务逻辑实现
 * 功能描述：欧莱雅告警表视图业务逻辑实现
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
public class OrealAlertBLImpl extends BaseBLImpl implements OrealAlertBL {

	/** 告警表DAO接口 */
	protected OrealAlertDAO orealAlertDAO;
	
	/**
	 * 告警表DAO接口设定
	 *
	 * @param orealAlertDAO  告警表DAO接口
	 */
	public void setOrealAlertDAO(OrealAlertDAO orealAlertDAO) {
		this.orealAlertDAO = orealAlertDAO;
	}

	/**
	 * 告警表实例取得
	 *
	 * @return 告警表实例
	 */
	public OrealAlertTB getOrealAlertTBInstance() {
		return new OrealAlertTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OrealAlertInfo> searchOrealAlert() {
		return orealAlertDAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws Exception 
	 */
	public int getSearchCount(OrealAlertSearchCond cond) throws BLException {
		return orealAlertDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 * @throws Exception 
	 */
	public List<OrealAlertInfo> searchOrealAlertByCond(OrealAlertSearchCond cond) throws BLException {
		return orealAlertDAO.findByCond(cond, 0, 0);
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
	public List<OrealAlertInfo> searchOrealAlertByCond(OrealAlertSearchCond cond, int start, int count) throws BLException {
		return orealAlertDAO.findByCond(cond, start, count);
	}
}