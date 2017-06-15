/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;

/**
 * ���ռ��DAOʵ��
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("unchecked")
public class RiskCheckDAOImpl extends BaseHibernateDAOImpl<RiskCheck> implements RiskCheckDAO {

	/**
	 * ���캯��
	 */
	public RiskCheckDAOImpl(){
		super(RiskCheckTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskCheck> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rcid"));
		List<RiskCheck> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rcid ����
	 * @return �������
	 */
	public RiskCheck findByPK(Serializable rcid) {

		RiskCheck result = super.findByPK(rcid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskCheckSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheck> findByCond(final RiskCheckSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rcstatus"));
		c.addOrder(Order.desc("rccreatetime"));
		c.addOrder(Order.desc("rccategory"));
		c.addOrder(Order.desc("rcid"));
		List<RiskCheck> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskCheckSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���ռ����id
		if(cond.getRcasset() != null){
			c.add(Restrictions.eq("rcasset", cond.getRcasset()));
		}
		//���ռ����
		if( !StringUtils.isEmpty(cond.getRcname_q())){
			c.add(Restrictions.like("rcname","%" + cond.getRcname_q() + "%"));
		}
		//���ռ����
		if( !StringUtils.isEmpty(cond.getRcname())){
			c.add(Restrictions.eq("rcname", cond.getRcname()));
		}
		//���ռ����˵��
		if( !StringUtils.isEmpty(cond.getRcdesc())){
			c.add(Restrictions.eq("rcdesc", cond.getRcdesc()));
		}
		//������ID
		if(StringUtils.isNotEmpty(cond.getRcuserid())){
			c.add(Restrictions.eq("rcuserid", cond.getRcuserid()));
		}
		//��������
		if( StringUtils.isNotEmpty(cond.getRccategory())){
			c.add(Restrictions.eq("rccategory", cond.getRccategory()));
		}
		//�����״̬
		if(StringUtils.isNotEmpty(cond.getRcstatus())){
			c.add(Restrictions.eq("rcstatus", cond.getRcstatus()));
		}
		//����������
		if(StringUtils.isNotEmpty(cond.getRcrolename())){
			c.add(Restrictions.like("rcrolename", "%"+cond.getRcrolename()+"%"));
		}
		
		//����������
		if(StringUtils.isNotEmpty(cond.getRcusername())){
			c.add(Restrictions.like("rcusername", "%"+cond.getRcusername()+"%"));
		}
		
		//����
		if(StringUtils.isNotEmpty(cond.getRcclass())){
			c.add(Restrictions.eq("rcclass", cond.getRcclass()));
		}
		if(cond.getRcid_in()!=null &&  cond.getRcid_in().length>0){
			c.add(Restrictions.in("rcid", cond.getRcid_in()));
		}
		
		
		//Ƶ��
		if(StringUtils.isNotEmpty(cond.getRcfrequency())){
			c.add(Restrictions.eq("rcfrequency", cond.getRcfrequency()));
		}
		if(StringUtils.isNotEmpty(cond.getRcCreateTime_like())){
			c.add(Restrictions.like("rccreatetime", cond.getRcCreateTime_like() + "%"));
		}
		return c;
	}
	public List<RiskCheck> dbmselByrcclass() {
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("RiskCheckResultDAOImpl.dbmselByrcclass").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					setFetchPoint(q, 0, 0);
					q.addEntity("t",RiskCheckTB.class);
					List<RiskCheck> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<RiskCheck>) execute(action);
	}
	public List<RiskCheck> getRcclassByMonth(final RiskCheckSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskCheckResultDAOImpl.getrcclassbymonth").getQueryString());
				if(StringUtils.isNotEmpty(cond.getYearMonth())){
					query.append(" and  rccreatetime like '"+cond.getYearMonth()+"%' ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				setFetchPoint(q, 0, 0);
				q.addEntity("t",RiskCheckTB.class);
				List<RiskCheck> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RiskCheck>) execute(action);
	}

	public List<RiskCheck> getRcTestMode(final RiskCheckSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskCheckResultDAOImpl.getrcclassbymonth").getQueryString());
				if(StringUtils.isNotEmpty(cond.getStartDate()) && StringUtils.isNotEmpty(cond.getEndDate())){
					query.append(" and  rccreatetime<= '"+cond.getEndDate()+"' and '"+cond.getStartDate()+"' <=rccreatetime ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				setFetchPoint(q, 0, 0);
				q.addEntity("t",RiskCheckTB.class);
				List<RiskCheck> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RiskCheck>) execute(action);
	}


}
