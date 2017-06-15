/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckStrategySearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckStrategyDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckStrategyTB;

/**
  * 概述: 检查策略业务逻辑实现
  * 功能描述: 检查策略业务逻辑实现
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public class CheckStrategyBLImpl extends BaseBLImpl implements
		CheckStrategyBL {

	/** 检查策略DAO接口 */
	protected CheckStrategyDAO checkStrategyDAO;
	
	/**
	 * 检查策略DAO接口设定
	 *
	 * @param checkStrategyDAO 检查策略DAO接口
	 */
	public void setCheckStrategyDAO(CheckStrategyDAO checkStrategyDAO) {
		this.checkStrategyDAO = checkStrategyDAO;
	}

	/**
	 * 检查策略实例取得
	 *
	 * @return 检查策略实例
	 */
	public CheckStrategyTB getCheckStrategyTBInstance() {
		return new CheckStrategyTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckStrategyInfo> searchCheckStrategy() {
		return checkStrategyDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckStrategyInfo searchCheckStrategyByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CheckStrategySearchCond cond) {
		return checkStrategyDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CheckStrategyInfo> searchCheckStrategy(
			CheckStrategySearchCond cond) {
		return checkStrategyDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckStrategyInfo> searchCheckStrategy(
			CheckStrategySearchCond cond, int start,
			int count) {
		return checkStrategyDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CheckStrategyInfo registCheckStrategy(CheckStrategyInfo instance)
		throws BLException {
		return checkStrategyDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CheckStrategyInfo updateCheckStrategy(CheckStrategyInfo instance)
		throws BLException {
		checkExistInstance(instance.getCsid());
		return checkStrategyDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCheckStrategyByPK(Integer pk)
		throws BLException {
		checkStrategyDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCheckStrategy(CheckStrategyInfo instance)
		throws BLException {
		checkStrategyDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CheckStrategyInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckStrategyInfo instance = checkStrategyDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	

}