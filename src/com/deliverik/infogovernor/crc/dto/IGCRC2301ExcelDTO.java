/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * 概述:程序开发统计导出用DTO
 * 创建记录：yukexin    2014-8-15 下午5:16:12	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2301ExcelDTO extends ExcelDTO{
	
	/** 程序开发信息集合 */
	protected List<IGCRC2301VWInfo> igcrc2301VWList;

	public List<IGCRC2301VWInfo> getIgcrc2301VWList() {
		return igcrc2301VWList;
	}

	public void setIgcrc2301VWList(List<IGCRC2301VWInfo> igcrc2301vwList) {
		igcrc2301VWList = igcrc2301vwList;
	}


	

}
