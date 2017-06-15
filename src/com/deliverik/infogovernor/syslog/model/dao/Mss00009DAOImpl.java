/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00009SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00009TB;

/**
 * ����: mss00009DAOʵ�� ��������: mss00009DAOʵ�� ������¼: 2013/03/28 �޸ļ�¼:
 */
@SuppressWarnings("deprecation")
public class Mss00009DAOImpl extends BaseHibernateDAOImpl<Mss00009Info>
		implements Mss00009DAO {

	/**
	 * ���캯��
	 */
	public Mss00009DAOImpl() {
		super(Mss00009TB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<Mss00009Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 * 
	 * @param pk
	 *            ����
	 * @return �������
	 */
	public Mss00009Info findByPK(Serializable pk) {
		Mss00009Info result = super.findByPK(pk);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 * @throws Exception
	 */
	public int getSearchCount(final Mss00009SearchCond cond) throws Exception {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 * @throws Exception
	 */
	public List<Mss00009Info> findByCond(final Mss00009SearchCond cond,
			final int start, final int count) throws Exception {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));// ����ʱ���ɽ���Զ����
		c.addOrder(Order.desc("rulelevel"));// ���ռ����ɸߵ�������
		return findByCriteria(c, start, count);
	}
	
	/**
	 * ��ȡ��ǰ���ID
	 * @return
	 */
	public int getMaxID(){
		
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				
				query.append(" select COALESCE(max(ID),0) from mss00009 ");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Mss00009SearchCond cond)
			throws Exception {
		DetachedCriteria c = getDetachedCriteria();

		// ���澯IP��Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getIp_like())) {
			c.add(Expression.like("deviceip", "%" + cond.getIp_like() + "%"));
		}
		// ����ʼ�ĸ澯����ʱ�䲻Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getStarttime_from())) {
			// ת������ʱ��
			c.add(Expression.ge("starttime", cond.getStarttime_from()));
		}
		// �������ĸ澯����ʱ�䲻Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// ת������ʱ��
			c.add(Expression.le("starttime", cond.getStarttime_to()));
		}

		if (StringUtils.isNotEmpty(cond.getEndtime_from())) {
			// ת������ʱ��
			c.add(Expression.ge("endtime", cond.getEndtime_from()));
		}
		// �������ĸ澯����ʱ�䲻Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// ת������ʱ��
			c.add(Expression.le("endtime", cond.getStarttime_to()));
		}

		// ���澯���ݹؼ��ֲ�Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getWord_like())) {
			c.add(Expression.like("alarmmsg", "%" + cond.getWord_like() + "%"));
		}
		// ���豸����syscoding��Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		if (cond.getPriority() != null && cond.getPriority().length != 0) {
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		if (cond.getCvalue() != null && cond.getCvalue().length != 0) {
			c.add(Expression.in("rulelevel", cond.getCvalue()));
		}
		if (StringUtils.isNotEmpty(cond.getState())) {
			c.add(Expression.eq("state",Integer.parseInt(cond.getState())));
		}
		if(cond.getId()!=null&&cond.getId().length!=0)
		{
			c.add(Expression.in("id", cond.getId()));
		}
		return c;
	}

}