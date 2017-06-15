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

import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.condition.GstockSearchCond;
import com.csebank.lom.model.entity.GstockTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 物品DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class GstockDAOImpl extends BaseHibernateDAOImpl<Gstock> implements GstockDAO {

	/**
	 * 构造函数 
	 */
	public GstockDAOImpl(){
		super(GstockTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Gstock> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("gsid"));
		List<Gstock> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param gsid 主键
	 * @return 检索结果
	 */
	public Gstock findByPK(Serializable gsid) {
		Gstock result = super.findByPK(gsid);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final GstockSearchCond cond){
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
	public List<Gstock> findByCond(final GstockSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("gsid"));
		List<Gstock> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(GstockSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//物品编码
		if(StringUtils.isNotEmpty(cond.getGscode())){
			c.add(Expression.eq("gscode", cond.getGscode()));
		}
		
		//物品名称
		if(StringUtils.isNotEmpty(cond.getGsname())){
			c.add(Expression.like("gsname", "%"+cond.getGsname()+"%"));
		}
		
		//物品种类
		if(StringUtils.isNotEmpty(cond.getGscategory())){
			c.add(Expression.like("gscategory", cond.getGscategory()+"%"));
		}
		
		//所属机构层次码
		if(StringUtils.isNotEmpty(cond.getGsorg())){
			c.add(Expression.eq("gsorg", cond.getGsorg()));
		}
		
		return c;
	}

}
