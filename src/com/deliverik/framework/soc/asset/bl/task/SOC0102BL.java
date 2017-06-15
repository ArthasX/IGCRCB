/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0102TB;

/**
  * 概述: 审计资产表业务逻辑接口
  * 功能描述: 审计资产表业务逻辑接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface SOC0102BL extends BaseBL {

	/**
	 * 审计资产表实例取得
	 *
	 * @return 审计资产表实例
	 */
	public SOC0102TB getSOC0102Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0102Info> searchSOC0102();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0102Info searchSOC0102ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0102SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0102Info registSOC0102(SOC0102Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0102Info updateSOC0102(SOC0102Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0102ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0102(SOC0102Info instance)
		throws BLException;

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteSOC0102();

}