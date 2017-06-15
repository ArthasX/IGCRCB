/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC10DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更处理BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGCRC10BL extends BaseBL{

	/**
	 * 导出变更管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC10DTO getExcelDataList(IGCRC10DTO dto) throws BLException ;

	/**
	 * 主流程信息取得操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC10DTO getParentProcessInfoAction(IGCRC10DTO dto) throws BLException;
}
