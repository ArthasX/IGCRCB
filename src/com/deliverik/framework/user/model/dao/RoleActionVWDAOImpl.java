package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.RoleActionInfo;
import com.deliverik.framework.user.model.condition.RoleActionVWSearchCond;
import com.deliverik.framework.user.model.entity.RoleActionVW;

/**
 * 角色菜单授权信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class RoleActionVWDAOImpl extends BaseHibernateDAOImpl<RoleActionInfo> implements RoleActionVWDAO {

	/**
	 * 构造函数
	 */
	public RoleActionVWDAOImpl(){
		super(RoleActionVW.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RoleActionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("roleid"));
		List<RoleActionInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public RoleActionInfo findByPK(Serializable raid) {

		RoleActionInfo ra = super.findByPK(raid);
		if(ra == null) return null;

		return ra;
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RoleActionInfo> findByCond(final RoleActionVWSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("roleid"));
		List<RoleActionInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RoleActionVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//角色ID
		if( cond.getRoleid() != null && cond.getRoleid() != 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		//菜单ID
		if( !StringUtils.isEmpty(cond.getActname())){
			c.add(Expression.eq("actname", cond.getActname()));
		}
		return c;
	}
}
