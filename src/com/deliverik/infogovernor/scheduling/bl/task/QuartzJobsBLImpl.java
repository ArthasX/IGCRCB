package com.deliverik.infogovernor.scheduling.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCond;
import com.deliverik.infogovernor.scheduling.model.dao.QuartzJobsTBDAO;

public class QuartzJobsBLImpl extends BaseBLImpl implements QuartzJobsBL{
	
	private QuartzJobsTBDAO quartzJobsDAO;

	public void setQuartzJobsDAO(QuartzJobsTBDAO quartzJobsDAO) {
		this.quartzJobsDAO = quartzJobsDAO;
	}

	/**
	 * 获取job设置信息列表
	 * @param cond 
	 * @param start 
	 * @param count 
	 * @return QuartzJobs
	 */
	
	public List<QuartzJobs> searchQuartzJobs(QuartzJobsSearchCond cond, int start,int count){
		return quartzJobsDAO.findByCond(cond, start, count);
	}

	public QuartzJobs saveQuartzJobs(QuartzJobs quartzJobs) {
		return quartzJobsDAO.save(quartzJobs);
	}
	public void removeQuartzJobs(QuartzJobs quartzJobs) throws BLException{
		quartzJobsDAO.delete(quartzJobs);
	}

	public int getSearchCount(QuartzJobsSearchCond cond) throws BLException {
		return quartzJobsDAO.getSearchCount(cond);
	}
	
	/**
	 * <p>
	 * Description: 通过主键查询相应记录
	 * </p>
	 */

	public QuartzJobs searchQuartzJobsByKey(Integer qjid) {
		QuartzJobs ret = quartzJobsDAO.findByPK(qjid);
		return ret;
	}

	public void deleteQuartzJobs(Integer qjid) throws BLException {
		QuartzJobs quartzJobs = checkExistQuartzJobs(qjid);
		quartzJobsDAO.delete(quartzJobs);
		
	}
	
	/**
	 * <p>
	 * Description: 查询是否存在该主键ID的定时任务
	 * </p>
	 */
	protected QuartzJobs checkExistQuartzJobs(Integer qjid) throws BLException{
		QuartzJobs info = quartzJobsDAO.findByPK(qjid);
		if( info == null) {
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","通知基本");
		}
		
		return info;
	}

	public QuartzJobs updateQuartzJobs(QuartzJobs quartzJobs)
			throws BLException {
		QuartzJobs ret = quartzJobsDAO.save(quartzJobs);
		return ret;
	}

	public QuartzJobs findByPK(Serializable qjid) {
		// TODO Auto-generated method stub
		return quartzJobsDAO.findByPK(qjid);
	}
	/**
	 * 根据登记用户,处理用户和时间查询运维计划
	 * @param cond 
	 * @param start 
	 * @param count 
	 * @return QuartzJobs
	 */
	public List<QuartzJobsDetail> getQuartzJobsByUserDate(QuartzJobsSearchCond cond,
			int start, int count) {
		return quartzJobsDAO.queryQuartzJobsByUserDate(cond, start, count);
	}
	
	/**
	 * 根据登记用户,处理用户和时间查询运维计划记录数
	 * @param cond 
	 * @param start 
	 * @param count 
	 * @return QuartzJobs
	 */
	public int getQuartzJobsCountByUserDate(QuartzJobsSearchCond cond) {
		return quartzJobsDAO.queryQuartzJobsCountByUserDate(cond);
	}
	
}
