package com.deliverik.framework.asset.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.asset.model.entity.IG601VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 机房信息视图DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG601DAOImpl extends BaseHibernateDAOImpl<IG601Info> implements IG601DAO {

	/**
	 * 构造函数
	 * 
	 */
	public IG601DAOImpl(){
		super(IG601VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG601SearchCond cond){
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
	public List<IG601Info> findByCond(final IG601SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//c.addOrder(Order.asc("eiid"));
		//c.addOrder(Order.asc("eilabel"));
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		//按照设备名称升序排列
		c.addOrder(Order.asc("einame"));
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		List<IG601Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG601SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getEiid()!=null) {
			c.add(Expression.eq("eiid", cond.getEiid()));
		}
		
		if (StringUtils.isNotEmpty(cond.getRelateroom())){
		    c.add(Expression.eq("relateroom", cond.getRelateroom()));
		}

		return c;
	}
}
