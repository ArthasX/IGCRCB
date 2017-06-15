/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT03DTO;

/**
 * 概述: 报表统计接口
 * 功能描述: 报表统计接口
 * 创建记录: 2012/07/03
 * 修改记录: 
 */
public interface IGRPT03BL extends BaseBL {

	/**初始化报表数据*/
	public IGRPT03DTO initReport(IGRPT03DTO dto) throws BLException;
	
	/**初始化主机查询数据*/
	public IGRPT03DTO initHostSearch(IGRPT03DTO dto) throws BLException;
	
	/**容量路径转向*/
	public IGRPT03DTO capacityBirtForm(IGRPT03DTO dto) throws BLException;
}
