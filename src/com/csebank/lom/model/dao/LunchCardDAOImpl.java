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

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.csebank.lom.model.entity.ItemsCodesStTB;
import com.csebank.lom.util.CodeUtils;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 食堂成本管理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class LunchCardDAOImpl extends BaseHibernateDAOImpl<ItemsCodesSt> implements LunchCardDAO {

	/**
	 * 构造函数
	 */
	public LunchCardDAOImpl(){
		super(ItemsCodesStTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<ItemsCodesSt> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("typecode"));
		List<ItemsCodesSt> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public ItemsCodesSt findByPK(Serializable icid) {

		ItemsCodesSt result = super.findByPK(icid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final LunchCardSearchCond cond){
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
	public List<ItemsCodesSt> findByCond(final LunchCardSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("icid"));
		List<ItemsCodesSt> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(LunchCardSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//餐卡名称
		if(StringUtils.isNotEmpty(cond.getTypename())){
			c.add(Expression.like("typename", "%"+cond.getTypename()+"%"));
		}
		
		//餐卡状态
		if(StringUtils.isNotEmpty(cond.getDesc())){
			c.add(Expression.eq("desc", cond.getDesc()));
		}
		
		//餐卡编号
		if(!"null".equals(String.valueOf(cond.getIcid()))){
			c.add(Expression.eq("icid", cond.getIcid()));
		}
		c.add(Expression.eq("selectid", CodeUtils.CARD_CATEGORY));
		return c;
	}

}
