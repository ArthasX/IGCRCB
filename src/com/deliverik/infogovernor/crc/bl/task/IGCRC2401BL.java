package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;

/**
 * 
 * 功能：事件平均解决事件统计BL
 */
public interface IGCRC2401BL extends BaseBL{
	public List<IGCRC2401VW> igcrc2401vwList(IGCRC2401Cond cond);
	public List<IGCRC2401VW> igcrc2401vwListConfirm(IGCRC2401Cond cond);
}
