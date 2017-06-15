package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR11DTO;
/**
 * 月报填报业务逻辑接口
 *
 */
public interface IGSMR11BL extends BaseBL {
	/**
	 * 季报报发起处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR11DTO insertSMR1101Action(IGSMR11DTO dto) throws BLException;
	/**
	 * 季报填报查询
	 *
	 */
	public IGSMR11DTO needMeManagerAction(IGSMR11DTO dto)throws BLException;
	
	/**
	 * 查询报表审批
	 *
	 */
	public IGSMR11DTO reportExamineAction(IGSMR11DTO dto)throws BLException;
	
	/**
	 * 查询年报审批
	 *
	 */
	public IGSMR11DTO AnnualreportExamineAction(IGSMR11DTO dto);
	
	/**
	 * 填报查看
	 *
	 */
	public IGSMR11DTO seeFillInAction(IGSMR11DTO dto)throws BLException;
	
	/**
	 * 填报中止
	 *
	 */
	public IGSMR11DTO stopFillInAction(IGSMR11DTO dto)throws BLException;
	
	
	/**
	 * 催办
	 *
	 */
	public IGSMR11DTO pressAction(IGSMR11DTO dto)throws BLException;	

	/**
	 * 季报明细列表查询处理
	 *
	 * @param dto IGSMR11DTO
	 * @return IGSMR11DTO
	 */
	public IGSMR11DTO initIGSMR1104Action(IGSMR11DTO dto) throws BLException;
	
	/**
	 * 季报审批处理
	 *
	 * @param dto IGSMR11DTO
	 * @return IGSMR11DTO
	 */
	public IGSMR11DTO managerIGSMR1104Action (IGSMR11DTO dto) throws BLException;
	
}
