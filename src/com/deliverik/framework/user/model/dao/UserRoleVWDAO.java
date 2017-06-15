package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

/**
 * 用户角色授权信息DAO接口
 * 
 */
public interface UserRoleVWDAO extends BaseHibernateDAO<UserRoleInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<UserRoleInfo> findAll();

	/**
	 * 主键检索处理
	 * @param urid 主键
	 * @return 检索结果
	 */
	public UserRoleInfo findByPK(Serializable urid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserRoleVWSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<UserRoleInfo> findByCond(final UserRoleVWSearchCond cond, final int start, final int count);
	
	/**
	 * 查询流程定义中所需要的人员和角色信息
	 * @param pdid
	 * @return
	 */
	public List<UserRoleInfo> findByPdid(String pdid);
}
