package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;

/**
 * 机构信息DAO接口
 * 
 */
public interface OrganizationTBDAO extends BaseHibernateDAO<Organization> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Organization> findAll();

	/**
	 * 主键检索处理
	 * @param orgid 主键
	 * @return 检索结果
	 */
	public Organization findByPK(Serializable orgid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final OrganizationSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索处理，页面树形显示机构用
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond);
	
	/**
	 * 条件检索处理，新增机构下级用
	 * @param cond 检索条件
	 * @param orgsyscoding 机构层次码
	 * @return 检索结果列表
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond,final String orgsyscoding);
	
}
