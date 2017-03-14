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

import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.csebank.lom.model.entity.WorkLunchEateryVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * �����ͳɱ�ͳ��DAOʵ��
 *
 */
public class WorkLunchEateryDAOImpl extends BaseHibernateDAOImpl<WorkLunchEatery> implements WorkLunchEateryDAO {

	/**
	 * ���캯��
	 */
	public WorkLunchEateryDAOImpl(){
		super(WorkLunchEateryVW.class);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<WorkLunchEatery> findByCond(final WorkLunchEaterySearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if("M".equals(cond.getSearchtype())){
					if(!StringUtils.isEmpty(cond.getEdate())){
						if(cond.getEdate().length()==7){
							query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryYM").getQueryString());
						}else{
							query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryY").getQueryString());
						}
					}else{
						query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEatery").getQueryString());
					}
					
				}else if("Y".equals(cond.getSearchtype())){
					if(!StringUtils.isEmpty(cond.getEdate())){
						query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryYY").getQueryString());
					}else {
						query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryAY").getQueryString());
					}
					
				}else if("D".equals(cond.getSearchtype())){
					query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryDM").getQueryString());
				}else{
					if(!StringUtils.isEmpty(cond.getEdate())){
						if(!StringUtils.isEmpty(cond.getEtime_from())){
							query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryYQ").getQueryString());
						}else{
							query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryYYY").getQueryString());
						}
						
					}else {
						query.append(session.getNamedQuery("WorkLunchEateryDAO.workLunchEateryQ").getQueryString());
					}
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("WLEatery",WorkLunchEateryVW.class);
				setFetchPoint(q, start, count);
				List<WorkLunchEatery> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<WorkLunchEatery>) execute(action);
	}

}
