/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.ScopesInfo;
import com.deliverik.infogovernor.drm.model.condition.ScopesSearchCond;
import com.deliverik.infogovernor.drm.model.dao.ScopesDAO;
import com.deliverik.infogovernor.drm.model.entity.ScopesTB;

/**
  * 概述: 事件影响范围业务逻辑实现
  * 功能描述: 事件影响范围业务逻辑实现
  * 创建记录: 2015/03/20
  * 修改记录: 
  */
public class ScopesBLImpl extends BaseBLImpl implements
		ScopesBL {

	/** 事件影响范围DAO接口 */
	protected ScopesDAO scopesDAO;
	
	/**
	 * 事件影响范围DAO接口设定
	 *
	 * @param scopesDAO 事件影响范围DAO接口
	 */
	public void setScopesDAO(ScopesDAO scopesDAO) {
		this.scopesDAO = scopesDAO;
	}

	/**
	 * 事件影响范围实例取得
	 *
	 * @return 事件影响范围实例
	 */
	public ScopesTB getScopesTBInstance() {
		return new ScopesTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ScopesInfo> searchScopes() {
		return scopesDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ScopesInfo searchScopesByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ScopesSearchCond cond) {
		return scopesDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ScopesInfo> searchScopes(
			ScopesSearchCond cond) {
		return scopesDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ScopesInfo> searchScopes(
			ScopesSearchCond cond, int start,
			int count) {
		return scopesDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ScopesInfo registScopes(ScopesInfo instance)
		throws BLException {
		return scopesDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ScopesInfo updateScopes(ScopesInfo instance)
		throws BLException {
		checkExistInstance(instance.getScopeid());
		return scopesDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteScopesByPK(Integer pk)
		throws BLException {
		scopesDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteScopes(ScopesInfo instance)
		throws BLException {
		scopesDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ScopesInfo checkExistInstance(Integer pk)
		throws BLException {
		ScopesInfo instance = scopesDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}