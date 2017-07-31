/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.bl;

import java.text.ParseException;

import org.springframework.beans.BeansException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;

/**
 * @Description 工作项管理BL接口
 * 
 * @date 2017年6月9日16:12:59
 * 
 * @author WangLiang
 *
 */
public interface IGWIM01BL extends BaseBL{

	/**
	 * @Description 工作项定义登记
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkDefinitionAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 工作项更新
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO updateWorkDefinitionAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 工作项新增初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWIM01DTO workDefinitionInitAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 工作实例定时任务管理/更新
	 * @param dto IGWIM01DTO 参数 WorkDefinitionInfo信息；addOrRemoveFlag：工作项定时任务添加/移除标识addOrRemoveFlag
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO jobManageAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 工作项查询
	 * @param dto
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO searchWorkDefinition(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 工作项信息删除处理
	 * @param dto IGWIM01DTO
	 * @return IGRIS06DTO
	 * @throws BLException
	 */
	public IGWIM01DTO deleteWorkDefinitoinAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 工作项状态修改
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO updateWorkDefinitionStatusAction(IGWIM01DTO dto) throws BLException, BeansException, ParseException;
	
	/**
	 * @Description 发起工作实例
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkInstanceAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 新增工作日志
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkLogAction(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 工作项数据导入
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO importData(IGWIM01DTO dto) throws BLException;
	
	/**
	 * @Description 查询用户是否是中心负责人以上岗位
	 * @param dto IGWIM01DTO userid:用户id
	 * @return IGWIM01DTO
	 */
	public IGWIM01DTO searchIsLeader(IGWIM01DTO dto) throws BLException;
}
