package com.deliverik.framework.asset.model.dao;



import java.util.List;

import com.deliverik.framework.asset.model.IG790Info;
import com.deliverik.framework.asset.model.condition.IG790SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;





/**
 * 机房机柜统计分析
 */
public interface IG790DAO extends BaseHibernateDAO<IG790Info> {
	
	public List<IG790Info> findByCond(final IG790SearchCond cond, final int start, final int count);
}
