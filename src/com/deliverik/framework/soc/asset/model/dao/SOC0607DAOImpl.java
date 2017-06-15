/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0607VW;

/**
 * 概述:资产项关系信息实体
 * 功能描述：资产项关系信息实体
 * 创建人：付彬
 * 创建记录： 2013-10-21
 * 修改记录：
 */

public class SOC0607DAOImpl extends BaseHibernateDAOImpl<SOC0119Info> implements
		SOC0607DAO {

	public SOC0607DAOImpl(){
		super(SOC0607VW.class);
	}

	/**
	 * 主键查询处理
	 *
	 * @param eirid 关系主键
	 * @return SOC0607Info 关系实体
	 */
	@SuppressWarnings("unchecked")
	public SOC0119Info checkExistEntityItemRelation(final Integer eirid){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				SOC0119Info bean = null;
				if(eirid!=null){
					session.flush();
					//获取query
					StringBuffer query = new StringBuffer();
					query.append( session.getNamedQuery("SOC0607DAO.checkExistEntityItemRelation").getQueryString());
					//追加排序
					query.append(" and a.eirid="+eirid );
					//获取SQLQuery
					SQLQuery q = session.createSQLQuery(query.toString());
					q.addEntity("SOC0607VW",SOC0607VW.class);
					List<SOC0119Info> list=q.list();
					session.clear();
					session.close();
					if(list!=null&&list.size()>0&&list.get(0)!=null){
						bean = list.get(0);
					}
				}
				return bean;
			}
			
		};
		return (SOC0119Info)execute(action);
	}
}
