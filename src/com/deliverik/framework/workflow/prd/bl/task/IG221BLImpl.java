/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG221DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG221VW;

/**
  * 概述: 参与者按钮定义信息表视图业务逻辑实现
  * 功能描述: 参与者按钮定义信息表视图业务逻辑实现
  * 创建记录: 2012/04/19
  * 修改记录: 
  */
public class IG221BLImpl extends BaseBLImpl implements
		IG221BL {

	/** 参与者按钮定义信息表视图DAO接口 */
	protected IG221DAO ig221DAO;
	
	/**
	 * 参与者按钮定义信息表视图DAO接口设定
	 *
	 * @param ig221DAO 参与者按钮定义信息表视图DAO接口
	 */
	public void setIg221DAO(IG221DAO ig221DAO) {
		this.ig221DAO = ig221DAO;
	}

	/**
	 * 参与者按钮定义信息表视图实例取得
	 *
	 * @return 参与者按钮定义信息表视图实例
	 */
	public IG221VW getProcessParticipantButtonDefVWTBInstance() {
		return new IG221VW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG221Info> searchIG221Info() {
		return ig221DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG221SearchCond cond) {
		return ig221DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond) {
		return ig221DAO.findByCond(cond, 0, 0);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG221Info> searchIG221InfoVW(
			IG221SearchCond cond) {
		return ig221DAO.findDefaultByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond, int start,
			int count) {
		return ig221DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG221Info registIG221Info(IG221Info instance)
		throws BLException {
		return ig221DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG221Info updateIG221Info(IG221Info instance)
		throws BLException {
		return ig221DAO.save(instance);
	}


	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG221Info(IG221Info instance)
		throws BLException {
		ig221DAO.delete(instance);
	}

}