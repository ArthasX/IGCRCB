/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.framework.base.ExcelDTO;

/**
 * 
 * 概述: 资产自定义报表业务逻辑接口
 * 功能描述: 资产自定义报表业务逻辑接口
 * 创建记录: 2013/12/27
 * 修改记录:
 */
public interface IGCIM1102ExcelBL extends ExcelBaseBL{
	
	/**
	 * 初始化Excel
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException;
	
}
