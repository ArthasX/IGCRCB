/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
/**
 * 概述: 资产审计业务逻辑接口
 * 功能描述: 资产审计业务逻辑接口
 * 创建记录: 2111/04/25
 * 修改记录: 
 */
public interface IGASM21BL extends BaseBL{

	/**
	 * 控制台显示处理
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2101Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO deleteAuditWaitTaskAction(IGASM21DTO dto) throws BLException;
	
	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO importIGASM2101Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * 控制台对比处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO compareIGASM2101Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * 控制台任务查看处理
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2103Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * 审计对比结果查询处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditResultAction(IGASM21DTO dto) throws BLException;
	
	/**
	 * 审计对比结果保存处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGASM21DTO dto) throws BLException;

	/**
	 * 审计任务登记处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO insertAuditTaskAction(IGASM21DTO dto) throws BLException;

	/**
	 * 审计任务查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskAction(IGASM21DTO dto) throws BLException;

	/**
	 * 审计任务查询处理（弹出页）
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskActionForChoose(IGASM21DTO dto) throws BLException;

	/**
	 * 审计任务变更初期显示
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2105Action(IGASM21DTO dto) throws BLException;

	/**
	 * 审计任务变更处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateAuditTaskAction(IGASM21DTO dto) throws BLException;

	/**
	 * 设备信息查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchEntityItemAction(IGASM21DTO dto) throws BLException;

	/**
	 * 设备详细信息查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2109Action(IGASM21DTO dto) throws BLException;

	/**
	 * 设备影响范围查询处理
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2108Action(IGASM21DTO dto) throws BLException;
	
	/**
	 * 资产更新处理
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateEntityAction(IGASM21DTO dto) throws BLException;
	
	/**
	 * 升级顶级CI(调用关系及升级bat)
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
//	public IGASM21DTO rootMarkUpdateAction(IGASM21DTO dto) throws BLException;
}
