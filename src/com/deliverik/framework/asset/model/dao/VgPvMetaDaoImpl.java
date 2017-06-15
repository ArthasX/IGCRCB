/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.VgPvMetaInfo;
import com.deliverik.framework.asset.VgPvMetaTB;
import com.deliverik.framework.asset.model.condition.VgPvMetaSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * ����: �豸��ϵ��ϢDAOʵ��(VG-PV-Meta)
 * ��������: �豸��ϵ��ϢDAOʵ��(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class VgPvMetaDaoImpl extends BaseHibernateDAOImpl<VgPvMetaInfo> implements VgPvMetaDao{

	/**
	 * ���캯��
	 */
	public VgPvMetaDaoImpl(){
		super(VgPvMetaTB.class);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<VgPvMetaInfo> searchVgPvMeta(final VgPvMetaSearchCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("VgPvMetaDao.findVgPvMetaByVW").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(VgPvMetaTB.class);
				List<VgPvMetaTB> list = q.list();
				session.flush();
				session.close();
				return list;
			}		
		};
		return (ArrayList<VgPvMetaInfo>)execute(action);
	}


}
