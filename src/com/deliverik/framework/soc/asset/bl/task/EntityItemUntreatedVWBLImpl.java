/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;
import com.deliverik.framework.soc.asset.model.dao.EntityItemUntreatedVWDAO;


/**
 * 概述:未上架机柜、空调、ups视图BL实现
 * 功能描述: 未上架机柜、空调、ups视图BL实现
 * 创建人：付彬
 * 创建记录: 2013/07/03
 * 修改记录: 
 */

public class EntityItemUntreatedVWBLImpl implements EntityItemUntreatedVWBL {

	/** 发票管理导出视图DAO */
	protected EntityItemUntreatedVWDAO entityItemUntreatedVWDAO;

	public void setEntityItemUntreatedVWDAO(
			EntityItemUntreatedVWDAO entityItemUntreatedVWDAO) {
		this.entityItemUntreatedVWDAO = entityItemUntreatedVWDAO;
	}
	
	
	/**
	 * 未上架机柜、空调、ups列表取得
	 *
	 * @return list 检索结果列表
	 */
	public List<EntityItemUntreatedVWInfo> getToolsData(){
		return entityItemUntreatedVWDAO.getToolsData();
	}
}
