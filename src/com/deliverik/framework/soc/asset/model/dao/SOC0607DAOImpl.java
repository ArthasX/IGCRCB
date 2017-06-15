/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0607VW;

/**
 * ����:�ʲ����ϵ��Ϣʵ��
 * �����������ʲ����ϵ��Ϣʵ��
 * �����ˣ�����
 * ������¼�� 2013-10-21
 * �޸ļ�¼��
 */

public class SOC0607DAOImpl extends BaseHibernateDAOImpl<SOC0119Info> implements
		SOC0607DAO {

	public SOC0607DAOImpl(){
		super(SOC0607VW.class);
	}

	/**
	 * ������ѯ����
	 *
	 * @param eirid ��ϵ����
	 * @return SOC0607Info ��ϵʵ��
	 */
	@SuppressWarnings("unchecked")
	public SOC0119Info checkExistEntityItemRelation(final Integer eirid){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				SOC0119Info bean = null;
				if(eirid!=null){
					session.flush();
					//��ȡquery
					StringBuffer query = new StringBuffer();
					query.append( session.getNamedQuery("SOC0607DAO.checkExistEntityItemRelation").getQueryString());
					//׷������
					query.append(" and a.eirid="+eirid );
					//��ȡSQLQuery
					SQLQuery q = session.createSQLQuery(query.toString());
					q.addEntity("SOC0607VW",SOC0607VW.class);
					List<SOC0119Info> list=q.list();
					session.clear();
					session.close();
					if(list!=null&&list.size()>0&&list.get(0)!=null){
						bean = list.get(0);
					}
				}
				return bean;
			}
			
		};
		return (SOC0119Info)execute(action);
	}
}
