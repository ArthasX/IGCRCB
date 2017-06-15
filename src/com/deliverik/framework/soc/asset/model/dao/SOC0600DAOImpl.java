/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0600SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0600VW;

/**
 * 
 * 资产相关流程DAO实现
 * 
 */
public class SOC0600DAOImpl extends
		BaseHibernateDAOImpl<SOC0600Info> implements
		SOC0600DAO {

	/**
	 * 构造函数
	 */
	public SOC0600DAOImpl() {
		super(SOC0600VW.class);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0600Info> findByCond(
			final SOC0600SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select t2.* from ig731 t1 inner join ig500 t2 on t1.prid = t2.prid ");
				//追加条件
				getSql(cond, query);
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("SOC0600VW",SOC0600VW.class);
				List<SOC0600Info> list=q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SOC0600Info>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSql(SOC0600SearchCond cond, StringBuffer query){
		//资产id
		if( StringUtils.isNotEmpty(cond.getEiid()) ){
			query.append(" and t1.eiid = '"+cond.getEiid()+"' ");
		}
		//流程类型集合
		if( cond.getPrpdid_in() != null && cond.getPrpdid_in().size()>0 ){
			query.append(" and t2.prpdid in( ");
			int i=0;
			for(String prpdid:cond.getPrpdid_in()){
				if(i==0){
					query.append("'"+prpdid+"'");
				}else{
					query.append(",'"+prpdid+"'");
				}
				i++;
			}
			query.append(")");
		}
		//流程类型
		if( StringUtils.isNotEmpty(cond.getPrpdid_eq()) ){
			query.append(" and t2.prpdid = '"+cond.getPrpdid_eq()+"'");
		}
	}
}
