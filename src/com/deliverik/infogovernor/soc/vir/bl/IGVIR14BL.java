/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR14DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR14BL extends BaseBL{

    /**
     * 查询未关闭的运维流程和资源管理流程数量
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO getProcessCountAction(IGVIR14DTO dto) throws BLException;
    
    /**
     * 查询未关闭的运维流程和资源申请流程列表
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchProcessList(IGVIR14DTO dto) throws BLException;
    
    /**
     * 获取主机下虚机的个数
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO getVMCount4HostActon(IGVIR14DTO dto) throws BLException;
    
    /**
     * 资源申请统计数据查询
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVMApplyStatisticsDataAction(IGVIR14DTO dto) throws BLException;

    /**
     * 初始化连接信息
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVCenterConnectionAction(IGVIR14DTO dto) throws BLException;

    /**
     * Host信息查询
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchHostInfosAction(IGVIR14DTO dto) throws BLException;

}
