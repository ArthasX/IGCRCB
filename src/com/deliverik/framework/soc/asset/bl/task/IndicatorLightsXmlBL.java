/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsXmlSearchCond;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsXmlTB;

/**
  * 概述: 告警系统显示区域表业务逻辑接口
  * 功能描述: 告警系统显示区域表业务逻辑接口
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public interface IndicatorLightsXmlBL extends BaseBL {

	/**
	 * 告警系统显示区域表实例取得
	 *
	 * @return 告警系统显示区域表实例
	 */
	public IndicatorLightsXmlTB getIndicatorLightsXmlTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IndicatorLightsXmlInfo searchIndicatorLightsXmlByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IndicatorLightsXmlSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml(
			IndicatorLightsXmlSearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IndicatorLightsXmlInfo registIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IndicatorLightsXmlInfo updateIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIndicatorLightsXmlByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException;

}