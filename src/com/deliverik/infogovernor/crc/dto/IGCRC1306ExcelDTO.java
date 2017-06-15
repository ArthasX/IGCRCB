/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;

/**
 * 概述:导出部门提交统计DTO 
 * 创建记录：王楠2014/07/24
 */
public class IGCRC1306ExcelDTO extends ExcelDTO {

	/** 导出内容 */
	protected List<DepartModelVW> ListVM;

	public List<DepartModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<DepartModelVW> listVM) {
		ListVM = listVM;
	}
	
}
