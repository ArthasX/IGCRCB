/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP01BL extends BaseBL{

	/**
	 * 日常工作计划查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 流程类型查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchProcessDefinitions(IGDWP01DTO dto) throws BLException;

	/**
	 * 初始化日常工作计划操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 新增日常工作计划
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO insertDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 日常工作计划修改操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO changeDayWorkPlanAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 策略执行
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO execute(IGDWP01DTO dto) throws BLException;

	/**
	 * 加载流程定义信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initProcessDefinitionAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 策略流程登记操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO craeteProcessAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 日常工作计划分派页初始化操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAssignAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 保存分派信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO saveAssignAction(IGDWP01DTO dto) throws BLException;

	/**
	 * 日常工作计划删除操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO deleteDayWorkPlanAction(IGDWP01DTO dto) throws BLException;
	
	/**
	 * 编辑日常工作计划初始化操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO editDayWorkPlanAction(IGDWP01DTO dto) throws BLException;
}
