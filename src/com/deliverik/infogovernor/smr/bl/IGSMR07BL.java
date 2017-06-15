/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;

/**
 * 不定期报表填报业务逻辑接口
 *
 */
public interface IGSMR07BL extends BaseBL{
	
	/**
	 * 
	 *描述：不定期报表发起
	 *时间：2013-8-8上午11:17:44
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	IGSMR07DTO insertSMR0701Action(IGSMR07DTO dto) throws BLException;
	
	/**
	 * 
	 *描述：不定期报表发起页初始化
	 *时间：2013-8-8下午04:45:25
	 * @param dto 
	 *@throws BLException
	 */
	IGSMR07DTO initSMR0701Action(IGSMR07DTO dto)throws BLException;

	/**
	 * 
	 *描述：查询当前参与者要处理的不定期报表
	 *时间：2013-8-8下午11:11:05
	 *@param dto
	 *@return
	 *@throws BLException
	 */
	IGSMR07DTO needMeManagerAction(IGSMR07DTO dto)throws BLException;

	/**
	 * 查询报表审批
	 *
	 */
	public IGSMR07DTO reportExamineAction(IGSMR07DTO dto)throws BLException;
	
	/**
	 * 查询不定期报表审批
	 *
	 */
	public IGSMR07DTO AnnualreportExamineAction(IGSMR07DTO dto);
	
	/**
	 * 填报查看
	 *
	 */
	public IGSMR07DTO seeFillInAction(IGSMR07DTO dto)throws BLException;
	
	/**
	 * 不定期报表明细列表查询处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO initIGSMR0704Action(IGSMR07DTO dto) throws BLException;
	
	/**
	 * 不定期报表审批处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO managerIGSMR0704Action (IGSMR07DTO dto) throws BLException;

}
