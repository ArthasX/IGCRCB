/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.csebank.lom.model.entity.InventoryTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 每月盘点DAO接口实现
 *
 */
@SuppressWarnings("deprecation")
public class InventoryDAOImpl extends BaseHibernateDAOImpl<Inventory> implements InventoryDAO {

	/**
	 * 构造函数
	 */
	public InventoryDAOImpl(){
		super(InventoryTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Inventory> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("goodscategory"));
		List<Inventory> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param lpdid 主键
	 * @return 检索结果
	 */
	public Inventory findByPK(Serializable lpdid) {

		Inventory result = super.findByPK(lpdid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InventorySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Inventory> findByCond(final InventorySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("goodscategory"));
		List<Inventory> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(InventorySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//查询年月
		if(StringUtils.isNotEmpty(cond.getYear())){
			c.add(Expression.eq("inventorydate", cond.getYear() + "/" + cond.getMonth()));
		}
		
		return c;
	}

}
