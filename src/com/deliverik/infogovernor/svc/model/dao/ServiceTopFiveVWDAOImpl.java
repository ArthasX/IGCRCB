/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.model.condition.ServiceTopFiveSearchCond;
import com.deliverik.infogovernor.svc.model.entity.ServiceTopFiveVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务top统计DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ServiceTopFiveVWDAOImpl extends BaseHibernateDAOImpl<ServiceTopFiveVWInfo> 
	implements ServiceTopFiveVWDAO{ 

	/**
	 * 构造方式
	 */
	public ServiceTopFiveVWDAOImpl(){
		super(ServiceTopFiveVW.class);
	}
	
	/**
	 * 统计数据查询
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceTopFiveVWInfo> searchServiceDate(final ServiceTopFiveSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				String year = "____";
				String month = "__";
				if(StringUtils.isNotEmpty(cond.getYear())){
					year = cond.getYear();
				}
				if(StringUtils.isNotEmpty(cond.getMonth())){
					month = cond.getMonth();
				}
				String opentime = year + "/" + month + "/__ __:__";
				StringBuffer query = new StringBuffer();
				query.append(" select ");
				query.append(" b.id as id,");
				query.append(" b.icount as icount,");
				query.append(" b.scount as scount,");
				query.append(" b.fcount as fcount,");
				query.append(" b.orgid as orgid,");
				query.append(" b.orgname as orgname,");
				query.append(" b.totalCount");
				query.append(" from(");
				query.append(" select ");
				query.append(" (row_number() OVER ()) as id,");
				query.append(" a.icount,");
				query.append(" a.scount,");
				query.append(" a.fcount,");
				query.append(" a.orgid,");
				query.append(" a.icount + a.scount + a.fcount as totalCount,");
				query.append(" org.orgname");
				query.append(" from (");
				query.append(" select ");
				query.append(" sum(case when d.pdid like :ipdid||'%' then 1 else 0 end) as icount,");
				query.append(" sum(case when d.pdid like :spdid||'%' then 1 else 0 end) as scount,");
				query.append(" sum(case when d.pdid = 'SF' then 1 else 0 end) as fcount,");
				query.append(" d.orgid");
				query.append(" from (");
				query.append(" select ");
				query.append(" case when pr.prpdid like :ipdid||'%' then substring(pi.pivarvalue from 0 for 11) else pr.prorgid end as orgid,");
				query.append(" pr.prpdid as pdid");
				query.append(" from ig500 pr");
				query.append(" left join ig599 pi on pr.prid = pi.prid and pi.pivarname = '报告人科室' ");
				query.append(" where pr.propentime like '");
				query.append(opentime);
				query.append("'");
				query.append(" union all");
				query.append(" select s.sfreportorgid as orgid,");
				query.append(" 'SF' as pdid");
				query.append(" from ig933 s");
				query.append(" where s.sfinstime like '");
				query.append(opentime);
				query.append("'");
				query.append(" ) d group by d.orgid )a");
				query.append(" inner join organization org on org.orgsyscoding = a.orgid");
				query.append(" order by ");
				query.append(cond.getType());
				query.append(" desc ");
				query.append(" )b where id <= 5");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(ServiceTopFiveVW.class);
				List list = q.list();
				setFetchPoint(q, 0, 0);
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<ServiceTopFiveVWInfo>) execute(action);
	}
}
