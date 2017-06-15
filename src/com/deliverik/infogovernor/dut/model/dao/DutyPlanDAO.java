/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;

/**
 * 值班管理逻辑接口
 *
 */
public interface DutyPlanDAO  extends BaseHibernateDAO<DutyPlan> {
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyPlan> findAll();

	/**
	 * 主键检索处理
	 * @param dpid 主键
	 * @return 检索结果
	 */
	public DutyPlan findByPK(Serializable dpid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyPlanSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyPlan> findByCond(final DutyPlanSearchCond cond, final int start, final int count);

}
