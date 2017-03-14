/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.csebank.lom.model.entity.RecptionCostVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * �Ӵ�����DAOʵ��
 *
 */
public class RecptionCostVWDAOImpl extends BaseHibernateDAOImpl<RecptionCost> implements RecptionCostVWDAO {

	/**
	 * ���캯��
	 */
	public RecptionCostVWDAOImpl(){
		super(RecptionCostVW.class);
	}
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionSearchCond cond){
		HibernateCallback action = new HibernateCallback()
		{  
			@SuppressWarnings("unchecked")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<RecptionCost> list =null;
				String startTime = cond.getYear_org() + "/" + cond.getMonth_from_org() + "/00 00:00" ;
				String endTime = cond.getYear_org() + "/" + cond.getMonth_to_org() + "/31 23:59" ;
				query.append(session.getNamedQuery("RecptionCostVWDAO.RecptionCost").getQueryString());
				query.append(" AND  ORG.ORGSYSCODING = :rapporgid_org");
				query.append(" AND  RSTIME >= '").append(startTime+"' ");

				query.append(" AND RETIME <= '").append(endTime+"' ");
				
				query.append(" ORDER BY RP.RID ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(RecptionCostVW.class);
				
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	
	@SuppressWarnings("unchecked")
	public List<RecptionCost> findByCond(final RecptionSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<RecptionCost> list =null;
				String startTime = cond.getYear_org() + "/" + cond.getMonth_from_org() + "/00 00:00" ;
				String endTime = cond.getYear_org() + "/" + cond.getMonth_to_org() + "/31 23:59" ;
				query.append(session.getNamedQuery("RecptionCostVWDAO.RecptionCost").getQueryString());
				query.append(" AND  ORG.ORGSYSCODING = :rapporgid_org");
				query.append(" AND  RSTIME >= '").append(startTime+"' ");

				query.append(" AND RETIME <= '").append(endTime+"' ");
				
				query.append(" ORDER BY RP.RID ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(RecptionCostVW.class);
				
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<RecptionCost>) execute(action);
	}
	

}
