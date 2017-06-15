/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.bl;


import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_服务台业务逻辑接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSVC01BL extends BaseBL {
	
	/**
	 * <p>
	 * 我的发起，获取用户发起的未关闭的流程
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkInitByMe(IGSVC01DTO dto) throws BLException;
	/**
	 * <p>
	 * 我的发起，获取用户发起的所有流程
	 * </p>
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 */
	public IGSVC01DTO getWorkInitByMeForAll(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 相关发起，获取用户被授予的角色发起的未关闭的流程
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkInitByMyManyRole(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 相关工作，获取指定用户被授予的角色处理的未关闭的流程
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkAssignedToMyManyRole(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 我的工作，获取指定用户处理的未关闭的流程
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkAssignedToMe(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 工作监督，获取所有未关闭的流程
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getAllActiveProcessRecords(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询流程记录
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecords(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询流程记录
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecordsForLook(IGSVC01DTO dto) throws BLException;

	
	/**
	 * <p>
	 * 查询历史工作
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author zhaojun@deliverik.com
	 */
	
	public IGSVC01DTO getDoneProcessRecordsForLook(IGSVC01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询流程记录(知识入库使用)
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecordsForKGM(IGSVC01DTO dto) throws BLException;

	/**
	 * 中止工作查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC01DTO getDiscontinueWork(IGSVC01DTO dto) throws BLException;
	
	public IGSVC01DTO getPrtypeList(IGSVC01DTO dto);
}
