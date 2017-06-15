package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;

/**
 * 用户信息DAO接口
 * 
 */
public interface UserInfoVWDAO extends BaseHibernateDAO<UserInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<UserInfo> findAll();

	/**
	 * 主键检索处理
	 * @param userInfoVWPK 主键
	 * @return 检索结果
	 */
	public UserInfo findByPK(Serializable userInfoVWPK);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserInfoSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<UserInfo> findByCond(final UserInfoSearchCond cond, final int start, final int count);
	
	/**
	 * 查询指定角色类型下的所有用户个数
	 * @param cond 检索条件
	 * @return 检索结果个数
	 */
	public int getUserCountByRoleType(final UserInfoSearchCond cond);
	
	/**
	 * 查询指定角色类型下的所有用户
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<User> findUserByRoleType(final UserInfoSearchCond cond, final int start, final int count);
	
}
