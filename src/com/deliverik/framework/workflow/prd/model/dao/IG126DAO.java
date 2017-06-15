package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;


/**
 * 流程页面定义信息DAO接口
 * 
 */
public interface IG126DAO extends BaseHibernateDAO<IG126Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG126Info> findAll();

	/**
	 * 主键检索处理
	 * @param pedid 主键
	 * @return 检索结果
	 */
	public IG126Info findByPK(Serializable pedid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG126SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG126Info> findByCond(final IG126SearchCond cond, final int start, final int count);
	
	/**
	 * PJDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PJDID主键值
	 */
	public String getPjdidSequenceNextValue(String pdid);

}
