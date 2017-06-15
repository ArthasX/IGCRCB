/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0125Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0125VW;

/**
 * ����: ���°�����Ϣ��ͼDAOʵ��
 * ��������: ���°�����Ϣ��ͼDAOʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class SOC0125DAOImpl extends BaseHibernateDAOImpl<SOC0125Info>
		implements SOC0125DAO {
	static Log log = LogFactory.getLog(SOC0125DAOImpl.class);

	/**
	 * ���캯��
	 */
	public SOC0125DAOImpl() {
		super(SOC0125VW.class);
	}
	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<SOC0125Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}
	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SOC0125Info searchEiDomainDefVW(final String eiddid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select ei.eiddid,ei.name,ei.version,ei.description,ei.createtime,ei.updatetime from SOC0125 ei where 1=1");
				getSQL(eiddid,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(eiddid);
				q.addEntity("ei", SOC0125VW.class);
				 List<SOC0125VW> list = q.list();
				session.clear();
				return list.size() > 0 ? list.get(0): null;
			}
		};
		return (SOC0125Info)execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(String eiddid,StringBuffer query) {
			// �ʲ�����ID
			if (eiddid!= null) {
				query.append(" AND ei.eiddid=" +Integer.parseInt(eiddid));
			}

	}

}
