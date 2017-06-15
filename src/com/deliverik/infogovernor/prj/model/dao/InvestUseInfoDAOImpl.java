/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.condition.InvestUseInfoSearchCond;
import com.deliverik.infogovernor.prj.model.entity.InvestContractInfoVWTB;
import com.deliverik.infogovernor.prj.model.entity.InvestUseInfoTB;

/**
 * 概述: 投资使用情况导出出DAO实现
 * 功能描述：投资使用情况导出出DAO实现 
 * 创建人：王廷志 
 * 创建记录： 2012-5-22 
 * 修改记录：
 */
public class InvestUseInfoDAOImpl extends BaseHibernateDAOImpl<InvestUseInfoVW>
		implements InvestUseInfoDAO {
	@SuppressWarnings("unchecked")
	
	/**
	 * 查询投资使用情况明细
	 */
	public List<InvestUseInfoVW> findAll(final InvestUseInfoSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();

				query.append(" select pid,ppquality,ptype,pname,pdesc,pstorecode,ltotal,ltotalctsum,ltotalcssum,ltotal1,ltotal2,ltotal3,ltotal4,ltotal5,ltotal6, " );
				query.append(" ltotal7,term, fktotal,bztotal,bztotalctsum,bztotalcssum,bztotal1,bztotal2,bztotal3,bztotal4,bztotal5,bztotal6,bztotal7,ptotal,ptotalctsum, ");
				query.append(" ptotalcssum,ptotal1, ptotal2,ptotal3, ptotal4,ptotal5,ptotal6,ptotal7,ppurpose ");
				query.append(" from (");
				query.append(" 		select pid,ppquality,ppurpose,ptype,pname,pdesc,d.plcid, ");
				query.append("		(d.bzdevelop+d.bzhardware+d.bzsoftware+d.bzproject+d.bzelse+d.bcimplement+d.bcelse) as ltotal, ");
				query.append("		(d.bzdevelop+d.bzhardware+d.bzsoftware+d.bzproject+d.bzelse) as ltotalctsum, ");
				query.append("		(d.bcimplement+d.bcelse) as ltotalcssum, ");
				query.append("		 d.bzdevelop as ltotal1, ");
				query.append("		 d.bzsoftware as ltotal2, ");
				query.append("		 d.bzhardware as ltotal3, ");
				query.append("		 d.bzproject as ltotal4, ");
				query.append("		 d.bzelse as ltotal5, ");
				query.append("		 d.bcimplement as ltotal6, ");
				query.append("		 d.bcelse as ltotal7, ");
				query.append("		(d.plcfirstterm||','||d.plcsecondterm||','||d.plcthirdterm||','||d.plcfourthterm||','||d.plcfifthterm) as term, ");
				query.append("      ((case when e.plbfirst is null then 0 else e.plbfirst end)+ ");
				query.append("		(case when e.plbsecond is null then 0 else e.plbsecond end)+ ");
				query.append("		(case when e.plbthird is null then 0 else e.plbthird end)+ ");
				query.append("		(case when e.plbfourth is null then 0 else e.plbfourth end)+ ");
				query.append("		(case when e.plbfifth is null then 0 else e.plbfifth end)) as fktotal, ");
				query.append("		(select wm_concat(pstorecode) as pstorecode from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as pstorecode, ");
				query.append("		(select sum(a.bzdevelop+a.bzhardware+a.bzsoftware+a.bzproject+a.bzelse+a.bcimplement+a.bcelse) ");
				query.append("			from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal, ");
				query.append("		(select sum(a.bzdevelop+a.bzhardware+a.bzsoftware+a.bzproject+a.bzelse) ");
				query.append("			from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotalctsum, ");
				query.append("		(select sum(a.bcimplement+a.bcelse) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotalcssum, ");
				query.append("		(select sum(a.bzdevelop) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal1, ");
				query.append("		(select sum(a.bzsoftware) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal2, ");
				query.append("		(select sum(a.bzhardware) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal3, ");
				query.append("		(select sum(a.bzproject) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal4, ");
				query.append("		(select sum(a.bzelse) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal5, ");
				query.append("		(select sum(a.bcimplement) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal6, ");
				query.append("		(select sum(a.bcelse) from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = c.pid) as bztotal7, ");
				query.append("		(c.pzdevelop+c.pzhardware+c.pzsoftware+c.pzproject+c.pzelse+c.pcimplement+c.pcelse) as ptotal, ");
				query.append("		(c.pzdevelop+c.pzhardware+c.pzsoftware+c.pzproject+c.pzelse) as ptotalctsum, ");
				query.append("		(c.pcimplement+c.pcelse) as ptotalcssum, ");
				query.append("		 c.pzdevelop as ptotal1, ");
				query.append("		 c.pzsoftware as ptotal2, ");
				query.append("		 c.pzhardware as ptotal3, ");
				query.append("		 c.pzproject as ptotal4, ");
				query.append("		 c.pzelse as ptotal5, ");
				query.append("		 c.pcimplement as ptotal6, ");
				query.append("		 c.pcelse as ptotal7 ");
				query.append("			from project c LEFT JOIN  ");
				query.append("			(select b.* from ( ");
				query.append("							select max(plcid) as plcid,plcpid from projectlogcontract group by plcpid) a,projectlogcontract b ");
				query.append("							where a.plcid=b.plcid) d ON c.pid = d.plcpid ");
				query.append("			LEFT JOIN ");
				query.append("			(select b.* from ( ");
				query.append("							select max(plbid) as plbid,plbpid from projectlogbusiness group by plbpid) a,projectlogbusiness b ");
				query.append("							where a.plbid=b.plbid) e ON c.pid = e.plbpid ");
				query.append("		)");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(InvestUseInfoTB.class);
				List<InvestUseInfoVW> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<InvestUseInfoVW>) execute(action);
	}
	
	/***
	 * 投资合同明细报表查询
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InvestContractInfoVW> findInvestContractInfo(){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select pid,pname,pcode,pstorecode,btitle,pcut,plcnumber,plcsum,plbsum,subnum,(lcount1+lcount2+lcount3+lcount4+lcount5) as lcount, ");
				query.append("        (bcount1+bcount2+bcount3+bcount4+bcount5) as bcount,username  ");
				query.append(" from ( ");
				query.append("		 select pid,pname,pcode,d.plcsum,e.plbsum,username, " );
				query.append("      	(case when project.pzdevelop=0 then '' else '开发,' end || ");
				query.append("      	 case when project.pzhardware=0 then '' else '硬件,' end || ");
				query.append("       	 case when project.pzsoftware=0 then ''else '软件,' end || ");
				query.append("       	 case when project.pzproject=0 then '' else '工程,' end || ");
				query.append("     	     case when project.pzelse=0 then '' else '其他,' end || ");
				query.append("      	 case when project.pcimplement=0 then '' else '实施,' end || ");
				query.append("    	     case when project.pcelse=0 then '' else '其他' end ) as pcut, ");
				query.append("			(select wm_concat(pstorecode) as pstorecode from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = project.pid) as pstorecode, ");
				query.append("			(select wm_concat(btitle) as pstorecode from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = project.pid) as btitle, ");
				query.append("			(select wm_concat(plcnumber) as plcnumber from Budget a,ProjectBudgetRelation b where a.bid=b.bid and b.pid = project.pid) as plcnumber, ");
				query.append("			 case when e.plbplcsum is not null then (d.plcsum-e.plbsum) else d.plcsum end as subnum, ");
				query.append("			 case when d.plcfirst is not null then 1 else 0 end as lcount1, ");
				query.append("			 case when d.plcsecond is not null then 1 else 0 end as lcount2, ");
				query.append("			 case when d.plcthird is not null then 1 else 0 end as lcount3, ");
				query.append("			 case when d.plcfourth is not null then 1 else 0 end as lcount4, ");
				query.append("			 case when d.plcfifth is not null then 1 else 0 end as lcount5, ");
				query.append("			 case when e.plbfirst is not null then 1 else 0 end as bcount1, ");
				query.append("			 case when e.plbsecond is not null then 1 else 0 end as bcount2, ");
				query.append("			 case when e.plbthird is not null then 1 else 0 end as bcount3, ");
				query.append("			 case when e.plbfourth is not null then 1 else 0 end as bcount4, ");
				query.append("			 case when e.plbfifth is not null then 1 else 0 end as bcount5 ");
				query.append("		 from project LEFT JOIN ");
				query.append("			(select b.* from ( ");
				query.append("			 					select max(plcid) as plcid,plcpid from projectlogcontract group by plcpid) a,projectlogcontract b ");
				query.append("						where a.plcid=b.plcid) d ON project.pid = d.plcpid ");
				query.append("					  LEFT JOIN  ");
				query.append("			(select b.* from ( ");
				query.append("								select max(plbid) as plbid,plbpid from projectlogbusiness group by plbpid) a,projectlogbusiness b ");
				query.append("						where a.plbid=b.plbid) e ON project.pid = e.plbpid  ");
				query.append("			 		  LEFT JOIN iguser ON project.prole = iguser.userid ) ");
				query.append(" order by btitle asc ");
				SQLQuery q = session.createSQLQuery(query.toString());
				System.out.println("===================================");
				System.out.println(query.toString());
				System.out.println("===================================");
				q.addEntity(InvestContractInfoVWTB.class);
				List<InvestUseInfoVW> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<InvestContractInfoVW>) execute(action);
	}
}
