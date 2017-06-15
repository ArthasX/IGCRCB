/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;


/**
 * @功能描述：风险点自定义查询
 * @创建者： hujuwen
 * @创建时间：2014/07/22
 * 
 * @Version V1.0
 */
public interface IGASM2714ExcelBL extends ExcelBaseBL{
	
	/**
	 * 风险点自定义查询
	 * 
	 * @rerturn dto
	 */
	public IGASM27DTO searchRiskPointManagerAction(IGASM27DTO dto)
			throws BLException;

}
