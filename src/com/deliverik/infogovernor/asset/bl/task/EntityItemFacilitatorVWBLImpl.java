/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.EntityItemFacilitatorVWDAO;

/**
 * 概述:服务商信息视图BL实现
 * 功能描述: 服务商信息视图BL实现
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录: 
 */
public class EntityItemFacilitatorVWBLImpl extends BaseBLImpl implements
		EntityItemFacilitatorVWBL {
	
	/** 服务商信息视图DAO */
	protected EntityItemFacilitatorVWDAO entityItemFacilitatorVWDAO;

	public void setEntityItemFacilitatorVWDAO(
			EntityItemFacilitatorVWDAO entityItemFacilitatorVWDAO) {
		this.entityItemFacilitatorVWDAO = entityItemFacilitatorVWDAO;
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EntityItemFacilitatorVWInfo> findByCond(final EntityItemFacilitatorVWSearchCond cond){
		return entityItemFacilitatorVWDAO.findByCond(cond);
	}
}
