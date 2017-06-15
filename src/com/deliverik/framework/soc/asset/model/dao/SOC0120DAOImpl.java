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
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0120TB;

/**
  * ����: �������ݰ汾�����DAOʵ��
  * ��������: �������ݰ汾�����DAOʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0120DAOImpl extends
		BaseHibernateDAOImpl<SOC0120Info> implements SOC0120DAO {

	/**
	 * ���캯��
	 */
	public SOC0120DAOImpl(){
		super(SOC0120TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<SOC0120Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
	public SOC0120Info findByPK(Serializable pk) {
		SOC0120Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0120SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
						"ImportVersionDAO.getSearchCount").getQueryString());
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(SOC0120SearchCond cond, StringBuffer query) {
		
		// �������ʵ������
		if(StringUtils.isNotEmpty(cond.getImpeiname_like())){
			query.append(" AND im.impeiname like ('%'||:impeiname_like||'%')");
			}
		// �������ʵ������
		if(StringUtils.isNotEmpty(cond.getImpeiname())){
			query.append(" AND im.impeiname = :impeiname");
			}
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			query.append(" and deleteflag =:deleteflag_eq");
		}
		//����ʱ��start
		if( !StringUtils.isEmpty(cond.getImpcreatetime_s())){
			query.append(" AND im.impcreatetime >= :impcreatetime_s");
		}
		//����ʱ��end
		if( !StringUtils.isEmpty(cond.getImpcreatetime_e())){
			query.append(" AND im.impcreatetime <= :impcreatetime_e");
		}
		//�豸ģ����
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			query.append(" and im.esyscoding like ('%'||:esyscoding||'%')");
		}
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0120Info> findByCond(final SOC0120SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
								"ImportVersionDAO.getSearchImportVersion").getQueryString());
				getSQL(cond, query);
				query.append(" order by im.impcitype , im.impeiname");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("im", SOC0120TB.class);
				setFetchPoint(q, start, count);
				List<SOC0120TB> list = q.list();
				return list;
			}
		};
		return (List<SOC0120Info>) execute(action);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0120Info> findByCondAutoCollect(final SOC0120SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
								"ImportVersionDAO.getSearchImportVersionAutoCollect").getQueryString());
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("im", SOC0120TB.class);
				setFetchPoint(q, start, count);
				List<SOC0120TB> list = q.list();
				return list;
			}
		};
		return (List<SOC0120Info>) execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0120SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		
		return c;
	}
	
	/**
	 * �������汾����
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0120Info> searchImportVersionByImpname(final String impeiname,final Integer impversion) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("ImportVersionDAO.searchImportVersionByImpname").getQueryString());
				getSQL(impeiname,impversion,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(impeiname);
				q.addEntity("im", SOC0120TB.class);
				 List<SOC0120TB> list = q.list();
				session.clear();
				return list.size() > 0 ? list: null;
			}
		};
		return ( List<SOC0120Info>) execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(String impeiname,Integer impversion, StringBuffer query) {

			// �������ʵ������
			if (impeiname!= null && impeiname != "") {
				query.append(" AND im.impeiname='" +impeiname+ "'");
			}
			// �������汾��
			if (impversion!= null) {
				query.append(" AND im.impversion!=" +impversion);
			}

	}

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param impeinameʵ����
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0120Info> findByImpeiname(final SOC0120SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select * from SOC0120 where impeiname='"+cond.getImpeiname()+"'");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("im", SOC0120TB.class);
				 List<SOC0120TB> list = q.list();
				session.clear();
				return list;
			}
		};
		return ( List<SOC0120Info>) execute(action);
	}
}