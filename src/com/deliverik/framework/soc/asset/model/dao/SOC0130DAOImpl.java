/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.SOC0130TB;
import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;

/**
 * 概述: 设备关系信息（FS-LV-VG）DAO实现
 * 功能描述: 设备关系信息（FS-LV-VG）DAO实现
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class SOC0130DAOImpl extends
BaseHibernateDAOImpl<SOC0130Info> implements SOC0130DAO{
	
	/**
	 * 构造函数
	 */	
	public SOC0130DAOImpl(){
		super(SOC0130TB.class);
	}

	/**
	 * 条件检索处理
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SOC0130Info> searchFsLvVg(final SOC0130SearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("FsLvVgDao.findFsLvVgByVW").getQueryString());
				SQLQuery q = session.createSQLQuery(
						query.toString().replaceAll(":srcreatetime_eq","'"+cond.getSrcreatetime_eq()+"'")
						.replaceAll(":srdomainid_eq","'"+cond.getSrdomainid_eq()+"'") 
						.replaceAll(":srdomainversion_eq","'"+cond.getSrdomainversion_eq()+"'")
						.replaceAll(":srpareiid_eq","'"+cond.getSrpareiid_eq()+"'")
						.replaceAll(":srparversion_eq","'"+cond.getSrparversion_eq()+"'")
						.replaceAll(":srparsmallversion_eq","'"+cond.getSrparsmallversion_eq()+"'")	
				);
				q.setProperties(cond);
				q.addEntity(SOC0130TB.class);
				List<SOC0130TB> list = q.list();
				return list;
			}		
		};
		return (ArrayList<SOC0130Info>)execute(action);
	}
}
