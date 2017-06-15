/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 餐卡信息DAO接口
 *
 */
public interface LunchCardDAO extends BaseHibernateDAO<ItemsCodesSt> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<ItemsCodesSt> findAll();

	/**
	 * 主键检索处理
	 * @param icid 主键
	 * @return 检索结果
	 */
	public ItemsCodesSt findByPK(Serializable icid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final LunchCardSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ItemsCodesSt> findByCond(final LunchCardSearchCond cond, final int start, final int count);
	
	


}
