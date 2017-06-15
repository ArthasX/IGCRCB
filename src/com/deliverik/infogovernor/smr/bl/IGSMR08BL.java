/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;

/**
 * 概述:填报质量考核 
 * 功能描述：填报质量考核
 * 创建人：赵梓廷
 * 创建记录： 2013-09-02
 * 修改记录：
 */
public interface IGSMR08BL extends BaseBL {

	/**
	 * 
	 *描述：按部门考核
	 *时间：2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	IGSMR08DTO initSMR0801ByOrgAction(IGSMR08DTO dto) throws BLException;
	
	/**
	 * 
	 *描述：按人员考核
	 *时间：2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	IGSMR08DTO initSMR0801ByUserAction(IGSMR08DTO dto) throws BLException;
	
	/**
	 * 监控报表详细页 信息查询
	 * @param dto
	 * @return
	 */
	public IGSMR08DTO searchListForDetailAction(IGSMR08DTO dto) throws BLException;
	
	/**
	 * 核心网络系统运行情况统计初始化查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGSMR08DTO searchIGSMR0804Action(IGSMR08DTO dto) throws BLException;
	
	/**
	 * 网上银行系统运行情况统计初始化查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGSMR08DTO searchIGSMR0805Action(IGSMR08DTO dto) throws BLException;
	
	/**
	 * 银行卡系统运行情况统计初始化查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGSMR08DTO searchIGSMR0806Action(IGSMR08DTO dto) throws BLException;
}
