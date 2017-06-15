package com.deliverik.infogovernor.scheduling.bl.task;

import java.io.Serializable;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.dao.QuartzProcessRecordTBDAO;

public class QuartzProcessRecordBLImpl extends BaseBLImpl implements QuartzProcessRecordBL{
	
	private QuartzProcessRecordTBDAO quartzProcessRecordDAO;

	public void setQuartzProcessRecordDAO(QuartzProcessRecordTBDAO quartzProcessRecordDAO) {
		this.quartzProcessRecordDAO = quartzProcessRecordDAO;
	}

	public QuartzProcessRecord saveQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		return quartzProcessRecordDAO.save(quartzProcessRecord);
	}

	public QuartzProcessRecord findByPK(Serializable qprid) {
		return quartzProcessRecordDAO.findByPK(qprid);
	}

	public void deleteQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		quartzProcessRecordDAO.delete(quartzProcessRecord);		
	}

}
