/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIEntityItemInfo;
import com.deliverik.framework.asset.model.condition.CIEntityItemSearchCond;
import com.deliverik.framework.asset.model.entity.CIEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * 概述: CI变更资产表业务逻辑接口
  * 功能描述: CI变更资产表业务逻辑接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CIEntityItemBL extends BaseBL {

	/**
	 * CI变更资产表实例取得
	 *
	 * @return CI变更资产表实例
	 */
	public CIEntityItemTB getCIEntityItemTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIEntityItemInfo> searchCIEntityItem();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIEntityItemInfo searchCIEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CIEntityItemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CIEntityItemInfo registCIEntityItem(CIEntityItemInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CIEntityItemInfo updateCIEntityItem(CIEntityItemInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCIEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCIEntityItem(CIEntityItemInfo instance)
		throws BLException;

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteCIEntityItem();

}