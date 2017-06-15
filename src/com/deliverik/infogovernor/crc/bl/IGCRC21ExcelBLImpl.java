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
import com.deliverik.infogovernor.crc.dto.IGCRC2101ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**
 * 
 *
 */
/**	
 * 概述:人员工作统计导出业务逻辑实现
 * 创建记录：yukexin    2014-8-15 下午5:10:31	
 * 修改记录：null
 */	
public class IGCRC21ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC21ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory
			.getLog(IGCRC21ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================人员工作统计查询结果导出处理开始=================");
		// 实例化DTO
		IGCRC2101ExcelDTO exceldto = (IGCRC2101ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获得查询到的list集合
		List<IGCRC2102VO> processList = exceldto.getIgcrc2102voList();
		List<Integer> listSum = exceldto.getListSum();
		// 写入各个单元格
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// 获取对象
				IGCRC2102VO info = processList.get(i);
				// 人员名字
				addCell(0, i, info.getUserName());
				// 事件个数
				addCell(1, i, info.getIncidentNum());
				// 问题个数
				addCell(2, i, info.getProblemNum());
				// 变更个数
				addCell(3, i, info.getChangeNum());
				// 服务请求个数
				addCell(4, i, info.getServiceNum());
				// 服务请求个数
				addCell(5, i, info.getDevelopNum());
				// 合计个数
				addCell(6, i, info.getTotal());
			}
			// 合计
			addCell(0, processList.size(), "合计");
			for(int i = 0; i < listSum.size(); i++){
				addCell(i + 1, processList.size(), listSum.get(i));
			}
		}

		log.debug("=================人员工作统计查询结果导出处理结束=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}
	
}
