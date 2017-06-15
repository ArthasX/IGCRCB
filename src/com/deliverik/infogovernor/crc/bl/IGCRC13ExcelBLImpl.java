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
import com.deliverik.infogovernor.crc.dto.IGCRC1305ExcelDTO;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

/**
 * 概述:导出文档存量统计BL 
 * 创建记录：王楠 2014/07/25
 */
public class IGCRC13ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC13ExcelBL {
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC13ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * 编写EXCEL文件内容
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================文档存量统计导出开始=================");
		IGCRC1305ExcelDTO exceldto = (IGCRC1305ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		List<ModelVW> list = exceldto.getListVM();
		for(int i=0;i<list.size();i++){
			ModelVW info = list.get(i);
			addCell(0, i, info.getType());
			addCell(1, i, info.getWordSum());
		}
		log.debug("=================文档存量统计导出开始=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
