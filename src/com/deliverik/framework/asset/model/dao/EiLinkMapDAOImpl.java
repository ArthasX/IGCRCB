/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCond;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.entity.EiLinkMapTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ʵ����·ͼDAOʵ��
  * ��������: ʵ����·ͼDAOʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EiLinkMapDAOImpl extends
		BaseHibernateDAOImpl<EiLinkMapInfo> implements EiLinkMapDAO {

	/**
	 * ���캯��
	 */
	public EiLinkMapDAOImpl(){
		super(EiLinkMapTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiLinkMapInfo> findAll() {
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
	public EiLinkMapInfo findByPK(Serializable pk) {
		EiLinkMapInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiLinkMapSearchCond cond){
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
	public List<EiLinkMapInfo> findByCond(final EiLinkMapSearchCond cond, final int start, final int count){
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
	public List<EiLinkMapInfo> queryEiLinkMapList(final EiLinkMapSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EiLinkMapDAO.queryEiLinkMapList").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("link",EiLinkMapTB.class);

				q.setProperties(cond);
				
				setFetchPoint(q, 0, 0);

				List<EiLinkMapInfo> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiLinkMapInfo>) execute(action);
	}
	
	/**
	 * Ӱ��CI��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> queryImpactCI(final EiLinkMapSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				
				query.append("SELECT DISTINCT A.EIID FROM EILINKMAP A");
				query.append(" INNER JOIN (SELECT LINKID FROM EILINKMAP B");
				query.append(" INNER JOIN (SELECT EIDDID, MAX(VERSION) AS VERSION FROM EIDOMAINDEF WHERE EIDDID = :domainid_eq GROUP BY EIDDID) C");
				query.append("  ON (B.DOMAINID = C.EIDDID AND B.DOMAINVERSION = C.VERSION)");
				query.append(" WHERE B.EIID = :eiid_eq AND B.LINKFLAG = '1' ) D ON(A.LINKID = D.LINKID)");
				query.append(" WHERE A.ESYSCODING like (:esyscoding_eq || '%')");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				setFetchPoint(q, 0, 0);
				
				List<Integer> list = q.list();
				
				session.clear();
				session.close();
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
	protected DetachedCriteria getCriteria(EiLinkMapSearchCond cond){
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

	@SuppressWarnings("unchecked")
	public List<EiLinkMapInfo> searchEiLinkMapByOtherEiid(
			final EiLinkMapSearchCondImpl emCond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("select * from eilinkmap where linkid in(select linkid from eilinkmap where linkid in(select linkid from eilinkmap where ");
				query.append("domainid=:domainid_eq and domainversion=:domainversion_eq and eiid=:eiid_eq) and eiid=:otherEiid)");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("link",EiLinkMapTB.class);

				q.setProperties(emCond);
				
				setFetchPoint(q, 0, 0);

				List<EiLinkMapInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<EiLinkMapInfo>) execute(action);
	}
}