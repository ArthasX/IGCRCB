/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
/**
 * 概述: 资产CI变更业务逻辑接口
 * 功能描述: 资产CI变更业务逻辑接口
 * 创建记录: 2211/04/25
 * 修改记录: 
 */
public interface IGASM22BL extends BaseBL{

	/**
	 * 控制台显示处理
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2201Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO deleteCIWaitTaskAction(IGASM22DTO dto) throws BLException;
	
	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO importIGASM2201Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * 控制台对比处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO compareIGASM2201Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * 控制台任务查看处理
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2203Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * CI变更对比结果查询处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCIResultAction(IGASM22DTO dto) throws BLException;
	
	/**
	 * CI变更对比结果保存处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public void updateCIResultAction(IGASM22DTO dto) throws BLException;

	/**
	 * CI变更任务登记处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO insertCITaskAction(IGASM22DTO dto) throws BLException;

	/**
	 * CI变更任务查询处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCITaskAction(IGASM22DTO dto) throws BLException;

	/**
	 * CI变更任务变更初期显示
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2205Action(IGASM22DTO dto) throws BLException;

	/**
	 * CI变更任务变更处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateCITaskAction(IGASM22DTO dto) throws BLException;

	/**
	 * 设备信息查询处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchEntityItemAction(IGASM22DTO dto) throws BLException;

	/**
	 * 设备详细信息查询处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2209Action(IGASM22DTO dto) throws BLException;

	/**
	 * 设备影响范围查询处理
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2208Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * 资产更新处理
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateEntityAction(IGASM22DTO dto) throws BLException;
	
	/**
	 * 升级顶级CI(调用关系及升级bat)
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO rootMarkUpdateAction(IGASM22DTO dto) throws BLException;
}
