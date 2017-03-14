/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT04DTO;

/**
 * 概述: 报表统计接口
 * 功能描述: 报表统计接口
 * 创建记录: 2012/07/03
 * 修改记录: 
 */
public interface IGRPT04BL extends BaseBL {

	/**初始化报表数据*/
	public IGRPT04DTO initReport(IGRPT04DTO dto) throws BLException;
	
	/**
     * 报表定义参数信息取得
     * 
     * @param IGRPT04DTO dto
     * @return IGRPT04DTO
     */
    public IGRPT04DTO getCustomConfigurationInfo(IGRPT04DTO dto) throws BLException ;
	
}
