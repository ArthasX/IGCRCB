/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;

/**
 * 报表信息业务逻辑接口
 *
 */
public interface IGSYM14BL extends BaseBL {
	
	/**
	 * 报表信息查询处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileDefinitionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * 报表信息登记处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO insertReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * 报表信息变更初始化
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO initReportFileDefinitionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * 报表信息变更
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGSYM14DTO editReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * 报表信息删除处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO deleteReportFileDefinitionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * 报表版本升级处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO insertReportFileVersionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * 报表版本信息查询处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileVersionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * 指定当前版本处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO assignCurrentReportFileVersionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * 取得报表显示名称
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO getReportTitle(IGSYM14DTO dto) throws BLException;
	
	/**
	 * 取得对象名
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO getObjectName(IGSYM14DTO dto) throws BLException;

	/**
	 * 获取流程类型
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO searchPrtypeAndRfdFilenameList(IGSYM14DTO dto) throws BLException;
}
