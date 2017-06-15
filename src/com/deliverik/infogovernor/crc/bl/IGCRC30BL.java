/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC30DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 对外服务导出BL接口
 * </p>
 * 
 * @author zhangxinru
 * @version 1.0
 */
public interface IGCRC30BL extends BaseBL{

	/**
	 * 导出对外服务管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC30DTO getExcelDataList(IGCRC30DTO dto) throws BLException ;
}
