package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCond;

public interface QuartzProcessInfoBL extends BaseBL{

	public List<QuartzProcessInfo> searchQuartzProcessInfos(QuartzProcessInfoSearchCond cond,
			int start, int count);
	
	public void saveQuartzProcessInfos(List<QuartzProcessInfo> quartzProcessInfoList);
	
	public void saveQuartzProcessInfo(QuartzProcessInfo quartzProcessInfo);
	
	public QuartzProcessInfo saveQuartzProcessInfoRE(QuartzProcessInfo quartzProcessInfo);
	
	public void deleteQuartzProcessInfos(List<QuartzProcessInfo> quartzProcessInfoList);
	
	public List<QuartzProcessInfo> saveQuartzProcessInfoValues(List<QuartzProcessInfo> quartzProcessInfoList);
}
