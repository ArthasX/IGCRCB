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
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;

/**
 * ����:��ظ澯ip��ͼDAOʵ��
 * ��������: ��ظ澯ip��ͼDAOʵ��
 * �����ˣ�����
 * ������¼: 2014/04/01
 * �޸ļ�¼: 
 */

public class MonitoringAlarmIPVWDAOImpl extends BaseHibernateDAOImpl<SOC0107Info>
		implements MonitoringAlarmIPVWDAO {

	public MonitoringAlarmIPVWDAOImpl(){
		super(SOC0107TB.class);
	}

	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append("select ci.* from SOC0107 ci ");
				query.append("right join  ");
				query.append("(select c.cid  from SOC0109 c where c.cname like 'IP��ַ%') c on c.cid = ci.cid ");
				query.append("right join SOC0118 ei on ci.eiid = ei.eiid and ci.civersion = ei.eiversion ");
				query.append("where 1=1 ");
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append("and ci.eiid = "+ Integer.valueOf(cond.getEiid()));
				}
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("SOC0107TB",SOC0107TB.class);
				List<SOC0107Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<SOC0107Info>)execute(action);
	}
}
