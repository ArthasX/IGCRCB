/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;

/**
 * 概述:季报审批
 * 功能描述：季报审批
 * 创建人：赵梓廷
 * 创建记录： 2013-08-08
 * 修改记录：
 */
public interface IGSMR06BL extends BaseBL {

	/**
	 * 季报报发起处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR06DTO insertSMR0601Action(IGSMR06DTO dto) throws BLException;
	
	/**
	 * 季报填报查询
	 *
	 */
	public IGSMR06DTO needMeManagerAction(IGSMR06DTO dto)throws BLException;
	
	/**
	 * 查询报表审批
	 *
	 */
	public IGSMR06DTO reportExamineAction(IGSMR06DTO dto)throws BLException;
	
	/**
	 * 查询年报审批
	 *
	 */
	public IGSMR06DTO AnnualreportExamineAction(IGSMR06DTO dto);
	
	/**
	 * 填报查看
	 *
	 */
	public IGSMR06DTO seeFillInAction(IGSMR06DTO dto)throws BLException;
	
	/**
	 * 填报中止
	 *
	 */
	public IGSMR06DTO stopFillInAction(IGSMR06DTO dto)throws BLException;
	
	
	/**
	 * 催办
	 *
	 */
	public IGSMR06DTO pressAction(IGSMR06DTO dto)throws BLException;	

	/**
	 * 季报明细列表查询处理
	 *
	 * @param dto IGSMR06DTO
	 * @return IGSMR06DTO
	 */
	public IGSMR06DTO initIGSMR0604Action(IGSMR06DTO dto) throws BLException;
	
	/**
	 * 季报审批处理
	 *
	 * @param dto IGSMR06DTO
	 * @return IGSMR06DTO
	 */
	public IGSMR06DTO managerIGSMR0604Action (IGSMR06DTO dto) throws BLException;
	
}
