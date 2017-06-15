/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.SnapshotRelationInfo;
import com.deliverik.framework.asset.model.SwitchPortVW;
import com.deliverik.framework.asset.model.SwitchZoneVW;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.entity.ShowEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;

/**
  * 概述: 快照关系表业务逻辑接口
  * 功能描述: 快照关系表业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SnapshotRelationBL extends BaseBL {

	/**
	 * 快照关系表实例取得
	 *
	 * @return 快照关系表实例
	 */
	public SnapshotRelationTB getSnapshotRelationTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SnapshotRelationInfo searchSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SnapshotRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation(
			SnapshotRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation(
			SnapshotRelationSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SnapshotRelationInfo registSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SnapshotRelationInfo updateSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException;
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SnapshotEntityVW> searchSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<ShowEntityVW> searchDiskFromSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchDaFromSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchFaFromSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SwitchZoneVW> searchSwitchZoneByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SwitchPortVW> searchSwitchPortByCond(final SnapshotRelationSearchCond cond);	
    
    /**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SnapshotRelationTB> searchSwitchRelationByCond(SnapshotRelationSearchCond cond1,SnapshotRelationSearchCond cond2);

	
}