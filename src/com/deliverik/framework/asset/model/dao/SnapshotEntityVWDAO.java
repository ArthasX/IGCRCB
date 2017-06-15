package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.SwitchPortVW;
import com.deliverik.framework.asset.model.SwitchZoneVW;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.entity.ShowEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 资产项视图DAO接口
 * 
 * @author 
 */
public interface SnapshotEntityVWDAO extends BaseHibernateDAO<SnapshotEntityVW> {
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SnapshotEntityVW> findByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ShowEntityVW> findDiskByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> findDaByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> findFaByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SwitchZoneVW> findSwitchZoneByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SwitchPortVW> findSwitchPortByCond(final SnapshotRelationSearchCond cond);	
    
    /**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SnapshotRelationTB> findSwitchRelationByCond(final SnapshotRelationSearchCond cond1,final SnapshotRelationSearchCond cond2);

}
