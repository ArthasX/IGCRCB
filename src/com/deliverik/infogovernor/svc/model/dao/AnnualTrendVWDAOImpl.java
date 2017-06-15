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
import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;
import com.deliverik.infogovernor.svc.model.condition.AnnualTrendVWSearchCond;
import com.deliverik.infogovernor.svc.model.entity.AnnualTrendVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:年度工作趋势统计DAO实现
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class AnnualTrendVWDAOImpl extends BaseHibernateDAOImpl<AnnualTrendVWInfo> implements AnnualTrendVWDAO{

	/**
	 * 构造方法
	 */
	public AnnualTrendVWDAOImpl(){
		super(AnnualTrendVW.class);
	}
	
	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public List<AnnualTrendVWInfo> searchAnnualTrendVW(final AnnualTrendVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select 1 as id,");
				query.append(" sum(case when pr.prpdid like '01080%' then 1 else 0 end) as incidentnum,");
				query.append(" sum(case when pr.prpdid like '01083%' then 1 else 0 end) as problemnum,");
				query.append(" sum(case when pr.prpdid like '01084%' then 1 else 0 end) as changenum,");
				query.append(" sum(case when pr.prpdid like '01100%' then 1 else 0 end) as servicenum,");
				query.append(" sum(case when pr.prpdid like 'serviceform%' then 1 else 0 end) as sfnum,");
				query.append(" pr.propentime as propentime ");
				query.append(" from( ");
				query.append(" select pr.prid as prid,pr.prserialnum as prserialnum,substr(pr.propentime, 0, 8)as propentime,pr.prpdid as prpdid,pr.prorgid as orgid ");
				query.append(" from ig500 pr where pr.prpdid not like '01080%' and pr.prstatus = 'C' ");
				query.append(" union all");
				query.append(" select pr.prid as prid,pr.prserialnum as prserialnum,substr(pr.propentime, 0, 8)as propentime,pr.prpdid as prpdid,pi.pivarvalue as orgid ");
				query.append(" from ig500 pr ");
				query.append(" left join ig599 pi on pr.prid = pi.prid and pi.pidid = '0108001022'");
				query.append(" where pr.prpdid like '01080%' and pr.prstatus = 'C' ");
				query.append(" union all");
				query.append(" select sf.sfid as prid,sf.sfcode as prserialnum,substr(sf.sfinstime, 0, 8)as propentime,'serviceform' as prpdid,sf.sfreportorgid as orgid ");
				query.append(" from ig933 sf");
				query.append(" )pr where 1=1 ");
				if(StringUtils.isNotEmpty(cond.getYear())){
					query.append(" and pr.propentime like '" + cond.getYear() +"%'");
				}
				if(StringUtils.isNotEmpty(cond.getOrgid())){
					query.append(" and pr.orgid = '" + cond.getOrgid() +"'");
				}
				query.append(" group by pr.propentime");
				query.append(" order by pr.propentime");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(AnnualTrendVW.class);
				List<AnnualTrendVWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<AnnualTrendVWInfo>) execute(action);
	}
}
