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
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.condition.OrganizationServiceSearchCond;
import com.deliverik.infogovernor.svc.model.entity.OrganizationServiceVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务统计DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class OrganizationServiceDAOImpl extends BaseHibernateDAOImpl<OrganizationServiceVWInfo> implements OrganizationServiceDAO{

	/**
	 * 构造方法
	 */
	public OrganizationServiceDAOImpl(){
		super(OrganizationServiceVW.class);
	}
	
	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<OrganizationServiceVWInfo> searchOrganizationService(final OrganizationServiceSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				String year = "____";
				String month = "__";
				if(StringUtils.isNotEmpty(cond.getYear())){
					year = cond.getYear();
				}
				if(StringUtils.isNotEmpty(cond.getMonth())){
					month = cond.getMonth();
				}
				String opentime = year + "/" + month + "/" + "__ __:__";
				query.append(" select ");
				query.append(" org.orgname as orgname,");
				query.append(" d.incidentCount as incidentCount,");
				query.append(" d.serviceCount as serviceCount, d.gdCount as gdCount,");
				query.append(" d.serviceCount + d.incidentCount + d.gdCount as totalCount");
				query.append(" from ( ");
				query.append(" select ");
				query.append(" a.orgid as orgid,");
				query.append(" sum(inum) as incidentCount,");
				query.append(" sum(snum) as serviceCount,");
				query.append(" sum(gnum) as gdCount");
				query.append(" from (");
				query.append(" select ");
				query.append(" case when pr.prpdid like :ipdid||'%' then substring(pi.pivarvalue from 0 for 11) else substring(pr.prorgid from 0 for 11) end as orgid,");
				query.append(" case when pr.prpdid like :ipdid||'%' then 1 else 0 end as inum,");
				query.append(" case when pr.prpdid like :spdid||'%' then 1 else 0 end as snum,");
				query.append(" 0 as gnum");
				query.append(" from ig500 pr");
				query.append(" left join ig599 pi on pr.prid = pi.prid and pi.pivarname = '报告人科室'");
				query.append(" where pr.propentime like '");
				query.append(opentime);
				query.append("' and (pr.prpdid like :ipdid||'%' or pr.prpdid like :spdid||'%') ");
				query.append(" union all ");
				query.append(" select sforgid,0,0,1 from ig933 ");
				query.append(" where sfstatus = '0002' and sfinstime like '");
				query.append(opentime);
				query.append("' ) a");
				query.append(" group by a.orgid");
				query.append(" ) d");
				query.append(" inner join organization org on org.orgsyscoding = d.orgid ");
				query.append(" order by d.orgid ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(OrganizationServiceVW.class);
				List list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<OrganizationServiceVWInfo>) execute(action);
	}
}
