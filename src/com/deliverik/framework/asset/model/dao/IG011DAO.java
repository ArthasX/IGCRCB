package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;




/**
 * 设备统计分析
 */
public interface IG011DAO extends BaseHibernateDAO<IG011Info> {
	
	/** 按照查询条件(所属机构)统计设备信息*/
	public List<IG011Info> findByCond(final IG011SearchCond cond, final int start, final int count);
	
	/** 按照查询条件(使用机构)统计设备信息*/
	public List<IG011Info> findIG011InfoCondByUseOrg(final IG011SearchCond cond, final int start, final int count);

	/**
	 * 根据资产模型层次码统计该资产模型下的资产数量
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG011Info> findByCond(final IG011SearchCond cond);
	
}
