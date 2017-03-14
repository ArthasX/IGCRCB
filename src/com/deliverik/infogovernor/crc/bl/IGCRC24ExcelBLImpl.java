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
import com.deliverik.infogovernor.crc.dto.IGCRC2401ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * 概述:导出事件平均解决时间BL 
 * 
 */
public class IGCRC24ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC24ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC24ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================部门提交统计导出开始=================");
		IGCRC2401ExcelDTO exceldto = (IGCRC2401ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		//获取导出内容
		List<IGCRC2402VO> igcrc2402voList = exceldto.getIgcrc2402voList();
		
		for(int i=0;i<igcrc2402voList.size();i++){
			//获取流程对象
			IGCRC2402VO info = igcrc2402voList.get(i);
			//名称
			addCell(0, i, info.getName());
			//事件级别1
			addCell(1, i, info.getGrade5Str());
			//事件级别2
			addCell(2, i, info.getGrade4Str());
			//事件级别3
			addCell(3, i, info.getGrade3Str());
			//事件级别4
			addCell(4, i, info.getGrade2Str());
			//事件级别5
			addCell(5, i, info.getGrade1Str());
			//事件数量
			addCell(6, i, info.getPridNUM());
//			//事件级别6
//			addCell(6, i, info.getGrade6());
//			//事件级别7
//			addCell(7, i, info.getGrade7());
//			//事件级别8
//			addCell(8, i, info.getGrade8());
		}
		
		log.debug("=================部门提交统计导出开始=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
