/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM18DTO;

/**
 * <p>
 * Title : InfoGovernor 应急管理
 * </p>
 * <p>
 * Description:统计分析BL接口
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
public interface IGDRM18BL extends BaseBL {

	/**
	 * 应急预案统计查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO getPlanRate(IGDRM18DTO dto)throws BLException;
	
	/**
	 * 演练统计查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO getDrillRate(IGDRM18DTO dto)throws BLException;
	
	
	/**
	 * 预案砖取
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM18DTO searchPlanInfo(IGDRM18DTO dto) throws BLException;
	
}
