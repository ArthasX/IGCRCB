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
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentAveSolveTimeSearchCond;
import com.deliverik.infogovernor.svc.model.entity.IncidentAveSolveTimeVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件平均解决时间统计DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IncidentAveSolveTimeVWDAOImpl extends BaseHibernateDAOImpl<IncidentAveSolveTimeVWInfo> 
	implements IncidentAveSolveTimeVWDAO{

	/**
	 * 构造方法
	 */
	public IncidentAveSolveTimeVWDAOImpl(){
		super(IncidentAveSolveTimeVW.class);
	}
	
	/**
	 * 统计数据查询
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<IncidentAveSolveTimeVWInfo> searchSolveTimeData(final IncidentAveSolveTimeSearchCond cond){
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
				String opentime = year + "/" + month + "/" + "__ __:__";
				StringBuffer query = new StringBuffer();
				query.append(" select ");
				query.append(" d.pivarvalue as itype,");
				query.append(" avg(btime) as solveTime");
				query.append(" from (");
				query.append(" select ");
				query.append(" pr.prid,");
				query.append(" pi.pivarvalue,");
				query.append(" (extract(epoch FROM date_trunc('minute', to_timestamp(pp.ppproctime, 'YYYY/MM/DD HH24:MI:SS'))) - extract(epoch FROM date_trunc('minute', to_timestamp(pp.ppbacktime, 'YYYY/MM/DD HH24:MI:SS')))) / 60 as btime");
				query.append(" from ig500 pr");
				query.append(" inner join ig599 pi on pr.prid = pi.prid and pi.pivarname = '故障类型'");
				query.append(" inner join ig337 pp on pr.prid = pp.prid and pp.ppstatus = 'W' and pp.ppbacktime is not null and pp.ppbacktime <> '' and pp.ppproctime is not null and pp.ppproctime <> ''");
				query.append(" where pr.prpdid like :ipdid||'%' and pr.propentime like '");
				query.append(opentime);
				query.append("' ");
				query.append(" )d group by d.pivarvalue order by d.pivarvalue");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(IncidentAveSolveTimeVW.class);
				q.setProperties(cond);
				List list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IncidentAveSolveTimeVWInfo>) execute(action);
	}
}
