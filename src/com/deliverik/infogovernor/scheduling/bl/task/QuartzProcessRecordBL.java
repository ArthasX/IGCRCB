package com.deliverik.infogovernor.scheduling.bl.task;

import java.io.Serializable;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

public interface QuartzProcessRecordBL extends BaseBL{

	public QuartzProcessRecord saveQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord);
	
	public QuartzProcessRecord findByPK(Serializable qprid);
	
	public void deleteQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord);
	
}
