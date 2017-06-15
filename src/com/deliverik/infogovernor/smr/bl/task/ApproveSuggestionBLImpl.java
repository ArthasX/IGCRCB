/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCond;
import com.deliverik.infogovernor.smr.model.dao.ApproveSuggestionDAO;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
  * 概述: 审批意见表业务逻辑实现
  * 功能描述: 审批意见表业务逻辑实现
  * 创建记录: 2013/07/22
  * 修改记录: 
  */
public class ApproveSuggestionBLImpl extends BaseBLImpl implements
		ApproveSuggestionBL {

	/** 审批意见表DAO接口 */
	protected ApproveSuggestionDAO approveSuggestionDAO;
	
	/**
	 * 审批意见表DAO接口设定
	 *
	 * @param approveSuggestionDAO 审批意见表DAO接口
	 */
	public void setApproveSuggestionDAO(ApproveSuggestionDAO approveSuggestionDAO) {
		this.approveSuggestionDAO = approveSuggestionDAO;
	}

	/**
	 * 审批意见表实例取得
	 *
	 * @return 审批意见表实例
	 */
	public ApproveSuggestionTB getApproveSuggestionTBInstance() {
		return new ApproveSuggestionTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo() {
		return approveSuggestionDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ApproveSuggestionInfo searchApproveSuggestionInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ApproveSuggestionSearchCond cond) {
		return approveSuggestionDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo(
			ApproveSuggestionSearchCond cond) {
		return approveSuggestionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo(
			ApproveSuggestionSearchCond cond, int start,
			int count) {
		return approveSuggestionDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ApproveSuggestionInfo registApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException {
		return approveSuggestionDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ApproveSuggestionInfo updateApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return approveSuggestionDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteApproveSuggestionInfoByPK(Integer pk)
		throws BLException {
		approveSuggestionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException {
		approveSuggestionDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ApproveSuggestionInfo checkExistInstance(Integer pk)
		throws BLException {
		ApproveSuggestionInfo instance = approveSuggestionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "审批意见基本");
		}
		return instance;
	}

}