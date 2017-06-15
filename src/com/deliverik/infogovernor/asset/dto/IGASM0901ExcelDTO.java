/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;

/**
 * 
 * 概述: 服务商信息导出用DTO
 * 功能描述: 服务商信息导出用DTO
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录:
 */
@SuppressWarnings("serial")
public class IGASM0901ExcelDTO extends ExcelDTO{
	
	/** 服务商信息视图检索结果 */
	protected List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList;
	
	
	/**
	 * 服务商信息视图检索结果 取得
	 *
	 * @return entityItemFacilitatorList
	 */
	public List<EntityItemFacilitatorVWInfo> getEntityItemFacilitatorList() {
		return entityItemFacilitatorList;
	}
	/**
	 * 服务商信息视图检索结果 设定
	 *
	 * @param entityItemFacilitatorList
	 */
	public void setEntityItemFacilitatorList(
			List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList) {
		this.entityItemFacilitatorList = entityItemFacilitatorList;
	}
}
