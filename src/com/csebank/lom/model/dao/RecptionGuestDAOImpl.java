/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.csebank.lom.model.entity.RecptionGuestTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 接待客人DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class RecptionGuestDAOImpl extends BaseHibernateDAOImpl<RecptionGuest> implements RecptionGuestDAO {

	/**
	 * 构造函数
	 */
	public RecptionGuestDAOImpl(){
		super(RecptionGuestTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RecptionGuest> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rgid"));
		List<RecptionGuest> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rgid 主键
	 * @return 检索结果
	 */
	public RecptionGuest findByPK(Serializable rgid) {

		RecptionGuest result = super.findByPK(rgid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RecptionGuestSearchCond cond){
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
	public List<RecptionGuest> findByCond(final RecptionGuestSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rgid"));
		List<RecptionGuest> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RecptionGuestSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//接待管理ID
		if(cond.getRid()!=null && cond.getRid()!=0){
			c.add(Expression.eq("rid", cond.getRid()));
		}

		return c;
	}

}
