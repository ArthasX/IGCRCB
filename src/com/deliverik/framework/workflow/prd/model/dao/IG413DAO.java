package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;


/**
 * 流程事件定义信息DAO接口
 * 
 */
public interface IG413DAO extends BaseHibernateDAO<IG413Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG413Info> findAll();

	/**
	 * 主键检索处理
	 * @param pedid 主键
	 * @return 检索结果
	 */
	public IG413Info findByPK(Serializable pedid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG413SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG413Info> findByCond(final IG413SearchCond cond, final int start, final int count);
	
	/**
	 * PEDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getPedidSequenceNextValue(String psdid);

}
