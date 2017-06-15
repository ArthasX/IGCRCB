package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCond;

public interface QuartzProcessParticipantBL extends BaseBL{
	
	public QuartzProcessParticipant saveQuartzProcessParticipant(QuartzProcessParticipant quartzProcessParticipant);
	
	public void saveAllQuartzProcessParticipant
		(List<QuartzProcessParticipant> quartzProcessParticipantList);
	
	public List<QuartzProcessParticipant> searchProcessParticipant(QuartzProcessParticipantSearchCond cond,int start,int count);
	
	public void deleteProcessParticipants(List<QuartzProcessParticipant> qppList);
}
