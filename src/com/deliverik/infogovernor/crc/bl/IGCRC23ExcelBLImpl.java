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
import com.deliverik.infogovernor.crc.dto.IGCRC2301ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * 概述:程序开发统计导出业务逻辑实现
 * 创建记录：yukexin    2014-8-15 下午5:12:20	
 * 修改记录：null
 */	
public class IGCRC23ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC23ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory
			.getLog(IGCRC23ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================程序开发统计查询结果导出处理开始=================");
		// 实例化DTO
		IGCRC2301ExcelDTO exceldto = (IGCRC2301ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获得查询到的list集合
		List<IGCRC2301VWInfo> processList = exceldto.getIgcrc2301VWList();
		// 写入各个单元格
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// 获取对象
				IGCRC2301VWInfo info = processList.get(i);
				// 人员名字
				addCell(0, i, info.getUserName());
				// 事件个数
				addCell(1, i, info.getDisposeNum());
				// 问题个数
				addCell(2, i, info.getTestUpdateRejectNum());
				// 变更个数
				addCell(3, i, info.getTestRejectNum());
				// 服务请求个数
				addCell(4, i, info.getConfirmRejectNum());
			}
		}

		log.debug("=================程序开发统计查询结果导出处理结束=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}
	
}
