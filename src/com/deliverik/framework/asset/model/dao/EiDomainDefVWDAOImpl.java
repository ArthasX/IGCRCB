/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.asset.model.entity.EiDomainDefVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ����: ���°�����Ϣ��ͼDAOʵ��
 * ��������: ���°�����Ϣ��ͼDAOʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class EiDomainDefVWDAOImpl extends BaseHibernateDAOImpl<EiDomainDefVWInfo>
		implements EiDomainDefVWDAO {
	static Log log = LogFactory.getLog(EiDomainDefVWDAOImpl.class);

	/**
	 * ���캯��
	 */
	public EiDomainDefVWDAOImpl() {
		super(EiDomainDefVW.class);
	}
	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<EiDomainDefVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}
	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EiDomainDefVWInfo searchEiDomainDefVW(final String eiddid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select ei.eiddid,ei.name,ei.version,ei.description,ei.createtime,ei.updatetime from eidomaindefvw ei where 1=1");
				getSQL(eiddid,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(eiddid);
				q.addEntity("ei", EiDomainDefVW.class);
				 List<EiDomainDefVW> list = q.list();
				session.clear();
				session.close();
				return list.size() > 0 ? list.get(0): null;
			}
		};
		return (EiDomainDefVWInfo)execute(action);
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
