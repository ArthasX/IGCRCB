/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.csebank.lom.model.entity.EworkingLunchTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 食堂工作餐管理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class EworkingLunchDAOImpl extends BaseHibernateDAOImpl<EworkingLunch> implements EworkingLunchDAO {

	/**
	 * 构造函数
	 */
	public EworkingLunchDAOImpl(){
		super(EworkingLunchTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<EworkingLunch> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ewldate"));
		List<EworkingLunch> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param ewlid 主键
	 * @return 检索结果
	 */
	public EworkingLunch findByPK(Serializable ewlid) {

		EworkingLunch result = super.findByPK(ewlid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EworkingLunchSearchCond cond){
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
	public List<EworkingLunch> findByCond(final EworkingLunchSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ewldate"));
		List<EworkingLunch> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EworkingLunchSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//食堂工作餐信息开始时间
		if(StringUtils.isNotEmpty(cond.getEwltime_from())){
			c.add(Expression.ge("ewldate", cond.getEwltime_from()));
		}

		//食堂工作餐信息结束时间
		if(StringUtils.isNotEmpty(cond.getEwltime_to())){
			c.add(Expression.le("ewldate", cond.getEwltime_to()));
		}

		return c;
	}

}
