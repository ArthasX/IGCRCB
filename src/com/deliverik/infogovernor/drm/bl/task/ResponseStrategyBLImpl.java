/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCond;
import com.deliverik.infogovernor.drm.model.dao.ResponseStrategyDAO;
import com.deliverik.infogovernor.drm.model.entity.ResponseStrategyTB;

/**
  * 概述: 场景响应策略业务逻辑实现
  * 功能描述: 场景响应策略业务逻辑实现
  * 创建记录: 2016/09/20
  * 修改记录: 
  */
public class ResponseStrategyBLImpl extends BaseBLImpl implements
		ResponseStrategyBL {

	/** 场景响应策略DAO接口 */
	protected ResponseStrategyDAO responseStrategyDAO;
	
	/**
	 * 场景响应策略DAO接口设定
	 *
	 * @param responseStrategyDAO 场景响应策略DAO接口
	 */
	public void setResponseStrategyDAO(ResponseStrategyDAO responseStrategyDAO) {
		this.responseStrategyDAO = responseStrategyDAO;
	}

	/**
	 * 场景响应策略实例取得
	 *
	 * @return 场景响应策略实例
	 */
	public ResponseStrategyTB getResponseStrategyTBInstance() {
		return new ResponseStrategyTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy() {
		return responseStrategyDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ResponseStrategyInfo searchResponseStrategyByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ResponseStrategySearchCond cond) {
		return responseStrategyDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy(
ResponseStrategySearchCond cond) throws BLException {
		return responseStrategyDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy(
			ResponseStrategySearchCond cond, int start,
			int count) {
		return responseStrategyDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ResponseStrategyInfo registResponseStrategy(ResponseStrategyInfo instance)
		throws BLException {
		return responseStrategyDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ResponseStrategyInfo updateResponseStrategy(ResponseStrategyInfo instance)
		throws BLException {
		checkExistInstance(instance.getRsid());
		return responseStrategyDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteResponseStrategyByPK(Integer pk)
		throws BLException {
		responseStrategyDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteResponseStrategy(ResponseStrategyInfo instance)
		throws BLException {
		responseStrategyDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ResponseStrategyInfo checkExistInstance(Integer pk)
		throws BLException {
		ResponseStrategyInfo instance = responseStrategyDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}