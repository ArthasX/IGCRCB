package com.deliverik.framework.asset.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.condition.IG912SearchCond;
import com.deliverik.framework.asset.model.entity.IG912VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 设备信息视图DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG912DAOImpl extends BaseHibernateDAOImpl<IG912Info> implements IG912DAO {

	/**
	 * 构造函数
	 * 
	 */
	public IG912DAOImpl(){
		super(IG912VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG912SearchCond cond){
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
	public List<IG912Info> findByCond(final IG912SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		c.addOrder(Order.asc("eilabel"));
		List<IG912Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG912SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getEiid()!=null) {
			c.add(Expression.eq("eiid", cond.getEiid()));
		}

		if (cond.getContainer_eiid()!=null) {
			c.add(Expression.eq("container_eiid", cond.getContainer_eiid()));
		}

		if (StringUtils.isNotEmpty(cond.getEilabel())) {
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}

		if (StringUtils.isNotEmpty(cond.getEiname())) {
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%"));
		}

		if (StringUtils.isNotEmpty(cond.getU_total())) {
			c.add(Expression.eq("u_width", cond.getU_total()));
		}
		
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + "%"));
		}

		if("Y".equals(cond.getInJiguiFlg())){
			c.add(Expression.isNotNull("u_value"));
			c.add(Expression.ne("u_value",""));
		}else if("N".equals(cond.getInJiguiFlg())){
			c.add(Expression.or(Expression.isNull("u_value"), Expression.eq("u_value", "")));
		}
		
		if(StringUtils.isNotEmpty(cond.getInroomFlg())){
			c.add(Expression.eq("inroomFlg", cond.getInroomFlg()));
		}
		
		if(cond.getEiStatuses()!=null){
			c.add(Expression.in("eistatus", cond.getEiStatuses()));
		}
			
		return c;
	}
}
