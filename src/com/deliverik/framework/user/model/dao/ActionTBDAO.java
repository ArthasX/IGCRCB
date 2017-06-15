package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.condition.ActionSearchCond;

/**
 * 菜单信息DAO接口
 * 
 */
public interface ActionTBDAO extends BaseHibernateDAO<Action> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Action> findAll();

	/**
	 * 主键检索处理
	 * @param actname 主键
	 * @return 检索结果
	 */
	public Action findByPK(Serializable actname);
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ActionSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Action> findByCond(final ActionSearchCond cond, final int start, final int count);
	
	/**
	 * 查询用户菜单权限
	 * @param userid 用户ID
	 * @return 检索结果列表
	 */
	public List<Action> findUserAction(final String userid);
	
	/**
     * 子菜单的主键值取得
     * 
     * @param 父菜单的主键
     * @return 子菜单的主键值
     */
    public String getActnameNextValue(String parActname);
}
