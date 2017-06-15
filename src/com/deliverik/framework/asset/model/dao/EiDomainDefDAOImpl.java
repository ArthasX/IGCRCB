/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDefTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ����: �ʲ������DAOʵ�� ��������: �ʲ������DAOʵ�� ������¼: 2011/04/20 �޸ļ�¼:
 */
public class EiDomainDefDAOImpl extends BaseHibernateDAOImpl<EiDomainDefInfo>
		implements EiDomainDefDAO {
	static Log log = LogFactory.getLog(EiDomainDefDAOImpl.class);

	/**
	 * ���캯��
	 */
	public EiDomainDefDAOImpl() {
		super(EiDomainDefTB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<EiDomainDefInfo> findAll() {
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
	public EiDomainDefInfo findByPK(Serializable pk) {
		EiDomainDefInfo result = super.findByPK(pk);
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
	 */
	public int getSearchCount(final EiDomainDefSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();

				query.append(session.getNamedQuery(
						"EiDomainDefDAO.getSearchCount").getQueryString());

				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
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
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(EiDomainDefSearchCond cond, StringBuffer query) {

		// �ʲ�Ԥ��������
		if (StringUtils.isNotEmpty(cond.getName_like())) {
			query.append(" AND ei.name like ('%'||:name_like||'%')");
		}
		// ��ʼ����
		if (StringUtils.isNotEmpty(cond.getCreatetime_from())) {
			query.append(" AND ei.createtime >= :createtime_from");
		}
		// ��������
		if (StringUtils.isNotEmpty(cond.getCreatetime_to())) {
			query.append(" AND ei.createtime <= :createtime_to");
		}
		
		//����ID
		if (StringUtils.isNotEmpty(cond.getEiddid_eq())) {
			query.append(" AND ei.eiddid = " + Integer.parseInt(cond.getEiddid_eq()));
		}
		
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<EiDomainDefInfo> findByCond(final EiDomainDefSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();

				query.append(session.getNamedQuery(
								"EiDomainDefDAO.getSearchEiDomainDef").getQueryString());
				getSQL(cond, query);
				query.append(" group by ei.eiddid,ei.name,ei.version,ei.description,ei.createtime,ei.updatetime,ei.fingerprint order by ei.createtime desc");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ei", EiDomainDefTB.class);
				q.setProperties(cond);
				setFetchPoint(q, start, count);
				List<EiDomainDefTB> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiDomainDefInfo>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EiDomainDefSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

	/**
	 * ��ѯ���EiddId
	 * 
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public Integer findMaxEiddId() {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select max(eiddid) from eidomaindef");
				SQLQuery q = session.createSQLQuery(query.toString());
				List<Integer> list = q.list();
				session.clear();
				session.close();
				return list.size() > 0 && list.get(0) != null ? list.get(0)
						: null;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ��ȡ�ʲ�����汾
	 * @param eiddid
	 * @param version
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EiDomainDefInfo> searchEiDomainDefByPK(final Integer eiddid,final Integer version) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EiDomainDefDAO.searchEiDomainDefByPK").getQueryString());
				getSQL(eiddid,version,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(eiddid);
				q.addEntity("ei", EiDomainDefTB.class);
				 List<EiDomainDefTB> list = q.list();
				session.clear();
				session.close();
				return list.size() > 0 ? list: null;
			}
		};
		return ( List<EiDomainDefInfo>) execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(Integer eiddid,Integer version, StringBuffer query) {

			// �ʲ�����ID
			if (eiddid!= null) {
				query.append(" AND ei.eiddid='" +eiddid+ "'");
			}
			// �ʲ�����汾��
			if (version!= null) {
				query.append(" AND ei.version!=" +version);
			}

	}

}