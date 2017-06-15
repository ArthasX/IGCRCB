package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;
import com.deliverik.framework.user.model.entity.RoleActionTB;

/**
 * 角色菜单授权信息DAO接口实现
 * 
 */
@SuppressWarnings("deprecation")
public class RoleActionTBDAOImpl extends BaseHibernateDAOImpl<RoleAction> implements RoleActionTBDAO {

	/**
	 * 构造函数
	 */
	public RoleActionTBDAOImpl(){
		super(RoleActionTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RoleAction> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("roleid"));
		List<RoleAction> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public RoleAction findByPK(Serializable raid) {

		RoleAction ra = super.findByPK(raid);
		if(ra == null) return null;

		return ra;
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RoleActionSearchCond cond){
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
	public List<RoleAction> findByCond(final RoleActionSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("roleid"));
		List<RoleAction> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RoleActionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//角色ID
		if( cond.getRoleid() != null && cond.getRoleid() != 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		//菜单ID
		if( !StringUtils.isEmpty(cond.getActname())) {
			c.add(Expression.eq("actname", cond.getActname()));
		}
		return c;
	}
}
