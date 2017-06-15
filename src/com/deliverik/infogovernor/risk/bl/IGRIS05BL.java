/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.risk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS05DTO;
/**
 * @Description: 检查问题查询
 * @Author  
 * @20140709     新建 
 * @Version V1.0
 */
public interface IGRIS05BL extends BaseBL {

	/**检查问题报表查询*/
	public IGRIS05DTO searchRiskCount(IGRIS05DTO dto) throws BLException;
}
