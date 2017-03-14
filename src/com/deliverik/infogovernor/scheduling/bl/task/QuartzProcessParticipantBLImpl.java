package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCond;
import com.deliverik.infogovernor.scheduling.model.dao.QuartzProcessParticipantTBDAO;

public class QuartzProcessParticipantBLImpl extends BaseBLImpl implements QuartzProcessParticipantBL{
	
	private QuartzProcessParticipantTBDAO quartzProcessParticipantDAO;

	public void setQuartzProcessParticipantDAO(QuartzProcessParticipantTBDAO quartzProcessParticipantDAO) {
		this.quartzProcessParticipantDAO = quartzProcessParticipantDAO;
	}

	public QuartzProcessParticipant saveQuartzProcessParticipant(QuartzProcessParticipant quartzProcessParticipant) {
		return quartzProcessParticipantDAO.save(quartzProcessParticipant);
	}

	public void saveAllQuartzProcessParticipant(
			List<QuartzProcessParticipant> quartzProcessParticipantList) {
		quartzProcessParticipantDAO.saveOrUpdateAll(quartzProcessParticipantList);
	}

	public List<QuartzProcessParticipant> searchProcessParticipant(
			QuartzProcessParticipantSearchCond cond, int start, int count) {
		return quartzProcessParticipantDAO.findByCond(cond, start, count);
	}

	public void deleteProcessParticipants(List<QuartzProcessParticipant> qppList) {
		quartzProcessParticipantDAO.delete(qppList);
	}

}
