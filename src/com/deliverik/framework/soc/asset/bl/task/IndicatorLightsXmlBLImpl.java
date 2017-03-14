/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsXmlSearchCond;
import com.deliverik.framework.soc.asset.model.dao.IndicatorLightsXmlDAO;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsXmlTB;

/**
  * 概述: 告警系统显示区域表业务逻辑实现
  * 功能描述: 告警系统显示区域表业务逻辑实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public class IndicatorLightsXmlBLImpl extends BaseBLImpl implements
		IndicatorLightsXmlBL {

	/** 告警系统显示区域表DAO接口 */
	protected IndicatorLightsXmlDAO indicatorLightsXmlDAO;
	
	/**
	 * 告警系统显示区域表DAO接口设定
	 *
	 * @param indicatorLightsXmlDAO 告警系统显示区域表DAO接口
	 */
	public void setIndicatorLightsXmlDAO(IndicatorLightsXmlDAO indicatorLightsXmlDAO) {
		this.indicatorLightsXmlDAO = indicatorLightsXmlDAO;
	}

	/**
	 * 告警系统显示区域表实例取得
	 *
	 * @return 告警系统显示区域表实例
	 */
	public IndicatorLightsXmlTB getIndicatorLightsXmlTBInstance() {
		return new IndicatorLightsXmlTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml() {
		return indicatorLightsXmlDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IndicatorLightsXmlInfo searchIndicatorLightsXmlByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IndicatorLightsXmlSearchCond cond) {
		return indicatorLightsXmlDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml(
			IndicatorLightsXmlSearchCond cond) {
		return indicatorLightsXmlDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml(
			IndicatorLightsXmlSearchCond cond, int start,
			int count) {
		return indicatorLightsXmlDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IndicatorLightsXmlInfo registIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException {
		return indicatorLightsXmlDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IndicatorLightsXmlInfo updateIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException {
		checkExistInstance(instance.getIxid());
		return indicatorLightsXmlDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIndicatorLightsXmlByPK(Integer pk)
		throws BLException {
		indicatorLightsXmlDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException {
		indicatorLightsXmlDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IndicatorLightsXmlInfo checkExistInstance(Integer pk)
		throws BLException {
		IndicatorLightsXmlInfo instance = indicatorLightsXmlDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}