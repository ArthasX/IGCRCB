/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.base;

/**
 * 概述: Excel导出通用业务BL接口
 * 功能描述: Excel导出通用业务BL接口
 * 创建记录:
 * 修改记录: 
 */
public interface ExcelBaseBL extends BaseBL {

	/**
	 * 初始化Excel
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException;
	
	/**
	 * 初始化Excel表头内容
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException;
	
	/**
	 * 初始化Excel表主体内容
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException;
	
	/**
	 * 初始化Excel表底部内容
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initFooter(ExcelDTO dto) throws BLException;
	
}
