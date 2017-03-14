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
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0604VW;

public class SOC0604DAOImpl extends BaseHibernateDAOImpl<SOC0604Info> implements SOC0604DAO {

	/**
	 * ��������ͳ�Ʒ���
	 * 
	 */
	public SOC0604DAOImpl(){
		super(SOC0604VW.class);
	}
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0604Info> findByCond(final SOC0604SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();		
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("SOC0604DAO.RoomAndContainerQuery").getQueryString());
				getSQL(cond, query);
				//2010.07.22 ���򷽷��޸� songhaiyang
				query.append(" )) ecount ORDER BY room_name,ename,eilabel");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("ecount",SOC0604VW.class);
				setFetchPoint(q, start, count);
				List<SOC0604Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}

		};
		return (List<SOC0604Info>) execute(action);
	}
	

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(SOC0604SearchCond cond, StringBuffer query){
		
		//����ID
		if( cond.getRoomeiid_q()!=null && cond.getRoomeiid_q()!=0){
			query.append("  AND d.room_eiid =:roomeiid_q ");
		}	
		
		
	}
}
