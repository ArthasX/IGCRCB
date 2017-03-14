/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.asset.model.entity.EiDomainDefVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 概述: 最新版域信息视图DAO实现
 * 功能描述: 最新版域信息视图DAO实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class EiDomainDefVWDAOImpl extends BaseHibernateDAOImpl<EiDomainDefVWInfo>
		implements EiDomainDefVWDAO {
	static Log log = LogFactory.getLog(EiDomainDefVWDAOImpl.class);

	/**
	 * 构造函数
	 */
	public EiDomainDefVWDAOImpl() {
		super(EiDomainDefVW.class);
	}
	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<EiDomainDefVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}
	/**
	 * 根据eiddid查询
	 * @param eiddid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EiDomainDefVWInfo searchEiDomainDefVW(final String eiddid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select ei.eiddid,ei.name,ei.version,ei.description,ei.createtime,ei.updatetime from eidomaindefvw ei where 1=1");
				getSQL(eiddid,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(eiddid);
				q.addEntity("ei", EiDomainDefVW.class);
				 List<EiDomainDefVW> list = q.list();
				session.clear();
				session.close();
				return list.size() > 0 ? list.get(0): null;
			}
		};
		return (EiDomainDefVWInfo)execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(String eiddid,StringBuffer query) {
			// 资产域定义ID
			if (eiddid!= null) {
				query.append(" AND ei.eiddid=" +Integer.parseInt(eiddid));
			}

	}

}
