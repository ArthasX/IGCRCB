package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;

/**
 * 角色信息DAO接口
 * 
 */
public interface RoleTBDAO extends BaseHibernateDAO<Role> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Role> findAll();

	/**
	 * 主键检索处理
	 * @param roleid 主键
	 * @return 检索结果
	 */
	public Role findByPK(Serializable roleid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RoleSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Role> findByCond(final RoleSearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索记录数
	 * @return 条件检索记录数
	 */
	public int searchRoleCountForSelfDef(final RoleSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Role> searchRoleForSelfDef(final RoleSearchCond cond, final int start, final int count);
}
