/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0106Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0106SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0106TB;

/**
  * 概述: SOC0106业务逻辑接口
  * 功能描述: SOC0106业务逻辑接口
  * 创建记录: 2012/07/31
  * 修改记录: 
  */
public interface SOC0106BL extends BaseBL {

	/**
	 * SOC0106实例取得
	 *
	 * @return SOC0106实例
	 */
	public SOC0106TB getSOC0106Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0106Info> searchSOC0106();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0106Info searchSOC0106ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0106SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0106Info> searchSOC0106(
			SOC0106SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0106Info> searchSOC0106(
			SOC0106SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0106Info registSOC0106(SOC0106Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0106Info updateSOC0106(SOC0106Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0106ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0106(SOC0106Info instance)
		throws BLException;

}