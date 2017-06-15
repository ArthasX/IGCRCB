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

import com.csebank.lom.model.Goods;
import com.csebank.lom.model.condition.GoodsSearchCond;
import com.csebank.lom.model.entity.GoodsTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 接待管理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class GoodsDAOImpl extends BaseHibernateDAOImpl<Goods> implements GoodsDAO {

	/**
	 * 构造函数
	 */
	public GoodsDAOImpl(){
		super(GoodsTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Goods> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("gid"));
		List<Goods> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rid 主键
	 * @return 检索结果
	 */
	public Goods findByPK(Serializable gid) {

		Goods result = super.findByPK(gid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final GoodsSearchCond cond){
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
	public List<Goods> findByCond(final GoodsSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("gid"));
		List<Goods> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	public List<Goods> findByCond(final String gcategory){
		DetachedCriteria c = getCriteria(gcategory);
		c.addOrder(Order.desc("gid"));
		List<Goods> ret = findByCriteria(c, 0, 0);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(GoodsSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//物品信息ID
		if(cond.getGid()!=null && cond.getGid()!=0){
			c.add(Expression.eq("gid", cond.getGid()));
		}
		
		//物品名称
		if(StringUtils.isNotEmpty(cond.getGname())){
			c.add(Expression.like("gname", "%"+cond.getGname()+"%"));
		}
		
		//物品种类
		if(StringUtils.isNotEmpty(cond.getGcategory())){
			c.add(Expression.like("gcategory", cond.getGcategory()+"%"));
		}
		
		//物品编号
		if(StringUtils.isNotEmpty(cond.getGcode())){
			c.add(Expression.eq("gcode", cond.getGcode()));
		}
		
		//物品状态
		if(StringUtils.isNotEmpty(cond.getGstatus())){
			c.add(Expression.eq("gstatus", cond.getGstatus()));
		}
		
		return c;
	}
	
	protected DetachedCriteria getCriteria(String cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//物品ID
		if(StringUtils.isNotEmpty(cond)){
			c.add(Expression.like("gcode", cond+"%"));
		}
		
		return c;
	}

}
