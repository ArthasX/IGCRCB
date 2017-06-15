/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;


/**	
 * 概述:人员工作查询controlBL接口
 * 功能描述：1.查询人员工作信息列表	
 * 创建记录：yukexin    2014-8-7 09:28:50
 *         	
 */
public interface IGCRC21BL {
	/**	
	 * 功能：人员工作信息查询处理
	 * @param dto
	 * @return 人员工作信息dto
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGCRC2101DTO searchEntityItemAction(IGCRC2101DTO dto) throws BLException;
	
	/**	
	 * 功能：查询部门下拉列表
	 * @param dto
	 * @return IGCRC2101DTO
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGCRC2101DTO searchDepartmentBeanList(IGCRC2101DTO dto) throws BLException;
	
}
