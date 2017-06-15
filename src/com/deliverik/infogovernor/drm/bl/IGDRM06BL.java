/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM06DTO;

/**
 * 演练计划BL 
 * 2015-2-12 上午11:02:20
 */

public interface IGDRM06BL extends BaseBL {
    /**
     * @Description: 演练计划显示 
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO initIGDRM0601Action(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: 演练计划查询
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO searchIGDRM0602Action(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: 演练计划送审
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO drillplanToJudgeAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: 演练计划审批
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO drillplanJudgeAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: 演练计划登记
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO insertDrillplanAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: 演练计划删除
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO deleteDrillplanAction(IGDRM06DTO dto)throws BLException;
    /**
     * @Description: 演练计划条目初始化
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO initDrillPlanItemAction(IGDRM06DTO dto)throws BLException;
    
    /**
     * @Description: 演练计划条登记/修改/删除
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO editDrillPlanItemAction(IGDRM06DTO dto)throws BLException;
    
    /**
     * @Description: 演练计划条目视图查询 （用于流程显示）
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM06DTO searchDrillPlanItemVWAction(IGDRM06DTO dto)throws BLException;
    /** 
     * @Title: searchDrillPlanVWAction 
     * @Description: TODO 演练查询 整合演练和条目
     * @param dto
     * @return    
     * IGDRM06DTO    
     * @throws 
     */
    public IGDRM06DTO searchDrillPlanVWAction(IGDRM06DTO dto)throws BLException;
    
}
