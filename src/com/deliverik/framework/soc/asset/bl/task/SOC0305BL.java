/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;

/**
  * 概述: SOC0305业务逻辑接口
  * 功能描述: SOC0305业务逻辑接口
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
public interface SOC0305BL extends BaseBL {

	/**
	 * SOC0305实例取得
	 *
	 * @return SOC0305实例
	 */
	public SOC0305TB getSoc0305Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0305Info> searchSoc0305();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0305Info searchSoc0305ByPK(Integer id)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0305SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0305Info registSoc0305(SOC0305Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0305Info updateSoc0305(SOC0305Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteSoc0305ByPK(Integer id)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteSoc0305(SOC0305Info instance)
		throws BLException;

	
	public int getVWSearchCount(SOC0305SearchCond storageEventSearchCond) throws BLException;

	public List<SOC0307Info> searchSOC0307(
			SOC0305SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException;


}