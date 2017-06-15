/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.condition.CIConfigItemSearchCond;
import com.deliverik.framework.asset.model.entity.CIConfigItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * 概述: CI变更资产属性表业务逻辑接口
  * 功能描述: CI变更资产属性表业务逻辑接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CIConfigItemBL extends BaseBL {

	/**
	 * CI变更资产属性表实例取得
	 *
	 * @return CI变更资产属性表实例
	 */
	public CIConfigItemTB getCIConfigItemTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIConfigItemInfo> searchCIConfigItem();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIConfigItemInfo searchCIConfigItemByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CIConfigItemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CIConfigItemInfo registCIConfigItem(CIConfigItemInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CIConfigItemInfo updateCIConfigItem(CIConfigItemInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCIConfigItemByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCIConfigItem(CIConfigItemInfo instance)
		throws BLException;

	/**
	 * 检索资产属性及属性对比分类
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CIConfigItemInfo> searchCIConfigItemForAucmptype(Integer eiid);

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteCIConfigItem();

}