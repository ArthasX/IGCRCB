/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;

/**
 * 流程关系实体DAO接口
 * 
 */
public interface EmergencyRelationDAO extends BaseHibernateDAO<EmergencyRelationInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<EmergencyRelationInfo> findAll();

	/**
	 * 主键检索处理
	 * @param prrid 主键
	 * @return 检索结果
	 */
	public EmergencyRelationInfo findByPK(Serializable prrid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EmergencyRelationSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EmergencyRelationInfo> findByCond(final EmergencyRelationSearchCond cond, final int start, final int count);

	
}
