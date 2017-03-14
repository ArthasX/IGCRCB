/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.condition.EventssSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EventssTB;

/**
  * ����: �¼������DAOʵ��
  * ��������: �¼������DAOʵ��
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EventssDAOImpl extends
		BaseHibernateDAOImpl<EventssInfo> implements EventssDAO {

	/**
	 * ���캯��
	 */
	public EventssDAOImpl(){
		super(EventssTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EventssInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eventid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EventssInfo findByPK(Serializable pk) {
		EventssInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EventssSearchCond cond){
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
	public List<EventssInfo> findByCond(final EventssSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		 c.addOrder(Order.asc("labels"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EventssSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getEventssid()!=null&&cond.getEventssid()!=0){
			c.add(Expression.eq("eventid", cond.getEventssid()));
		}
		if(cond.getEventssname() != null && !"".equals(cond.getEventssname())){
			//c.add(Expression.eq("eventname", cond.getEventssname()));
			c.add(Restrictions.like("eventname", "%"+cond.getEventssname()+"%"));
		}
		if(cond.getEventDes() != null && !"".equals(cond.getEventDes())){
			//c.add(Expression.eq("eventname", cond.getEventssname()));
			c.add(Restrictions.like("eventdes", "%"+cond.getEventDes()+"%"));
		}
		if(cond.getLabels()!=null&&cond.getLabels()!=0){
		    c.add(Expression.eq("labels", cond.getLabels()));			
		}	
		if(StringUtils.isNotEmpty(cond.getOrder())&&StringUtils.isNotEmpty(cond.getOrderBy())){
			if("asc".equals(cond.getOrder())){
				
				c.addOrder(Order.asc(cond.getOrderBy()));
			}else if("desc".equals(cond.getOrder())){
				
				c.addOrder(Order.desc(cond.getOrderBy()));
			}
		}
		return c;
	}

}