package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.entity.UserRoleTB;

/**
 * 用户角色授权信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class UserRoleTBDAOImpl extends BaseHibernateDAOImpl<UserRole> implements UserRoleTBDAO {

	/**
	 * 构造函数
	 */
	public UserRoleTBDAOImpl(){
		super(UserRoleTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<UserRole> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("userid"));
		List<UserRole> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param urid 主键
	 * @return 检索结果
	 */
	public UserRole findByPK(Serializable urid) {

		UserRole userrole = super.findByPK(urid);
		if(userrole == null) return null;

		return userrole;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserRoleSearchCond cond){

		return (int) findByCond(cond, 0, 0).size();
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<UserRole> findByCond(final UserRoleSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("userid"));
		List<UserRole> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(UserRoleSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//用户ID
		if( !StringUtils.isEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		//角色ID
		if( cond.getRoleid() != null && cond.getRoleid() != 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		return c;
	}

}
