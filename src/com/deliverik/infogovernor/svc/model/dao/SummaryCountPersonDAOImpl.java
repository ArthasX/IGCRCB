/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.entity.IG160VW;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 人员工作量统计DAO实现
 * </p>
 */
public class SummaryCountPersonDAOImpl extends BaseHibernateDAOImpl implements SummaryCountPersonDAO{

	
	public List<IG160Info> searchSummary(SummaryCountPersonSearchCond cond) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select ta.userid as ppuserid,ta.username as ppusername,ta.orgid,ta.orgname,tb.guzhang AS incident,tb.wenti AS problem,tb.biangeng change,tb.qingqiu as ask,tc.gongdan as work ,null as Deployment ");
		sql.append(" from iguser ta");
		sql.append(" left join");
		sql.append(" (SELECT PPUSERID userid,PPUSERNAME,SUM(guzhang) AS guzhang,SUM(wenti) wenti ,SUM(biangeng) biangeng ,SUM(qingqiu) qingqiu  FROM (SELECT A.PRPDID,B.PPUSERID,B.PPUSERNAME,(CASE WHEN (A.PRPDID LIKE '01080%' AND PPSTATUS='W' AND A.PRCLOSETIME IS NOT NULL) THEN 1 ELSE 0 END ) guzhang,(CASE WHEN (A.PRPDID LIKE '01083%' AND PPSTATUS='W' AND A.PRCLOSETIME IS NOT NULL) THEN 1 ELSE 0 END ) wenti,(CASE WHEN (A.PRPDID LIKE '01084%' AND PPSTATUS='T' AND A.PRCLOSETIME IS NOT NULL) THEN 1 ELSE 0 END ) biangeng,(CASE WHEN (A.PRPDID LIKE '01100%' AND PPSTATUS='U' AND A.PRCLOSETIME IS NOT NULL) THEN 1 ELSE 0 END ) qingqiu FROM IG337 B,IG500 A WHERE A.PRID = B.PRID");
		//添加年和月的条件
		if(StringUtils.isNotEmpty(cond.getYear())){
			sql.append(" and A.propentime like '"+cond.getYear()+"/"+cond.getMonth()+"%'");
		}
		sql.append(" ) C GROUP BY PPUSERID,PPUSERNAME order by PPUSERID ) tb on ta.userid = tb.userid");
		sql.append(" left join  (select sfregisterid userid,count(1) gongdan from ig933 ");
		if(StringUtils.isNotEmpty(cond.getYear())){
			sql.append(" where sfinstime like '"+cond.getYear()+"/"+cond.getMonth()+"%'");
		}
		sql.append(" group by sfregisterid ) tc on ta.userid = tc.userid");
		
		
		SQLQuery q = getSession().createSQLQuery(sql.toString());
		
		q.addEntity(IG160VW.class);
		
		//List s = q.list();
		List<IG160Info> list = q.list();
		
		return list;
	}
	

}

