/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCond;
import com.deliverik.infogovernor.asset.model.entity.RiskVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计查询DAO实现
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class RiskVWDAOImpl extends
BaseHibernateDAOImpl<RiskVWInfo> implements RiskVWDAO {

	/**
	 * 构造函数
	 */
	public RiskVWDAOImpl(){
		super(RiskVW.class);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<RiskVWInfo> findByCond(final RiskVWCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskVW.search").getQueryString());
				
				/**追加 风险名称 查询条件*/
				/**风险名称*/
				/*if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and risk.einame like '%"+cond.getEiname()+"%'");
				}*/
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				//q.setProperties(cond);
				q.addEntity("t",RiskVW.class);
				setFetchPoint(q, 0, 0);
				List<RiskVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskVWInfo>)execute(action);
	}

}
