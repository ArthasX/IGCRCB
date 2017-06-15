/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareobjectHistoryDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectHistoryTB;

/**
  * 概述: 对比对象历史表业务逻辑实现
  * 功能描述: 对比对象历史表业务逻辑实现
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
public class CompareobjectHistoryBLImpl extends BaseBLImpl implements
		CompareobjectHistoryBL {

	/** 对比对象历史表DAO接口 */
	protected CompareobjectHistoryDAO compareobjectHistoryDAO;
	
	/**
	 * 对比对象历史表DAO接口设定
	 *
	 * @param compareobjectHistoryDAO 对比对象历史表DAO接口
	 */
	public void setCompareobjectHistoryDAO(CompareobjectHistoryDAO compareobjectHistoryDAO) {
		this.compareobjectHistoryDAO = compareobjectHistoryDAO;
	}

	/**
	 * 对比对象历史表实例取得
	 *
	 * @return 对比对象历史表实例
	 */
	public CompareobjectHistoryTB getCompareobjectHistoryTBInstance() {
		return new CompareobjectHistoryTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory() {
		return compareobjectHistoryDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareobjectHistoryInfo searchCompareobjectHistoryByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareobjectHistorySearchCond cond) {
		return compareobjectHistoryDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond) {
		return compareobjectHistoryDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond, int start,
			int count) {
		return compareobjectHistoryDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareobjectHistoryInfo registCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException {
		return compareobjectHistoryDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareobjectHistoryInfo updateCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException {
		checkExistInstance(instance.getCohid());
		return compareobjectHistoryDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareobjectHistoryByPK(Integer pk)
		throws BLException {
		compareobjectHistoryDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException {
		compareobjectHistoryDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CompareobjectHistoryInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareobjectHistoryInfo instance = compareobjectHistoryDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}