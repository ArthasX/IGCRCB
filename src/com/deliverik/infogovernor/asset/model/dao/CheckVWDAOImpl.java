/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckVWCond;
import com.deliverik.infogovernor.asset.model.entity.CheckVW;

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
public class CheckVWDAOImpl extends
BaseHibernateDAOImpl<CheckVWInfo> implements CheckVWDAO {

	/**
	 * 构造函数
	 */
	public CheckVWDAOImpl(){
		super(CheckVW.class);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<CheckVWInfo> findByCond(final CheckVWCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CheckVW.search").getQueryString());
				
				/**追加 风险名称 查询条件*/
				/**风险名称*/
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and t.syscoding in ("+cond.getSyscoding()+")");
				}
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("t",CheckVW.class);
				setFetchPoint(q, 0, 0);
				List<CheckVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckVWInfo>)execute(action);
	}

}
