/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;


/**
 * @功能描述：风险指标自定义查询
 * @创建者： hujuwen
 * @创建时间：2014/07/26
 * 
 * @Version V1.0
 */
public interface IGASM3101ExcelBL extends ExcelBaseBL{
	
	/**
	 * 风险指标自定义查询
	 * 
	 * @rerturn dto
	 */
	public IGASM31DTO searchRiskPointManagerAction(IGASM31DTO dto)
			throws BLException;

}
