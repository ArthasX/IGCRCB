/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;


/**
 * @功能描述：检查项自定义查询
 * @创建者： hujuwen
 * @创建时间：2014/07/23
 * 
 * @Version V1.0
 */
public interface IGASM2814ExcelBL extends ExcelBaseBL{
	
	/**
	 * 检查项自定义查询
	 * 
	 * @rerturn dto
	 */
	public IGASM28DTO searchCheckItemListAction(IGASM28DTO dto)
			throws BLException;

}
