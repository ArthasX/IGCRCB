package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserSearchCond;

/**
 * 用户信息DAO接口
 * 
 */
public interface UserTBDAO extends BaseHibernateDAO<User> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<User> findAll();

	/**
	 * 主键检索处理
	 * @param userid 主键
	 * @return 检索结果
	 */
	public User findByPK(Serializable userid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<User> findByCond(final UserSearchCond cond, final int start, final int count);
	
	/**
	 * 根据角色ID查询用户
	 * @param roleid
	 * @return
	 */
	public List<UserInfo> searchUserByRoleId(final Integer roleid);
}
