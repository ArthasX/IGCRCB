/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * 资产下拉数据DAO接口
 * 
 */
public interface IG545DAO extends BaseHibernateDAO<IG545Info> {


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG545Info> findByCond(final IG545SearchCond cond, final int start, final int count);
	
	/**
	 * 获取取值范围下拉数据
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG545Bean> findIG545Bean(final IG545SearchCond cond);
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG545SearchCond cond);
}
