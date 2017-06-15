/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM06TB;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM06VW;

/**
  * ����: CRM06DAOʵ��
  * ��������: CRM06DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM06DAOImpl extends
		BaseHibernateDAOImpl<CRM06Info> implements CRM06DAO {

	/**
	 * ���캯��
	 */
	public CRM06DAOImpl(){
		super(CRM06TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM06Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM06Info findByPK(Serializable pk) {
		CRM06Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM06SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM06Info> findByCond(final CRM06SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("fingerPrint"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM06SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getServerName())){
			c.add(Expression.eq("servername", cond.getServerName()));
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<CRM06VWInfo> findVWByCond(final CRM06SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append(" select a.serverid ,a.fileid ,a.servername , ");
				query.append(" a.servertype ,a.ip ,a.ip2 ,a.status ,a.host , ");
				query.append(" d.tempcounts ,a.alarmstatus, a.fingerprint,a.hqserverid,a.hqservername ");
				query.append(" from crm06 a left join  ");
				query.append(" (select b.serverid,count(*) tempcounts ");
				query.append(" from crm06 b join crm09 c ");
				query.append(" on b.serverid = c.serverid group by b.serverid) d ");
				query.append(" on a.serverid = d.serverid where 1=1 ");
				
				getSQL(cond, query);
				
				query.append(" order by a.servername,a.ip ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(CRM06VW.class);
				setFetchPoint(q, start, count);
				session.clear();
				return q.list();
			}
		};
		return (List<CRM06VWInfo>) execute(action);
	}
	
	public int getSearchVWCount(final CRM06SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append(" select  count(*) ");
				query.append(" from crm06 a left join  ");
				query.append(" (select b.serverid,count(*) tempcounts ");
				query.append(" from crm06 b join crm09 c ");
				query.append(" on b.serverid = c.serverid group by b.serverid) d ");
				query.append(" on a.serverid = d.serverid where 1=1 ");
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	
	public List<String> getSearchVWByInstance(final CRM06SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append(" select hqservername from crm06 group by hqservername ");
				query.append(" union all ");
				query.append(" select ip from hq_alert_list_detail_view group by ip ");
				SQLQuery q = session.createSQLQuery(query.toString());
				
				List<String> list = q.list();
				
				session.clear();
				
				
				return list;
			}
		};
		return (List<String>) execute(action);
	}

	protected void getSQL(CRM06SearchCond cond, StringBuffer query) {
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			query.append(" and (a.ip like '%"+cond.getIp_like()+"%' or a.ip2 like '%"+cond.getIp_like()+"%') ");
		}
		if(StringUtils.isNotEmpty(cond.getServerName_like())){
			query.append(" and a.servername like '%"+cond.getServerName_like()+"%' ");
		}
		if(StringUtils.isNotEmpty(cond.getFileid_eq())){
			query.append(" and a.fileid = "+ cond.getFileid_eq());
		}
		if(StringUtils.isNotEmpty(cond.getServerName())){
			query.append(" and a.servername = '"+cond.getServerName()+"' ");
		}
	}

}