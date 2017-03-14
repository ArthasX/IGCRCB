/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;

/**
 * 风险审计业务逻辑接口
 *
 *	@author liupeng@deliverik.com
 */
public interface IGRIS01BL extends BaseBL {
	
	//-----------------------------------------------------------审计版本----------------------------------------------------------------------
	
	/**
	 * 风险审计信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 风险审计信息登记处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 风险审计信息停用/启用处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditAction(IGRIS01DTO dto) throws BLException;
	
	//-----------------------------------------------------------审计发起----------------------------------------------------------------------
	
	/**
	 * 审计发起信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计发起信息登记处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计发起信息停用/启用处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计发起信息变更处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO updateRiskAuditInsAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计发起信息变更初始化处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0110Action(IGRIS01DTO dto) throws BLException;
	//-----------------------------------------------------------审计项设定---------------------------------------------------------------------
	
	/**
	 * <p>
	 * Description: 审计项新增
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO insertRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	/**
	 * 审计项信息下一级查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefNextAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计项信息全部下级查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefAllAction(IGRIS01DTO dto) throws BLException;
	

	/**
	 * 审计项信息停用/启用处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计项详细信息处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0108Action(IGRIS01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询存在的上级审计项（一级审计项）
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 */
	
	public IGRIS01DTO searchAuditTreeAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 获取已启用的审计版本名称下拉列表
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditLabelInUse(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计项详细信息修改初始化处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	/**
	 * 审计项详细信息修改处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO editRiskAuditDefAction(IGRIS01DTO dto) throws BLException;
	
	//-----------------------------------------------------------审计评估----------------------------------------------------------------------
	/**
	 * 审计评估信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 审计评估初始化
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO initRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 审计评估新增
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO updateRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	/**
	 * 获取已启用的审计批次号下拉列表
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsLabelInUse(IGRIS01DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * Description: 风险检查查询
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckAction(IGRIS01DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: 风险检查结果查询
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckResultAction(IGRIS01DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: 风险检查查看页
	 * </p>
	 */
	
	public IGRIS01DTO initRiskCheckAction(IGRIS01DTO dto) throws BLException;
	//-----------------------------------------------------------审计人----------------------------------------------------------------------
	
	/**
	 * 审计人信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefResultVWAction(IGRIS01DTO dto) throws BLException;
	
	/**
	 * 审计人信息保存处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO saveRiskAuditResultAction(IGRIS01DTO dto) throws BLException;
	
	//-----------------------------------------------------------审计报告----------------------------------------------------------------------
	
	/**
	 * 审计报告信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditReportAction(IGRIS01DTO dto) throws BLException;
	
}
