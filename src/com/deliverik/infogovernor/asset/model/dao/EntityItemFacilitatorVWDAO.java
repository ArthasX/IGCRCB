/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;
/**
 * 概述:服务商信息视图DAO接口
 * 功能描述: 服务商信息视图DAO接口
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录: 
 */
public interface EntityItemFacilitatorVWDAO extends BaseHibernateDAO<EntityItemFacilitatorVWInfo> {

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EntityItemFacilitatorVWInfo> findByCond(final EntityItemFacilitatorVWSearchCond cond);
}
