package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;




/**
 * 设备统计分析
 */
public interface IG445DAO extends BaseHibernateDAO<IG445Info> {
	
	/** 按照查询条件(所属机构)统计设备信息*/
	public List<IG445Info> findByCond(final IG445SearchCond cond, final int start, final int count);
	

}
