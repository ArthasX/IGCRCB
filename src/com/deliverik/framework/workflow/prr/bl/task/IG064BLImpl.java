/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG064DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG064VW;

/**
  * 概述: 流程记录节点提醒视图业务逻辑实现
  * 功能描述: 流程记录节点提醒视图业务逻辑实现
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public class IG064BLImpl extends BaseBLImpl implements
		IG064BL {

	/** 流程记录节点提醒视图DAO接口 */
	protected IG064DAO ig064DAO;
	
	/**
	 * 流程记录节点提醒视图DAO接口设定
	 *
	 * @param ig064DAO 流程记录节点提醒视图DAO接口
	 */
	public void setIg064DAO(IG064DAO ig064DAO) {
		this.ig064DAO = ig064DAO;
	}

	/**
	 * 流程记录节点提醒视图实例取得
	 *
	 * @return 流程记录节点提醒视图实例
	 */
	public IG064VW getIG064VWInstance() {
		return new IG064VW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG064Info> searchIG064Info() {
		return ig064DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG064SearchCond cond) {
		return ig064DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond) {
		return ig064DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond, int start,
			int count) {
		return ig064DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param ig064Info 新增实例
	 * @return 新增实例
	 */
	public IG064Info registIG064Info(IG064Info ig064Info)
		throws BLException {
		return ig064DAO.save(ig064Info);
	}

	/**
	 * 修改处理
	 *
	 * @param ig064Info 修改实例
	 * @return 修改实例
	 */
	public IG064Info updateIG064Info(IG064Info ig064Info)
		throws BLException {
		return ig064DAO.save(ig064Info);
	}


	/**
	 * 删除处理
	 *
	 * @param ig064Info 删除实例
	 */
	public void deleteIG064Info(IG064Info ig064Info)
		throws BLException {
		ig064DAO.delete(ig064Info);
	}


}