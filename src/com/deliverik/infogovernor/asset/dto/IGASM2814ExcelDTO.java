/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;

/**
 * 
 * 概述: 检查项查询导出专用DTO
 * 功能描述: 检查项查询导出专用DTO
 * 创建人：hujuwen
 * 创建记录: 2014/07/23
 * 修改记录:
 */
public class IGASM2814ExcelDTO extends ExcelDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8455652362708332682L;
	
	/**检查项查询集合*/
	private  List<CheckItemVWInfo> itemList;
	/**检查项查询集合 获得
	 * @return list
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}
	/**检查项查询集合 设定*/
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

}
