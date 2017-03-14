/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.SnapshotRelationInfo;
import com.deliverik.framework.asset.model.SwitchPortVW;
import com.deliverik.framework.asset.model.SwitchZoneVW;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.dao.SnapshotEntityVWDAO;
import com.deliverik.framework.asset.model.dao.SnapshotRelationDAO;
import com.deliverik.framework.asset.model.entity.ShowEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;

/**
  * 概述: 快照关系表业务逻辑实现
  * 功能描述: 快照关系表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SnapshotRelationBLImpl extends BaseBLImpl implements
		SnapshotRelationBL {

	/** 快照关系表DAO接口 */
	protected SnapshotRelationDAO snapshotRelationDAO;
	
	/** 快照关系表DAO试图接口 */
	protected SnapshotEntityVWDAO snapshotEntityVWDAO;
	
	/**
	 * 快照关系表DAO接口设定
	 *
	 * @param snapshotRelationDAO快照关系表DAO接口
	 */
	public void setSnapshotRelationDAO(SnapshotRelationDAO snapshotRelationDAO) {
		this.snapshotRelationDAO = snapshotRelationDAO;
	}

	/**
	 * 快照关系表实例取得
	 *
	 * @return 快照关系表实例
	 */
	public SnapshotRelationTB getSnapshotRelationTBInstance() {
		return new SnapshotRelationTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation() {
		return snapshotRelationDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SnapshotRelationInfo searchSnapshotRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SnapshotRelationSearchCond cond) {
		return snapshotRelationDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation(
			SnapshotRelationSearchCond cond) {
		return snapshotRelationDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return snapshotRelationDAO.findByCond(cond, start, count);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SnapshotEntityVW> searchSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findByCond(cond);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<ShowEntityVW> searchDiskFromSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findDiskByCond(cond);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchDaFromSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findDaByCond(cond);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchFaFromSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findFaByCond(cond);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SnapshotRelationInfo registSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException {
		return snapshotRelationDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SnapshotRelationInfo updateSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getSrid());
		return snapshotRelationDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException {
		snapshotRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException {
		snapshotRelationDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SnapshotRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		SnapshotRelationInfo instance = snapshotRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public void setSnapshotEntityVWDAO(SnapshotEntityVWDAO snapshotEntityVWDAO) {
		this.snapshotEntityVWDAO = snapshotEntityVWDAO;
	}

	public List<SwitchPortVW> searchSwitchPortByCond(
			SnapshotRelationSearchCond cond) {
		
		return snapshotEntityVWDAO.findSwitchPortByCond(cond);
	}

	public List<SwitchZoneVW> searchSwitchZoneByCond(
			SnapshotRelationSearchCond cond) {
		
		return snapshotEntityVWDAO.findSwitchZoneByCond(cond);
	}
	 /**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SnapshotRelationTB> searchSwitchRelationByCond(SnapshotRelationSearchCond cond1,SnapshotRelationSearchCond cond2){
		return snapshotEntityVWDAO.findSwitchRelationByCond(cond1, cond2);
	}


}