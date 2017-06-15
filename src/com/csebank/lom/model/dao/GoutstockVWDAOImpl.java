/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.csebank.lom.model.entity.GoutstockVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 物品领用信息视图DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class GoutstockVWDAOImpl extends BaseHibernateDAOImpl<GoutstockVWInfo> implements GoutstockVWDAO {

	/**
	 * 构造函数
	 */
	public GoutstockVWDAOImpl(){
		super(GoutstockVW.class);
	}


	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final GoutstockVWSearchCond cond){
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
	public List<GoutstockVWInfo> findByCond(final GoutstockVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("gsid"));
		List<GoutstockVWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(GoutstockVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//申请单编号
		if(StringUtils.isNotEmpty(cond.getGoreqnum())){
			c.add(Expression.eq("goreqnum", cond.getGoreqnum()));
		}
		
		//物品种类
		if(StringUtils.isNotEmpty(cond.getGocategory())){
			c.add(Expression.like("gocategory", cond.getGocategory()+"%"));
		}
		
		//出库类型
		if(StringUtils.isNotEmpty(cond.getGotype())){
			c.add(Expression.eq("gotype", cond.getGotype()));
		}
		
		
		//状态
		if(StringUtils.isNotEmpty(cond.getGostatus())){
			c.add(Expression.eq("gostatus", cond.getGostatus()));
		}
		
		//所属机构
		if(StringUtils.isNotEmpty(cond.getGoorg())){
			c.add(Expression.eq("goorg", cond.getGoorg()));
		}
		
		return c;
	}

}
