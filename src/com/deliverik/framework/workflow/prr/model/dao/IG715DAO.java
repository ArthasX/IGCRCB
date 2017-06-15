/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * 服务工单关联流程DAO接口
 */
public interface IG715DAO extends BaseHibernateDAO<IG715Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG715Info> findAll();

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public IG715Info findByPK(Serializable raid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG715SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG715Info> findByCond(final IG715SearchCond cond, final int start, final int count);

	/**
	 * 获取服务工单关联流程实体
	 * @return 服务工单关联流程实体
	 */
	public IG715TB getIG715TBInstance();

}
