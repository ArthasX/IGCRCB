/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.CheckItemVWDAO;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;

/**
  * 概述: 检查项查询业务逻辑实现
  * 功能描述: 检查项查询业务逻辑实现
  * 创建记录: 2014/07/01
  * 修改记录: 
  */
public class CheckItemVWBLImpl extends BaseBLImpl implements
		CheckItemVWBL {

	/** 检查项查询DAO接口 */
	protected CheckItemVWDAO checkItemVWDAO;
	
	/**
	 * 检查项查询DAO接口设定
	 *
	 * @param checkItemVWDAO 检查项查询DAO接口
	 */
	public void setCheckItemVWDAO(CheckItemVWDAO checkItemVWDAO) {
		this.checkItemVWDAO = checkItemVWDAO;
	}

	/**
	 * 检查项查询实例取得
	 *
	 * @return 检查项查询实例
	 */
	public CheckItemVW getCheckItemVWTBInstance() {
		return new CheckItemVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckItemVWInfo> searchCheckItemVW() {
		return checkItemVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckItemVWInfo searchCheckItemVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CheckItemVWSearchCond cond) {
		return checkItemVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CheckItemVWInfo> searchCheckItemVW(
			CheckItemVWSearchCond cond) {
		return checkItemVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckItemVWInfo> searchCheckItemVW(
			CheckItemVWSearchCond cond, int start,
			int count) {
		return checkItemVWDAO.findByCond(cond, start, count);
	}
	
	/**
	 * (信息安全 检查项)条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckItemVWInfo> searchSafeInfoCheckItemVW(
			CheckItemVWSearchCond cond, int start,
			int count) {
		return checkItemVWDAO.safeInfoFindByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CheckItemVWInfo registCheckItemVW(CheckItemVWInfo instance)
		throws BLException {
		return checkItemVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CheckItemVWInfo updateCheckItemVW(CheckItemVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return checkItemVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCheckItemVWByPK(Integer pk)
		throws BLException {
		checkItemVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCheckItemVW(CheckItemVWInfo instance)
		throws BLException {
		checkItemVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CheckItemVWInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckItemVWInfo instance = checkItemVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}