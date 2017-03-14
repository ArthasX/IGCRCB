/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0600SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0600VW;

/**
 * 
 * �ʲ��������DAOʵ��
 * 
 */
public class SOC0600DAOImpl extends
		BaseHibernateDAOImpl<SOC0600Info> implements
		SOC0600DAO {

	/**
	 * ���캯��
	 */
	public SOC0600DAOImpl() {
		super(SOC0600VW.class);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0600Info> findByCond(
			final SOC0600SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append("select t2.* from ig731 t1 inner join ig500 t2 on t1.prid = t2.prid ");
				//׷������
				getSql(cond, query);
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("SOC0600VW",SOC0600VW.class);
				List<SOC0600Info> list=q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SOC0600Info>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSql(SOC0600SearchCond cond, StringBuffer query){
		//�ʲ�id
		if( StringUtils.isNotEmpty(cond.getEiid()) ){
			query.append(" and t1.eiid = '"+cond.getEiid()+"' ");
		}
		//�������ͼ���
		if( cond.getPrpdid_in() != null && cond.getPrpdid_in().size()>0 ){
			query.append(" and t2.prpdid in( ");
			int i=0;
			for(String prpdid:cond.getPrpdid_in()){
				if(i==0){
					query.append("'"+prpdid+"'");
				}else{
					query.append(",'"+prpdid+"'");
				}
				i++;
			}
			query.append(")");
		}
		//��������
		if( StringUtils.isNotEmpty(cond.getPrpdid_eq()) ){
			query.append(" and t2.prpdid = '"+cond.getPrpdid_eq()+"'");
		}
	}
}
