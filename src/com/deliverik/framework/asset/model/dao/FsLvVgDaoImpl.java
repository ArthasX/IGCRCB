/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.FsLvVgInfo;
import com.deliverik.framework.asset.FsLvVgTB;
import com.deliverik.framework.asset.model.condition.FsLvVgSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 概述: 设备关系信息（FS-LV-VG）DAO实现
 * 功能描述: 设备关系信息（FS-LV-VG）DAO实现
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class FsLvVgDaoImpl extends
BaseHibernateDAOImpl<FsLvVgInfo> implements FsLvVgDao{
	
	/**
	 * 构造函数
	 */
	public FsLvVgDaoImpl(){
		super(FsLvVgTB.class);
	}

	/**
	 * 条件检索处理
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<FsLvVgInfo> searchFsLvVg(final FsLvVgSearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("FsLvVgDao.findFsLvVgByVW").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(FsLvVgTB.class);
				List<FsLvVgTB> list = q.list();
				session.clear();
				session.close();
				return list;
			}		
		};
		return (ArrayList<FsLvVgInfo>)execute(action);
	}
	

}
