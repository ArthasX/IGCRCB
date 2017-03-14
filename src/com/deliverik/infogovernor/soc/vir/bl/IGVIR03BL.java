/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR03DTO;

/**
 * 虚拟化资源调整业务逻辑接口
 *
 * 
 */
public interface IGVIR03BL extends BaseBL {
    
    /**
     * 查询项目列表
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO searchProjectList(IGVIR03DTO dto) throws BLException;
    
    /**
     * 获取申请项目虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO getApplyVMInf(IGVIR03DTO dto) throws BLException;
    
    /**
     * 保存调整后的虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR03DTO saveApplyVMInfo(IGVIR03DTO dto) throws BLException;
}
