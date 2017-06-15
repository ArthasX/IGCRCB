/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

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

import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0114TB;

/**
  * ����: ʵ����·ͼDAOʵ��
  * ��������: ʵ����·ͼDAOʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0114DAOImpl extends
		BaseHibernateDAOImpl<SOC0114Info> implements SOC0114DAO {

	/**
	 * ���캯��
	 */
	public SOC0114DAOImpl(){
		super(SOC0114TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<SOC0114Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("linkid"));
		c.addOrder(Order.asc("linkorder"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
	public SOC0114Info findByPK(Serializable pk) {
		SOC0114Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0114SearchCond cond){
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
	public List<SOC0114Info> findByCond(final SOC0114SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("linkid"));
		c.addOrder(Order.asc("linkorder"));
		return findByCriteria(c, start, count);
	}
	
	/**
	 * ����ͼ��·��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0114Info> queryEiLinkMapList(final SOC0114SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EiLinkMapDAO.queryEiLinkMapList").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("link",SOC0114TB.class);

				q.setProperties(cond);
				
				setFetchPoint(q, 0, 0);

				List<SOC0114Info> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<SOC0114Info>) execute(action);
	}
	
	/**
	 * Ӱ��CI��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> queryImpactCI(final SOC0114SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				
				query.append("SELECT DISTINCT A.EIID FROM SOC0114 A");
				query.append(" INNER JOIN (SELECT LINKID FROM SOC0114 B");
				query.append(" INNER JOIN (SELECT EIDDID, MAX(VERSION) AS VERSION FROM SOC0111 WHERE EIDDID = :domainid_eq GROUP BY EIDDID) C");
				query.append("  ON (B.DOMAINID = C.EIDDID AND B.DOMAINVERSION = C.VERSION)");
				query.append(" WHERE B.EIID = :eiid_eq AND B.LINKFLAG = '1' ) D ON(A.LINKID = D.LINKID)");
				query.append(" WHERE A.ESYSCODING like (:esyscoding_eq || '%')");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				setFetchPoint(q, 0, 0);
				
				List<Integer> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<Integer>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0114SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��ID
		if (cond.getDomainid_eq() != null && cond.getDomainid_eq() > 0) {
			c.add(Expression.eq("domainid", cond.getDomainid_eq()));
		}
		//��汾
		if (cond.getDomainversion_eq() != null && cond.getDomainversion_eq() > 0) {
			c.add(Expression.eq("domainversion", cond.getDomainversion_eq()));
		}
		//�ʲ�ID
		if (cond.getEiid_eq() != null && cond.getEiid_eq() > 0) {
			c.add(Expression.eq("eiid", cond.getEiid_eq()));
		}
		//����ʱ��
		if (StringUtils.isNotEmpty(cond.getCreatetime_eq())) {
			c.add(Expression.eq("createtime", cond.getCreatetime_eq()));
		}
		//��ͼ���
		if (StringUtils.isNotEmpty(cond.getLinkflag_eq())) {
			c.add(Expression.eq("linkflag", cond.getLinkflag_eq()));
		}
		return c;
	}
	public List<SOC0114Info> searchEiLinkMapByOtherEiid(
			final EiLinkMapSearchCondImpl emCond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("select * from SOC0114 where linkid in(select linkid from SOC0114 where linkid in(select linkid from SOC0114 where ");
				query.append("domainid=:domainid_eq and domainversion=:domainversion_eq and eiid=:eiid_eq) and eiid=:otherEiid)");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("link",SOC0114TB.class);

				q.setProperties(emCond);
				
				setFetchPoint(q, 0, 0);

				List<SOC0114Info> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<SOC0114Info>) execute(action);
	}
	
	/**
	 * ����eiid ɾ����·
	 * @param eiid
	 */
	public void delByEiid (Integer eiid){
		String sql = "delete from soc0114 where linkid in(select linkid from soc0114 where eiid = :eiid)";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eiid", eiid);
		q.executeUpdate();
	}
	
	/**
	 * ����eiid��ѯ������ص�ҵ��ϵͳeiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchLinkByEiid(Integer eiid){
		String sql = "select a.eiid from soc0114 a where linkid in (select linkid from soc0114 c left join soc0118 d on (c.eiid=d.eiid and c.eiversion=d.eiversion and c.eismallversion=d.eismallversion) where d.eiid=:eiid) and a.esyscoding='999003001'";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eiid", eiid);
		List<Integer> result = q.list();
		return result;
	}
	
	
}