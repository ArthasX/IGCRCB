package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCond;

public interface QuartzJobsTBDAO extends BaseHibernateDAO<QuartzJobs> {

	public List<QuartzJobs> findAll();

	public QuartzJobs findByPK(Serializable qjid);

	public List<QuartzJobs> findByCond(final QuartzJobsSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final QuartzJobsSearchCond cond);
	/**
	 * ���ݵǼ��û�,�����û���ʱ���ѯ��ά�ƻ�
	 * @param cond 
	 * @param start 
	 * @param count 
	 * @return QuartzJobs
	 */
	public List<QuartzJobsDetail> queryQuartzJobsByUserDate(final QuartzJobsSearchCond cond,final int start, final int count);
	
	/**
	 * ���ݵǼ��û�,�����û���ʱ���ѯ��ά�ƻ���¼��
	 * @return int
	 */
	public int queryQuartzJobsCountByUserDate(final QuartzJobsSearchCond cond);
}
