/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;

/**
  * 概述: ErRelation业务逻辑接口
  * 功能描述: ErRelation业务逻辑接口
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public interface ErRelationBL extends BaseBL {

	/**
	 * ErRelation实例取得
	 *
	 * @return ErRelation实例
	 */
	public ErRelationTB getErRelationTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ErRelationInfo> searchErRelation();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ErRelationInfo searchErRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ErRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ErRelationInfo registErRelation(ErRelationInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ErRelationInfo updateErRelation(ErRelationInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteErRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteErRelation(ErRelationInfo instance)
		throws BLException;

}