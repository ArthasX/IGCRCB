package com.deliverik.infogovernor.sdl.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.entity.IncidentKpiVW;

public class IncidentKpiVWDAOImpl extends BaseHibernateDAOImpl<IncidentKpi> implements IncidentKpiVWDAO {

	/**
	 * 事件kpi汇总视图构造函数
	 * 
	 */
	public IncidentKpiVWDAOImpl(){
		super(IncidentKpiVW.class);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IncidentKpi> findByCond(final IncidentKpiSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				//显示方式
				String namedQuery = "IncidentKpiVWDAO.QueryByType";//事件类别
				String radioValue = cond.getRadioValue();
				List<IncidentKpi> idList= new ArrayList<IncidentKpi>(); //自定义事件
				if("B".equals(radioValue)){
					//紧急程度
					namedQuery = "IncidentKpiVWDAO.QueryByUrgency";
				}else if("C".equals(radioValue)){
					//事件类别+紧急程度
					namedQuery = "IncidentKpiVWDAO.QueryByTypeAndUrgency";
				}else if("D".equals(radioValue)){
					//紧急程度+事件类别
					namedQuery = "IncidentKpiVWDAO.QueryByUrgencyAndType";
				}else{
					StringBuffer queryID = new StringBuffer();
					String namedQueryID = "IncidentKpiVWDAO.QueryIDByType";//自定义事件类别
					queryID.append(session.getNamedQuery(namedQueryID).getQueryString());
					SQLQuery q = session.createSQLQuery(queryID.toString());

					q.setProperties(cond);
					q.addEntity("IncidentKpi",IncidentKpiVW.class);
					setFetchPoint(q, start, count);
					idList = q.list();
					if(idList == null || idList.size()==0){
						IncidentKpiVW vw = new IncidentKpiVW();
						vw.setTypeName("");
						vw.setResolve(0f);
						idList.add(vw);
					}
				}
				query.append(session.getNamedQuery(namedQuery).getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IncidentKpi",IncidentKpiVW.class);
				setFetchPoint(q, start, count);
				List<IncidentKpi> list = q.list();
				list.addAll(idList);
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IncidentKpi>) execute(action);
	}

}
