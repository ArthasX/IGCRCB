/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM41DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface IGASM41BL extends BaseBL {
	/**
	 * 风险检查统计查询处理
	 *
	 * @param dto IGASM41DTO
	 * @return IGASM41DTO
	 */
	public IGASM41DTO searchEntityItemAction(IGASM41DTO dto) throws BLException;
}
