/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;
import com.deliverik.infogovernor.smr.model.condition.ReportHistoryVWSearchCond;
import com.deliverik.infogovernor.smr.model.entity.ReportHistoryVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表历史填报记录视图DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ReportHistoryVWDAOImpl extends BaseHibernateDAOImpl<ReportHistoryVWInfo> implements ReportHistoryVWDAO{

	/**
	 * 构造方法
	 */
	public ReportHistoryVWDAOImpl(){
		super(ReportHistoryVW.class);
	}
	
	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	@SuppressWarnings("unchecked")
	public List<ReportHistoryVWInfo> findByCond(final ReportHistoryVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select pr.prid,rt.key,rt.prtype,rt.reportdesc ");
				query.append("from Regulatoryreportinstance rt ");
				query.append("inner join Regulatoryreportdetail rd on rt.instanceid = rd.instanceid ");
				query.append("inner join ig500 pr on pr.prid = rd.prid and pr.prstatus = '");
				query.append(IGPRDCONSTANTS.PROCESS_END_STATUS);
				query.append("' ");
				query.append(" where 1=1 ");
				getSQL(query,cond);
				query.append(" order by  rt.key desc ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(ReportHistoryVW.class);
				List<ReportHistoryVWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return  (List<ReportHistoryVWInfo>) execute(action);
	}
	
	/**
	 * 查询条件设定
	 * @param query 拼接字符串
	 * @param cond 查询条件实体
	 */
	public void getSQL(StringBuffer query,ReportHistoryVWSearchCond cond){
		if(cond.getCurrentPrid() != null && cond.getCurrentPrid() > 0){
			query.append(" and pr.prid <> ").append(cond.getCurrentPrid());
		}
		if(StringUtils.isNotEmpty(cond.getPdid())){
			query.append(" and rt.prtype = '").append(cond.getPrtype()).append("' ");
		}
		if(StringUtils.isNotEmpty(cond.getPdid())){
			query.append(" and pr.prpdid = '").append(cond.getPdid()).append("' ");
		}
	}
}
