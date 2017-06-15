/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
/**
 * 虚拟化统计分析
 *
 */
public class VIM03CountVWDAOImpl extends BaseHibernateDAOImpl<Integer>
		implements VIM03CountVWDAO {

	public VIM03CountVWDAOImpl(){
		super(Integer.class);
	}

	/**
	 * 检索条数取得
	 *
	 * @param cond 检索条件
	 * @return 检索条数
	 */
	public Integer getCount(final VIM03CountVWSearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("COUNT_VIM03VWDAO.findByCond").getQueryString());
				//追加条件
				getSql(cond, query);
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				List list=q.list();
				session.clear();
				session.close();
				return getCount(list);
			}
			
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 检索条数取得
	 *
	 * @param cond 检索条件
	 * @return 检索条数
	 */
	public Integer getCountByCond(final VIM03CountVWSearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select count(");
				if(StringUtils.isNotEmpty(cond.getCountUser())){
					query.append("distinct userid");
				}else if(StringUtils.isNotEmpty(cond.getCountOrg())){
					query.append("distinct orgsyscoding");
				}else if(StringUtils.isNotEmpty(cond.getCountProj())){
					query.append("distinct pid");
				}else{
					query.append("1");
				}
				query.append(") from vim03 where vim03.progress = '100' ");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				List list=q.list();
				session.clear();
				session.close();
				return getCount(list);
			}
			
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 查询条件
	 * */	
	protected void getSql(VIM03CountVWSearchCond cond,StringBuffer query){
		//用户id
		if(StringUtils.isNotEmpty(cond.getUserid())){
			query.append("and userid = '"+cond.getUserid()+"'");
		}
		//机构码
		if(StringUtils.isNotEmpty(cond.getOrgsyscoding())){
			query.append("and orgsyscoding = '"+cond.getOrgsyscoding()+"'");
		}
		//到期时间
		if(StringUtils.isNotEmpty(cond.getExpirytime_greater())){
			query.append("and expirytime < '"+cond.getExpirytime_greater()+"'");
		}
	}
}
