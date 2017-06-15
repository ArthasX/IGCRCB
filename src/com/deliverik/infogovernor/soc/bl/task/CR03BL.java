/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCond;
import com.deliverik.infogovernor.soc.model.entity.CR03PK;
import com.deliverik.infogovernor.soc.model.entity.CR03TB;

/**
  * 概述: 配置原数据与主机关系表业务逻辑接口
  * 功能描述: 配置原数据与主机关系表业务逻辑接口
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
public interface CR03BL extends BaseBL {

	/**
	 * 配置原数据与主机关系表实例取得
	 *
	 * @return 配置原数据与主机关系表实例
	 */
	public CR03TB getCR03TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CR03Info> searchCR03();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CR03Info searchCR03ByPK(CR03PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CR03SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CR03Info> searchCR03(
			CR03SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CR03Info> searchCR03(
			CR03SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CR03Info registCR03(CR03Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CR03Info updateCR03(CR03Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCR03ByPK(CR03PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCR03(CR03Info instance)
		throws BLException;
	/**
	 * 查询记录
	 *
	 * @param instance 查询实例
	 */
	public List<CR03Info> findByCondMax(
			final CR03SearchCond cond, final int start, 
			final int count);
	/**
	 * 条件检索处理[最大日期的导入和type]
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CR03VWInfo> findByCondMaxAndEsyscoding(final CR03SearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索结果件数取得[最大日期的导入和type]
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCountByCondMaxAndEsyscoding(final CR03SearchCond cond);
	
	/**
	 * 获取配置采集的版本信息
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CR03VWInfo> getRciVersions(final CR03SearchCond cond, final int start, final int count);

}