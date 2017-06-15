/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;
import com.deliverik.framework.soc.asset.model.entity.EntityItemUntreatedVW;

/**
 * ����:δ�ϼܻ��񡢿յ���ups��ͼDAOʵ��
 * ��������: δ�ϼܻ��񡢿յ���ups��ͼDAOʵ��
 * �����ˣ�����
 * ������¼: 2013/07/03
 * �޸ļ�¼: 
 */

public class EntityItemUntreatedVWDAOImpl extends
		BaseHibernateDAOImpl<EntityItemUntreatedVWInfo> implements
		EntityItemUntreatedVWDAO {
	
	public EntityItemUntreatedVWDAOImpl(){
		super(EntityItemUntreatedVW.class);
	}
	
	/**
	 * δ�ϼܻ��񡢿յ���ups�б�ȡ��
	 *
	 * @return list ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<EntityItemUntreatedVWInfo> getToolsData(){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("EntityItemUntreatedVWDAO.EntityItemUntreatedVWDAO").getQueryString());
				//׷������
//				query.append(" order by A.esyscoding desc,D.civalue,E.civalue desc,A.einame");
				query.append(" order by A.esyscoding desc");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("EntityItemUntreatedVW",EntityItemUntreatedVW.class);
				List<EntityItemUntreatedVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<EntityItemUntreatedVWInfo>)execute(action);
	}
}
