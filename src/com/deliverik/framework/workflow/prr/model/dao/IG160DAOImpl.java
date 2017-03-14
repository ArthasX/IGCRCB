/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG160VW;

/**
 * <p>����:���������Ա����ͳ�Ʋ�ѯDAOʵ��</p>
 * <p>����������1.������������</p>
 * <p>          2.������������</p>
 * <p>������¼��</p>
 */
public class IG160DAOImpl extends BaseHibernateDAOImpl<IG160Info> implements IG160DAO {

	/**
	 * ���̻�����ͼ���캯��
	 * 
	 */
	public IG160DAOImpl(){
		super(IG160VW.class);
	}
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG160Info> findByCond(final IG160SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG359DAO.searchUserQuery1").getQueryString());
				getSQL(cond, query);
				query.append(session.getNamedQuery("IG359DAO.searchUserQuery2").getQueryString());
				query.append(" ORDER BY ppusername");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG160VW.class);
				setFetchPoint(q, start, count);
				List<IG160Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG160Info>) execute(action);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param query sql
	 * @return �����ü���������
	 */
	protected void getSQL(IG160SearchCond cond, StringBuffer query){
		//�������
		if( StringUtils.isNotEmpty(cond.getOrgid()) ){
			query.append(" AND prorgid like :orgid");
		}	
		//��ʼ����
		if( StringUtils.isNotEmpty(cond.getPropentime_from()) ){
			query.append(" AND propentime >= :propentime_from ");
		}	
		//��������
		if( StringUtils.isNotEmpty(cond.getPropentime_to()) ){
			query.append(" AND propentime <= (:propentime_to||' 23:59') ");
		}	
	}
}
