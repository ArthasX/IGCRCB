/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;
import com.deliverik.infogovernor.asset.model.entity.IG342VW;

/**
  * ����: IG342DAOʵ��
  * ��������: IG342DAOʵ��
  * ������¼: 2012/08/03
  * �޸ļ�¼: 
  */
public class IG342DAOImpl extends
		BaseHibernateDAOImpl<IG342Info> implements IG342DAO {

	/**
	 * ���캯��
	 */
	public IG342DAOImpl(){
		super(IG342VW.class);
	}


	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG342Info> findByCond(final IG342SearchCond cond, final int start, final int count){
		return findByCriteria(cond, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	@SuppressWarnings("unchecked")
	public List<IG342Info> findByCriteria(final IG342SearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws

			HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemAndConfigItemVWDAO.searchUsageStatistics").getQueryString());
				//���ݷ����̵Ǽ���ʼʱ���ѯ
				if(StringUtils.isNotEmpty(cond.getBeginTime_q())){
//					query.append(" and eiinsdate >= '" + cond.getBeginTime_q() +"'");
					query.append(" and eiupdtime >= '" + cond.getBeginTime_q() +" 00:00'");
				}
				//���ݷ����̵Ǽ���ֹʱ���ѯ
				if(StringUtils.isNotEmpty(cond.getEndTime_q())){
//					query.append(" and eiinsdate <= '" + cond.getEndTime_q() +"'");
					query.append(" and eiupdtime <= '" + cond.getEndTime_q() +" 23:59'");
				}  
				query.append(" and civalue like '��'");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG342VW.class);
				setFetchPoint(q, start, count);
				List<IG342Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG342Info>) execute(action);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final IG342SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemAndConfigItemVWDAO.searchUsageStatistics").getQueryString());
				//���ݷ����̵Ǽ���ʼʱ���ѯ
				if(StringUtils.isNotEmpty(cond.getBeginTime_q())){
					query.append(" and eiupdtime >= '" + cond.getBeginTime_q() +" 00:00'");
				}
				//���ݷ����̵Ǽ���ֹʱ���ѯ
				if(StringUtils.isNotEmpty(cond.getEndTime_q())){
					query.append(" and eiupdtime <= '" + cond.getEndTime_q() +" 23:59'");
				}  
				query.append(" and civalue like '��'");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG342VW.class);
				List<IG342Info> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
}