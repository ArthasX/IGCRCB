package com.deliverik.infogovernor.scheduling.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCond;

public interface QuartzJobsBL extends BaseBL{

	/**
	 * 获取job设置信息列表
	 * @param cond 
	 * @param start 
	 * @param count 
	 * @return QuartzJobs
	 */
	
	public List<QuartzJobs> searchQuartzJobs(QuartzJobsSearchCond cond, int start,int count);

	/**
	 * 根据登记用户,处理用户和时间查询服务策略
	 * @param cond 
	 * @param start 
	 * @param count 
	 * @return QuartzJobs
	 */
	public List<QuartzJobsDetail> getQuartzJobsByUserDate(final QuartzJobsSearchCond cond,final int start, final int count);
	
	public QuartzJobs saveQuartzJobs(QuartzJobs quartzJobs);
	
	public void removeQuartzJobs(QuartzJobs quartzJobs)throws BLException;
	
	public int getSearchCount(QuartzJobsSearchCond cond) throws BLException;
	
	public void deleteQuartzJobs(Integer qjid) throws BLException;
	
	public QuartzJobs searchQuartzJobsByKey(Integer qjid);
	
	public QuartzJobs findByPK(Serializable qjid);
	
	/**
	 * <p>
	 * Description: 更新
	 * </p>
	 */
	
	public QuartzJobs updateQuartzJobs(QuartzJobs quartzJobs) throws BLException;
	
	/**
	 * 根据登记用户,处理用户和时间查询运维计划记录数
	 * @param cond 
	 * @param start 
	 * @param count 
	 * @return QuartzJobs
	 */
	public int getQuartzJobsCountByUserDate(QuartzJobsSearchCond cond);
}
