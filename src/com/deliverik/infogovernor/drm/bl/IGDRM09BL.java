package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;


/**
 * 预案管理业务逻辑接口
 *
 *
 */
public interface IGDRM09BL extends BaseBL {
	/**
	 * 根据菜单标识获取菜单名称
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGDRM09DTO dto) throws BLException;
	
	/**
	 * 查询指挥流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM09DTO getProcessRecords(IGDRM09DTO dto) throws BLException;
	/**
	 * 查询流程定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM09DTO getProcessDef(IGDRM09DTO dto) throws BLException;

	/**
	 * @Description: 应急流程弹出查询页
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM09DTO searchProcess(IGDRM09DTO dto)throws BLException;
	
	/**
	 * 初始化组合场相关流程
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM09DTO getGroupSenceInfo(IGDRM09DTO dto)throws BLException;
}
