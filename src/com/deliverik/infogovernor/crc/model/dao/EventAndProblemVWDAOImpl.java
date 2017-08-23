/*
 * ���������ƹɷ����޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;
import com.deliverik.infogovernor.crc.model.condition.EventAndProblemVWSearchCond;
import com.deliverik.infogovernor.crc.model.entity.EventAndProblemVW;

public class EventAndProblemVWDAOImpl extends
BaseHibernateDAOImpl<EventAndProblemVWInfo> implements EventAndProblemVWDAO {
	
	/**
	 * ���캯��
	 */
	public EventAndProblemVWDAOImpl(){
		super(EventAndProblemVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EventAndProblemVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EventAndProblemVWInfo findByPK(Serializable pk) {
		EventAndProblemVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EventAndProblemVWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EventAndProblemVWInfo> findByCond(final EventAndProblemVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);		
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EventAndProblemVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getEventNum())){
			c.add(Restrictions.like("eventNum", String.format("%%%s%%",cond.getEventNum())));
		}
		if(StringUtils.isNotEmpty(cond.getEventTitle())){
			c.add(Restrictions.like("eventTitle", String.format("%%%s%%", cond.getEventTitle())));
		}
		if(StringUtils.isNotEmpty(cond.getEventusername())){
			c.add(Restrictions.like("eventusername", String.format("%%%s%%", cond.getEventusername())));
		}
		if(StringUtils.isNotEmpty(cond.getEventstatus())){
			c.add(Restrictions.eq("eventstatus", cond.getEventstatus()));
		}
//		if(StringUtils.isNotEmpty(cond.getEventdealuser_like())){
//			c.add(Restrictions.like("eventdealuser", cond.getEventdealuser_like()));
//		}
		if(StringUtils.isNotEmpty(cond.getHappenTime_from())){
			c.add(Restrictions.ge("happenTime", cond.getHappenTime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getHappenTime_to())){
			c.add(Restrictions.le("happenTime", cond.getHappenTime_to()));
		}
		if(StringUtils.isNotEmpty(cond.getEventSource())){
			c.add(Restrictions.eq("eventSource", cond.getEventSource()));
		}
		if(StringUtils.isNotEmpty(cond.getInvolveSystem())){
			c.add(Restrictions.like("involveSystem", String.format("%%%s%%", cond.getInvolveSystem())));
		}
		if(StringUtils.isNotEmpty(cond.getInfluenceRange())){
			c.add(Restrictions.eq("influenceRange", cond.getInfluenceRange()));
		}
		if(StringUtils.isNotEmpty(cond.getProblemNum())){
			c.add(Restrictions.like("problemNum", String.format("%%%s%%", cond.getProblemNum())));
		}
		if(StringUtils.isNotEmpty(cond.getProblemTitle())){
			c.add(Restrictions.like("problemTitle", String.format("%%%s%%", cond.getProblemTitle())));
		}
		if(StringUtils.isNotEmpty(cond.getProblemopentime_from())){
			c.add(Restrictions.ge("problemopentime", cond.getProblemopentime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getProblemopentime_to())){
			c.add(Restrictions.le("problemopentime", cond.getProblemopentime_to()));
		}
		if(StringUtils.isNotEmpty(cond.getProblemusername())){	
			c.add(Restrictions.like("problemusername", String.format("%%%s%%", cond.getProblemusername())));
		}
		if(StringUtils.isNotEmpty(cond.getProblemstatus())){
			c.add(Restrictions.eq("problemstatus", cond.getProblemstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getProblemcontent())){
			c.add(Restrictions.like("problemcontent", String.format("%%%s%%", cond.getProblemcontent())));
		}
		if(StringUtils.isNotEmpty(cond.getShow_tree())){
			c.add(Restrictions.eq("eventType", cond.getShow_tree()));
		}
				
		return c;
	}
	

	
	
	
	
}
