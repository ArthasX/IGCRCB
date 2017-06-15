/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR02DTO;

/**
 * 虚拟化资源管理业务逻辑接口
 *
 * 
 */
public interface IGVIR02BL extends BaseBL {

    /**
     * 从vCenter上获取虚拟机模板
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getTemplate(IGVIR02DTO dto) throws BLException;
    
    /**
     * 保存申请项目和虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveApplyVMInfo(IGVIR02DTO dto) throws BLException;
    
    /**
     * 获取申请项目虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMInf(IGVIR02DTO dto) throws BLException;
    
    /**
     * 保存申请项目和虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO saveVMInfo4Approve(IGVIR02DTO dto) throws BLException;
    
    /**
     * 根据vCenter id查询host列表
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchHostByVcid(IGVIR02DTO dto) throws BLException;
    
    /**
     * 根据主机查询网络
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByHost(IGVIR02DTO dto) throws BLException;
    
    /**
     * 根据数据中心查询网络
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchNetLabelByDatacenter(IGVIR02DTO dto) throws BLException;
    
    /**
     * 获取申请项目虚机信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO getApplyVMList(IGVIR02DTO dto) throws BLException;
    
    /**
     * 查询数据中心
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDatacenterByVcid(IGVIR02DTO dto) throws BLException;
    
    /**
     * 查询资源池
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchResourcePoolByVcid(IGVIR02DTO dto) throws BLException;
    
    /**
     * 查询虚机部署日志
     * 
     * @return
     * @throws BLException
     */
    public IGVIR02DTO searchDeployLog(IGVIR02DTO dto) throws BLException;
}
