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
import com.deliverik.infogovernor.crc.dto.IGCRC2201ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * 概述:程序开发统计导出业务逻辑实现
 * 创建记录：yukexin    2014-8-15 下午5:11:46	
 * 修改记录：null
 */	
public class IGCRC22ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC22ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory
			.getLog(IGCRC22ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================变更总体统计查询结果导出处理开始=================");
		// 实例化DTO
		IGCRC2201ExcelDTO exceldto = (IGCRC2201ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获得查询到的list集合
		List<IGCRC2202VO> processList = exceldto.getIgcrc2202voList();
		// 写入各个单元格
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// 获取对象
				IGCRC2202VO info = processList.get(i);
				// 分类取得
				addCell(0, i, info.getTypeName());
				// 总数取得
				addCell(1, i, info.getTotalnum());
				// 评审通过数量
				addCell(2, i, info.getPassnum());
				// 评审通过率
				addCell(3, i, info.getPassrate());
				// 成功数量
				addCell(4, i, info.getSuccessnum());
				// 成功率
				addCell(5, i, info.getSuccessrate());
			}
		}

		log.debug("=================变更总体统计查询结果导出处理结束=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}
	
}
