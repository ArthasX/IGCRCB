/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC14DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更流程查询BL接口
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
public interface IGCRC14BL extends BaseBL{

	/**
	 * 查询变更流程
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO searchEntityItemAction(IGCRC14DTO dto) throws BLException;
	
	/**
	 * 根据PDID获取启用的流程PDID
	 */
	public IGCRC14DTO searchPdid7BitAction(IGCRC14DTO dto) throws BLException;
	/**
	 * 导出变更管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO getExcelDataList(IGCRC14DTO dto) throws BLException;
}
