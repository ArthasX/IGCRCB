/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1306ExcelDTO;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;

/**
 * 概述:导出部门提交统计BL 
 * 创建记录：王楠 2014/07/25
 */
public class IGCRC14ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC14ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC14ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================部门提交统计导出开始=================");
		IGCRC1306ExcelDTO exceldto = (IGCRC1306ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		List<DepartModelVW> list = exceldto.getListVM();
		for(int i=0;i<list.size();i++){
			DepartModelVW info = list.get(i);
			addCell(0, i, info.getEiname());
			addCell(1, i, info.getDowSum());
			addCell(2, i, info.getReadSum());
		}
		log.debug("=================部门提交统计导出开始=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
