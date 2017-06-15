/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.prm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;

public interface IGPRM01BL {
	public IGPRM01DTO insertProcessTemplate(IGPRM01DTO dto) throws BLException;

	public IGPRM01DTO findAllProcessTemplate(IGPRM01DTO dto) throws BLException;

	public IGPRM01DTO changePTStatus(IGPRM01DTO dto) throws BLException;

	public IGPRM01DTO getAllActiveTemplate(IGPRM01DTO dto) throws BLException;

	public IGPRM01DTO insertProcessDefinition(IGPRM01DTO dto)
			throws BLException;

	public IGPRM01DTO findAllProcessDefinition(IGPRM01DTO dto)
			throws BLException;

	public IGPRM01DTO findProcessDefinition(IGPRM01DTO dto) throws BLException;

	public IGPRM01DTO changePDStatus(IGPRM01DTO dto) throws BLException;

	public IGPRM01DTO insertProcessInfoDef(IGPRM01DTO dto) throws BLException;

	public IGPRM01DTO findAllProcessInfoDef(IGPRM01DTO dto)
			throws BLException;

	public IGPRM01DTO deleteProcessInfoDef(IGPRM01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 缺省审批人初始化
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGPRM01DTO initApprovors(IGPRM01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 添加缺省审批人
	 * </p>
	 * 
	 * @param dto IGSVC04DTO
	 * @return IGSVC04DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */

	public IGPRM01DTO addApprovors(IGPRM01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 删除审批人
	 * </p>
	 * 
	 * @param dto IGSVC04DTO
	 * @return IGSVC04DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */

	public IGPRM01DTO removeApprovors(IGPRM01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 缺省审批分派人初始化
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGPRM01DTO initApproveDispatcher(IGPRM01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 添加缺省审批分派人
	 * </p>
	 * 
	 * @param dto IGSVC04DTO
	 * @return IGSVC04DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */

	public IGPRM01DTO addApproveDispatcher(IGPRM01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 删除审批分派人
	 * </p>
	 * 
	 * @param dto IGSVC04DTO
	 * @return IGSVC04DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	public IGPRM01DTO removeApproveDispatcher(IGPRM01DTO dto)
			throws BLException;
	
	public IGPRM01DTO findPurviewProcessDefinition(IGPRM01DTO dto) throws BLException;
}
