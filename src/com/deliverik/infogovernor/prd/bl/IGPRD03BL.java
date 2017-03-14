/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:流程组定义工具BL接口
 * </p>
 * 
 * @version 1.0
 */
public interface IGPRD03BL extends BaseBL{

	
	/**
	 * 查询流程组定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD03DTO searchProcessGroupDefinition(IGPRD03DTO dto) throws BLException;
	
	/**
	 * 流程组升级
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO upgradeProcessGroupDefinition(IGPRD03DTO dto)throws BLException;
	
	/**
	 * 保存流程组定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO regProcessGroupDefinition(IGPRD03DTO dto)throws BLException;
	
	/**
	 * 流程组编辑页面初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO initPGDforEdit(IGPRD03DTO dto)throws BLException;
	
	/**
	 * 流程组关联流程定义页面初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO initPGDRelition(IGPRD03DTO dto)throws BLException;
	
	/**
	 * 添加流程组内成员流程定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO addMember(IGPRD03DTO dto)throws BLException;
	
	/**
	 * 删除流程组内成员流程定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO delMember(IGPRD03DTO dto)throws BLException;
	
	/**
	 * 修改流程组状态
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO changeStatus(IGPRD03DTO dto) throws BLException;
	
	/**
	 * 流程组发起
	 * @param dto IGPRD03DTO
	 * @return IGPRD03DTO
	 * @throws BLException
	 */
	public IGPRD03DTO LaunchAction(IGPRD03DTO dto) throws BLException;

    /** 
     * @Title: flexUploadFile 
     * @Description:  flex或其他流形式上传附件逻辑 
     * @param dto    
     * void    
     * @throws 
     */
    public void flexUploadFile(IGPRD03DTO dto)throws Exception;
}
