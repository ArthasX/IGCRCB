/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM26DTO;

/**
 * @author Administrator
 *
 */
/**
 * 概述: 服务商资源池统计业务逻辑接口
 * 功能描述：服务商资源池统计业务逻辑接口
 * 创建人：赵敏
 * 创建记录： 2012-8-3
 * 修改记录：
 */
public interface IGASM26BL extends BaseBL {

	/**
	 * 服务商资源池统计处理
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 */
	public IGASM26DTO searchEntityItemRelationVW(IGASM26DTO dto) throws BLException;
}
