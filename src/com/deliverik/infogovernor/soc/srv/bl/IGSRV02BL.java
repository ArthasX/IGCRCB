/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.bl;


import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.soc.srv.dto.IGSRV02DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:  流程管理_事件业务逻辑接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @History 2010-7-13     0000000: 增加快捷发起事件功能
 *          2010-12-07    yangliang: 增加查询全部流程功能
 * @version 1.0
 */

public interface IGSRV02BL extends BaseBL {
	/**
	 * <p>
	 * Description: 获取事件处理显示状态（处理按钮权限） 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getActionStatus(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取事件处理人 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getImplementors(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取历史记录 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getRecordLogs(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取事件审核人
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getVerifiors(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 删除事件记录
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO delProcessRecord(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 查询事件记录
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecords(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 查询全部流程记录
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecordsAll(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 通过prid来查询流程
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public List<IG500Info> searchProcessRecordByKey(Integer prid) throws BLException;
	/**
	 * <p>
	 * Description: 用户角色查询
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getUserRoles(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 用户非流程角色查询
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesNotInProcess(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取指定事件状态的参与者
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessParticipantsByStatus(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取用户所具有的指定事件的参与者角色
	 * </p>
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesInProcessParticipants(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 查询可以分派的角色
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getDispatchRoles(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 查询事件类别
	 * <p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentCategory(IGSRV02DTO dto) throws BLException;
	/**
	 * 事件紧急程度服务策略查询
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentUrgency(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取未确认参与者
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getConfirmer(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取执行人
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO searchAssignPersonAction(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取流程状态列表
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangshengnan@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinition(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 获取全部流程状态列表
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinitionAll(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 流程状态日志查看 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGSRV02DTO searchRecordStatusLogAction(IGSRV02DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 增加归类字段的处理，不想修改底层，所以此字段的值都添加到标题字段中
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSRV02DTO getSortOrder(IGSRV02DTO dto) throws BLException;
}
