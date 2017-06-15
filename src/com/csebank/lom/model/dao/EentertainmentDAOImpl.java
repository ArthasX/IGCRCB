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

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.csebank.lom.model.entity.EentertainmentTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 食堂接待管理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class EentertainmentDAOImpl extends BaseHibernateDAOImpl<Eentertainment> implements EentertainmentDAO {

	/**
	 * 构造函数
	 */
	public EentertainmentDAOImpl(){
		super(EentertainmentTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Eentertainment> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eedate"));
		List<Eentertainment> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eeid 主键
	 * @return 检索结果
	 */
	public Eentertainment findByPK(Serializable eeid) {

		Eentertainment result = super.findByPK(eeid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EentertainmentSearchCond cond){
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
	public List<Eentertainment> findByCond(final EentertainmentSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eedate"));
		List<Eentertainment> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EentertainmentSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//食堂成本信息开始时间
		if(StringUtils.isNotEmpty(cond.getEetime_from())){
			c.add(Expression.ge("eedate", cond.getEetime_from()));
		}

		//食堂成本信息结束时间
		if(StringUtils.isNotEmpty(cond.getEetime_to())){
			c.add(Expression.le("eedate", cond.getEetime_to()));
		}
		
		if(cond.getRid_mon()!=null && cond.getRid_mon()!=0){
			c.add(Expression.eq("rid", cond.getRid_mon()));
		}
		
		if(cond.getRid_org()!=null && cond.getRid_org()!=0){
			c.add(Expression.eq("rid", cond.getRid_org()));
		}

		return c;
	}

}
