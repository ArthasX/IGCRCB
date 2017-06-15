package com.deliverik.infogovernor.sdl.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.entity.SdlYearSummaryVW;

public class SdlYearSummaryVWDAOImpl extends BaseHibernateDAOImpl<SdlYearSummary> implements SdlYearSummaryVWDAO {

	/**
	 * 服务水平汇总视图构造函数
	 * 
	 */
	public SdlYearSummaryVWDAOImpl(){
		super(SdlYearSummaryVW.class);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SdlYearSummary> findByCond(final SdlYearSummarySearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("SdlYearSummaryVWDAO.sdlYearSummaryQuery").getQueryString());
				if(cond.getEiid()!=null && cond.getEiid()!=0){
					query.append(" and sieiid = :eiid");
				}
				query.append(" group by substr(sibegin,1,4),sieiid,sieiname ) B ON (A.sdieiid=B.sieiid) WHERE  substr(sdiyear,1,4) = :year) yearSummary order by sieiname");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("yearSummary",SdlYearSummaryVW.class);
				setFetchPoint(q, start, count);
				List<SdlYearSummary> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SdlYearSummary>) execute(action);
	}

}
