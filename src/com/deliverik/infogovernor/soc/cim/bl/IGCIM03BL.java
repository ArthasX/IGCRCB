/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
/**
 * 概述: 资产审计业务逻辑接口
 * 功能描述: 资产审计业务逻辑接口
 * 创建记录: 2111/04/25
 * 修改记录: 
 */
public interface IGCIM03BL extends BaseBL{

	/**
	 * 控制台显示处理
	 *
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0301Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO deleteAuditWaitTaskAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO importIGCIM0301Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 控制台对比处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO compareIGCIM0301Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 控制台任务查看处理
	 *
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0303Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 审计对比结果查询处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditResultAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 审计对比结果保存处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGCIM03DTO dto) throws BLException;

	/**
	 * 审计任务登记处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO insertAuditTaskAction(IGCIM03DTO dto) throws BLException;

	/**
	 * 审计任务查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskAction(IGCIM03DTO dto) throws BLException;

	/**
	 * 审计任务查询处理（弹出页）
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskActionForChoose(IGCIM03DTO dto) throws BLException;

	/**
	 * 审计任务变更初期显示
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0305Action(IGCIM03DTO dto) throws BLException;

	/**
	 * 审计任务变更处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateAuditTaskAction(IGCIM03DTO dto) throws BLException;

	/**
	 * 设备信息查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchEntityItemAction(IGCIM03DTO dto) throws BLException;

	/**
	 * 设备详细信息查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0309Action(IGCIM03DTO dto) throws BLException;

	/**
	 * 设备影响范围查询处理
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0308Action(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 资产更新处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateEntityAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 升级顶级CI(调用关系及升级bat)
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
//	public IGCIM03DTO rootMarkUpdateAction(IGCIM03DTO dto) throws BLException;
	
	/**
	 * 审计对比结果查询处理
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchIGCIM0302Action(IGCIM03DTO dto) throws BLException;
}
