/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM11DTO;

/**
 * @概述 全网IP过滤处理BL
 * @功能描述 1.
 * @创建记录：2012/11/07
 * @version 1.0
 */

public interface IGDBM11BL extends BaseBL {


    /** IP信息查询
     * @param dto
     */
    public IGDBM11DTO searchIp_FilterInfo(IGDBM11DTO dto) throws BLException;

    /**
     * 新增IP过滤信息
     * @param dto
     */
    public IGDBM11DTO addIpFilterInfo(IGDBM11DTO dto) throws BLException;

    /**
     * 删除IP过滤信息
     * @param dto
     */
    public IGDBM11DTO delIpFilterInfo(IGDBM11DTO dto) throws BLException;
    
    /**
     * 批量删除IP过滤信息
     * @param dto
     */
    public IGDBM11DTO BatchdelIpFilterInfo(IGDBM11DTO dto) throws BLException;
}
