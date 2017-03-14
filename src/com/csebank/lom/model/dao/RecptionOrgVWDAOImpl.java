/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.condition.RecptionOrgVWSearchCond;
import com.csebank.lom.model.entity.RecptionOrgVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ���ŽӴ�DAOʵ��
 *
 */
public class RecptionOrgVWDAOImpl extends BaseHibernateDAOImpl<RecptionOrg> implements RecptionOrgVWDAO {

	/**
	 * ���캯��
	 */
	public RecptionOrgVWDAOImpl(){
		super(RecptionOrgVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<RecptionOrg> findByCond(final RecptionOrgVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<RecptionOrg> list =null;
				
				query.append(session.getNamedQuery("RecptionOrgVWDAO.recptionOrgVW").getQueryString());
				getSQL(cond, query);
				query.append(" GROUP BY RP.RAPPORGID, ORG.ORGNAME ) AS RECPTIONORGVW ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("RecptionOrgVW",RecptionOrgVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<RecptionOrg>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(RecptionOrgVWSearchCond cond, StringBuffer query){
		//���������
		if( StringUtils.isNotEmpty(cond.getRapporgid()) ){
			query.append(" AND rapporgid = :rapporgid");
		}
	}

}
