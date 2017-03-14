/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public interface IGDRM15BL extends BaseBL {
	
	/**
     * @Description: 查询培训计划所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO searchTrainplanList(IGDRM15DTO dto);
	
	
	/**
	 * @throws BLException 
     * @Description: 查询培训计划和培训任务所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
//	public IGDRM15DTO getList(IGDRM15DTO dto) throws BLException;
	
	/**
     * @Description: 删除培训计划一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO deleteTrainplanAction(IGDRM15DTO dto) throws BLException;
	/**
     * @Description: 新增培训计划一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO insertTrainplanAction(IGDRM15DTO dto) throws BLException;
	/**
     * @Description:取得培训计划一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO updateTrainPlanMission(IGDRM15DTO dto) throws BLException;
	/**
     * @Description:更新培训计划一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	//public IGDRM15DTO updateTrainplanAction(IGDRM15DTO dto) throws BLException;

	 /**
     * @Description: 培训计划登记/修改/删除
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
  //  public IGDRM15DTO editTrainmissionAction(IGDRM15DTO dto)throws BLException;
	
	/**
     * @Description: 培训计划登记/修改/删除
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM15DTO searchTrainPlanMissionAction(IGDRM15DTO dto)throws BLException;
	
    
    /**
     * 新增培训计划
     * @param igdrm15dto IGDRM15DTO 
     */
    public IGDRM15DTO createTrainingPlan(IGDRM15DTO dto) throws BLException ;

    /**
	 * 培训计划批量删除处理
	 * @param dto IGDRM15DTO
	 * @return IGDRM15DTO
	 */
	public IGDRM15DTO deleteEntityItemAction(IGDRM15DTO dto) throws BLException;
}
