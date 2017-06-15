/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.condition.EquipmentInquireVWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.EquipmentInquireVW;

/**
 * 概述:3D机房支持IP查询 
 * 功能描述：3D机房支持IP查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-01-31
 * 修改记录：
 */
public class EquipmentInquireVWDAOImpl extends BaseHibernateDAOImpl<EquipmentInquireVWInfo> implements EquipmentInquireVWDAO {

	@SuppressWarnings("unchecked")
	public List<EquipmentInquireVWInfo> getEquipmentAndIP(
		final EquipmentInquireVWSearchCond cond, final int start,final int count) {
		 HibernateCallback action = new HibernateCallback() {
	           public Object doInHibernate(Session session) throws HibernateException, SQLException {
	               session.flush();
	               StringBuffer query = new StringBuffer();
	               query.append( session.getNamedQuery("EquipmentInquireVWDAO.getEquipmentAndIP").getQueryString());
	               if(StringUtils.isNotEmpty(cond.getBusinesssys())){
	            	   query.append(" and  temp2.civalue1 like '%"+cond.getBusinesssys()+"%'");
	               }
	               if(StringUtils.isNotEmpty(cond.getIp())){
	            	   query.append(" and  temp2.civalue3 like '%"+cond.getIp()+"%'");
	               }
	               if(cond.getComputerContainerId()!=null){
	            	   query.append(" and  temp2.creiid  = "+cond.getComputerContainerId());
	               }
	               if(StringUtils.isNotEmpty(cond.getComputerContainer())){
	            	   query.append(" and temp2.einame2 like '%"+cond.getComputerContainer()+"%'");
	               }
	               SQLQuery q = session.createSQLQuery(query.toString());
	               q.addEntity("EquipmentInquireVW",EquipmentInquireVW.class);
	               setFetchPoint(q, start, count);
	               List<EquipmentInquireVWInfo> list = q.list();
	               session.clear();
	               return list;
	           }
	       };
		return (List<EquipmentInquireVWInfo>) execute(action);
	}

	public int getEquipmentAndIPCount( final EquipmentInquireVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append("select count(*) from(");
				query.append( session.getNamedQuery("EquipmentInquireVWDAO.getEquipmentAndIP").getQueryString());												
				if(StringUtils.isNotEmpty(cond.getBusinesssys())){
	            	   query.append(" and temp2.civalue1 like '%"+cond.getBusinesssys()+"%'");
	               }
	               if(StringUtils.isNotEmpty(cond.getIp())){
	            	   query.append(" and temp2.civalue3 like '%"+cond.getIp()+"%'");
	               }
	               if(StringUtils.isNotEmpty(cond.getComputerContainer())){
	            	   query.append(" and temp2.einame2 like '%"+cond.getComputerContainer()+"%'");
	               }
	               if(cond.getComputerContainerId()!=null){
	            	   query.append(" and  temp2.creiid  = "+cond.getComputerContainerId());
	               }
	            query.append(")temp5");  
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	



}
