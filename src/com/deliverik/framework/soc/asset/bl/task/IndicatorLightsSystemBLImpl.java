/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsSystemSearchCond;
import com.deliverik.framework.soc.asset.model.dao.IndicatorLightsSystemDAO;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsSystemTB;

/**
  * 概述: 告警系统显示信息表业务逻辑实现
  * 功能描述: 告警系统显示信息表业务逻辑实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public class IndicatorLightsSystemBLImpl extends BaseBLImpl implements
		IndicatorLightsSystemBL {

	/** 告警系统显示信息表DAO接口 */
	protected IndicatorLightsSystemDAO indicatorLightsSystemDAO;
	
	/**
	 * 告警系统显示信息表DAO接口设定
	 *
	 * @param indicatorLightsSystemDAO 告警系统显示信息表DAO接口
	 */
	public void setIndicatorLightsSystemDAO(IndicatorLightsSystemDAO indicatorLightsSystemDAO) {
		this.indicatorLightsSystemDAO = indicatorLightsSystemDAO;
	}

	/**
	 * 告警系统显示信息表实例取得
	 *
	 * @return 告警系统显示信息表实例
	 */
	public IndicatorLightsSystemTB getIndicatorLightsSystemTBInstance() {
		return new IndicatorLightsSystemTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem() {
		return indicatorLightsSystemDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IndicatorLightsSystemInfo searchIndicatorLightsSystemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IndicatorLightsSystemSearchCond cond) {
		return indicatorLightsSystemDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem(
			IndicatorLightsSystemSearchCond cond) {
		return indicatorLightsSystemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem(
			IndicatorLightsSystemSearchCond cond, int start,
			int count) {
		return indicatorLightsSystemDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IndicatorLightsSystemInfo registIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException {
		return indicatorLightsSystemDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IndicatorLightsSystemInfo updateIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException {
		checkExistInstance(instance.getIlsid());
		return indicatorLightsSystemDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIndicatorLightsSystemByPK(Integer pk)
		throws BLException {
		indicatorLightsSystemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException {
		indicatorLightsSystemDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IndicatorLightsSystemInfo checkExistInstance(Integer pk)
		throws BLException {
		IndicatorLightsSystemInfo instance = indicatorLightsSystemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}