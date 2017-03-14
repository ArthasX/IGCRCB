/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;

/**
 * 统计分析业务逻辑接口
 *
 */
public interface IGCOM02BL extends BaseBL {
	
	/**
	 * 报表分类树查询处理
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	public IGCOM02DTO searchReportTypeTreeAction(IGCOM02DTO dto) throws BLException;
	
	/**
	 * 报表信息查询处理
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	public IGCOM02DTO searchReportFileDefinitionAction(IGCOM02DTO dto) throws BLException;
	
	/**
	 * 报表授权过滤树查询
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGCOM02DTO filterReportTypeTreeAction(IGCOM02DTO dto) throws BLException;
	
	/**
	 * 应用管理首页显示查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCOM02DTO searchIgcom0218Action(IGCOM02DTO dto)throws BLException;
	
}
