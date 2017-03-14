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
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.EntityItemFacilitatorVW;
/**
 * 概述:服务商信息视图DAO实现
 * 功能描述: 服务商信息视图DAO实现
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录: 
 */
public class EntityItemFacilitatorVWDAOImpl extends BaseHibernateDAOImpl<EntityItemFacilitatorVWInfo>
		implements EntityItemFacilitatorVWDAO {

	public EntityItemFacilitatorVWDAOImpl(){
		super(EntityItemFacilitatorVW.class);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<EntityItemFacilitatorVWInfo> findByCond(final EntityItemFacilitatorVWSearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("EntityItemFacilitatorVWDAO.entityItemFacilitatorVWDAO").getQueryString());
				//追加条件
				getSql(cond, query);
				//追加排序
				query.append(" order by ei.einame");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("EntityItemFacilitatorVW",EntityItemFacilitatorVW.class);
				List<EntityItemFacilitatorVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<EntityItemFacilitatorVWInfo>)execute(action);
	}
	/**
	 * 查询条件
	 * */	
	protected void getSql(EntityItemFacilitatorVWSearchCond cond,StringBuffer query){
		//公司名称
		if(StringUtils.isNotEmpty(cond.getEiname())){
			query.append(" AND ei.einame like '%"+cond.getEiname()+"%'");
		}
		//机构码
		if(StringUtils.isNotEmpty(cond.getEiorgsyscoding())){
			query.append(" AND ei.eiorgsyscoding like '"+cond.getEiorgsyscoding()+"%'");
		}
		//模型码
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			query.append(" AND ei.esyscoding like '"+cond.getEsyscoding()+"%'");
		}
		//登记日  起始
		if(StringUtils.isNotEmpty(cond.getEiupdtime_from())){
			query.append(" AND ei.eiinsdate >= '"+cond.getEiupdtime_from()+"'");
		}
		//登记日  结束
		if(StringUtils.isNotEmpty(cond.getEiupdtime_to())){
			query.append(" AND ei.eiinsdate <= '"+cond.getEiupdtime_to()+"'");
		}
	}
}
