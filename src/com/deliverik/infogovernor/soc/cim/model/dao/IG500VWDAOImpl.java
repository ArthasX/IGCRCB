/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCond;
import com.deliverik.infogovernor.soc.cim.model.entity.IG500VW;

/**
 * 
 * �ʲ��������DAOʵ��
 * 
 */
public class IG500VWDAOImpl extends
		BaseHibernateDAOImpl<IG500VWInfo> implements
		IG500VWDAO {

	/**
	 * ���캯��
	 */
	public IG500VWDAOImpl() {
		super(IG500VW.class);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public List<IG500VWInfo> findByCond(
			final IG500VWSearchCond cond) {
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
				q.addEntity("IG500VW",IG500VW.class);
				List<IG500VWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG500VWInfo>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSql(IG500VWSearchCond cond, StringBuffer query){
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
