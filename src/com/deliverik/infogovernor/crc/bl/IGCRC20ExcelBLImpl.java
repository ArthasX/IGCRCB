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
import com.deliverik.infogovernor.crc.dto.IGCRC2001ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * 概述:导出年度工作统计
 * 
 */
/**
 * 概述: 年度工作统计导出逻辑实现
 * 创建记录:  lianghongyang 2014-8-11 09:34:11
 * 修改记录: 
 */
public class IGCRC20ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC20ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC20ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================年度工作统计导出开始=================");
		IGCRC2001ExcelDTO exceldto = (IGCRC2001ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		//获取导出内容
		List<IGCRC2002VO> igcrc2002voList = exceldto.getIgcrc2002voList();
		//底排合计List
		List<Integer> sumList=exceldto.getSumList();
		
		for(int i=0;i<igcrc2002voList.size();i++){
			// 获取流程对象
			IGCRC2002VO info = igcrc2002voList.get(i);
			//填充月份
			addCell(0, i, info.getPropentime());
			//填充事件
			addCell(1, i, info.getIncidentnum());
			//填充问题
			addCell(2, i, info.getProblemnum());
			//填充变更
			addCell(3, i, info.getChangenum());
			//填充科技服务请求
			addCell(4, i, info.getServicenum());
			//填充科技开发
			addCell(5, i, info.getSfnum());
			//填充合计
			addCell(6, i, info.getSum());
		}
		addCell(0,igcrc2002voList.size(), "合计");
		//填充最底排合计
		for(int i=0;i<sumList.size();i++){
			// 获取流程对象
			int sum = sumList.get(i);
			addCell(i+1, igcrc2002voList.size(),sum);
		}
		
		log.debug("=================年度工作统计导出开始=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
