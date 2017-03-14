package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.RoleActionInfo;
import com.deliverik.framework.user.model.condition.RoleActionVWSearchCond;

/**
 * 角色菜单授权信息DAO接口
 * 
 */
public interface RoleActionVWDAO extends BaseHibernateDAO<RoleActionInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RoleActionInfo> findAll();

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public RoleActionInfo findByPK(Serializable raid);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RoleActionInfo> findByCond(final RoleActionVWSearchCond cond, final int start, final int count);
}
