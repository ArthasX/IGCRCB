package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCond;
import com.deliverik.infogovernor.scheduling.model.dao.QuartzProcessInfoTBDAO;

public class QuartzProcessInfoBLImpl extends BaseBLImpl implements QuartzProcessInfoBL{

	private QuartzProcessInfoTBDAO quartzProcessInfoDAO;
	
	public void setQuartzProcessInfoDAO(QuartzProcessInfoTBDAO quartzProcessInfoDAO) {
		this.quartzProcessInfoDAO = quartzProcessInfoDAO;
	}

	public List<QuartzProcessInfo> searchQuartzProcessInfos(
			QuartzProcessInfoSearchCond cond, int start, int count) {
		return quartzProcessInfoDAO.findByCond(cond, start, count);
	}

	public void saveQuartzProcessInfos(List<QuartzProcessInfo> quartzProcessInfoList) {
		quartzProcessInfoDAO.saveOrUpdateAll(quartzProcessInfoList);
	}

	public void saveQuartzProcessInfo(QuartzProcessInfo quartzProcessInfo) {
		quartzProcessInfoDAO.save(quartzProcessInfo);
	}

	public QuartzProcessInfo saveQuartzProcessInfoRE(QuartzProcessInfo quartzProcessInfo) {
		return quartzProcessInfoDAO.save(quartzProcessInfo);
	}

	public void deleteQuartzProcessInfos(List<QuartzProcessInfo> quartzProcessInfoList) {
		quartzProcessInfoDAO.delete(quartzProcessInfoList);
	}
	
	public List<QuartzProcessInfo> saveQuartzProcessInfoValues(List<QuartzProcessInfo> quartzProcessInfoList) {
		List<QuartzProcessInfo> list = new ArrayList<QuartzProcessInfo>();
		for(QuartzProcessInfo qpi : quartzProcessInfoList){
			list.add(saveQuartzProcessInfoRE(qpi));
		}
		return list;
	}

}
