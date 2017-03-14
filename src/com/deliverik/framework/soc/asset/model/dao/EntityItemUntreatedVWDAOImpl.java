/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;
import com.deliverik.framework.soc.asset.model.entity.EntityItemUntreatedVW;

/**
 * 概述:未上架机柜、空调、ups视图DAO实现
 * 功能描述: 未上架机柜、空调、ups视图DAO实现
 * 创建人：付彬
 * 创建记录: 2013/07/03
 * 修改记录: 
 */

public class EntityItemUntreatedVWDAOImpl extends
		BaseHibernateDAOImpl<EntityItemUntreatedVWInfo> implements
		EntityItemUntreatedVWDAO {
	
	public EntityItemUntreatedVWDAOImpl(){
		super(EntityItemUntreatedVW.class);
	}
	
	/**
	 * 未上架机柜、空调、ups列表取得
	 *
	 * @return list 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<EntityItemUntreatedVWInfo> getToolsData(){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("EntityItemUntreatedVWDAO.EntityItemUntreatedVWDAO").getQueryString());
				//追加排序
//				query.append(" order by A.esyscoding desc,D.civalue,E.civalue desc,A.einame");
				query.append(" order by A.esyscoding desc");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("EntityItemUntreatedVW",EntityItemUntreatedVW.class);
				List<EntityItemUntreatedVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<EntityItemUntreatedVWInfo>)execute(action);
	}
}
