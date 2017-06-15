/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;
import com.deliverik.infogovernor.prr.model.dao.DispatchStatisticsVWDAO;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;

/**
  * 概述: 发文流程统计业务逻辑实现
  * 功能描述: 发文流程统计业务逻辑实现
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public class DispatchStatisticsVWBLImpl extends BaseBLImpl implements
		DispatchStatisticsVWBL {

	/** 发文流程统计DAO接口 */
	protected DispatchStatisticsVWDAO dispatchStatisticsVWDAO;
	
	/**
	 * 发文流程统计DAO接口设定
	 *
	 * @param dispatchStatisticsVWDAO 发文流程统计DAO接口
	 */
	public void setDispatchStatisticsVWDAO(DispatchStatisticsVWDAO dispatchStatisticsVWDAO) {
		this.dispatchStatisticsVWDAO = dispatchStatisticsVWDAO;
	}

	/**
	 * 发文流程统计实例取得
	 *
	 * @return 发文流程统计实例
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance() {
		return new DispatchStatisticsVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW() {
		return dispatchStatisticsVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DispatchStatisticsVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(DispatchStatisticsVWSearchCond cond) {
		return dispatchStatisticsVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond) {
		return dispatchStatisticsVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,
			int count) {
		return dispatchStatisticsVWDAO.findByCond(cond, start, count);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DispatchStatisticsVWInfo> findDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,
			int count) {
		return dispatchStatisticsVWDAO.findDispatchStatistics(cond, start, count);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getDispatchStatisticsSearchCount(DispatchStatisticsVWSearchCond cond) {
		return dispatchStatisticsVWDAO.findDispatchStatisticsSearchCount(cond);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public DispatchStatisticsVWInfo registDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException {
		return dispatchStatisticsVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public DispatchStatisticsVWInfo updateDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getDsuserid());
		return dispatchStatisticsVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteDispatchStatisticsVWByPK(String pk)
		throws BLException {
		dispatchStatisticsVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException {
		dispatchStatisticsVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public DispatchStatisticsVWInfo checkExistInstance(String pk)
		throws BLException {
		DispatchStatisticsVWInfo instance = dispatchStatisticsVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}