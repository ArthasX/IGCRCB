/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT01DTO;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 值班管理_值班检查设定_BL
 * </p>
 * 
 * @version 
 */
public interface IGDUT01BL extends BaseBL{
	/**
	 * 
	 * Description: 值班检查信息查询
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGDUT01DTO searchDutyAuditDefAction(IGDUT01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 值班检查信息设定
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT01DTO insertDutyAuditDefAction(IGDUT01DTO dto) throws BLException;
	


	/**
	 * 
	 * Description: 值班检查信息变更
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT01DTO updateDutyAuditDefAction(IGDUT01DTO dto) throws BLException ;
	
	/**
	 * 状态更新初期显示
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGDUT01DTO initDutyAuditDef(IGDUT01DTO dto) throws BLException ;

	/**
	 * 状态更新处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGDUT01DTO changeDutyAuditDefAction(IGDUT01DTO dto) throws BLException ;
}