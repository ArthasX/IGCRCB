/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;



public interface IGALM07BL extends BaseBL {
	
	

	public IGALM07DTO searchALM0501VWAction(IGALM07DTO dto)throws BLException;
	public IGALM07DTO getRefreshRate(IGALM07DTO dto) throws BLException;
	public String searchTable(final CRM10SearchCond cond);
}
