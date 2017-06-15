/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 每月盘点DAO接口
 *
 */
public interface InventoryDAO extends BaseHibernateDAO<Inventory> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Inventory> findAll();

	/**
	 * 主键检索处理
	 * @param dadid 主键
	 * @return 检索结果
	 */
	public Inventory findByPK(Serializable lpdid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InventorySearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Inventory> findByCond(final InventorySearchCond cond, final int start, final int count);
	

}
