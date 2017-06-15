/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 概述：应急人员就位表DAO实现
 * 功能描述：应急人员就位表DAO实现
 * 创建记录：2014/05/19
 */
public class ParentNodeDAOImpl extends BaseHibernateDAOImpl<Object> implements ParentNodeDAO {
	/**
	 * 构造函数
	 */
	public ParentNodeDAOImpl(){
		super();
	}

	/**
	 * 根据流程id 查询当前节点信息
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchParentNodes(String psdid) {
		
		Session session = getSession();
		String sql = "select p.psdid,p.psdname from ig.ig333 c left join ig.ig333 p on c.ppsdid = p.psdid where c.ppsdid is not null";
		sql+= "  and c.psdid = '"+psdid+"'";
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		q.addScalar("psdid",Hibernate.STRING) ;
		q.addScalar("psdname",Hibernate.STRING) ;
		
		
		return q.list();
	}
	
}