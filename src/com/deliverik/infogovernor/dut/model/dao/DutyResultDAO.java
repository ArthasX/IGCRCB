/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;

/**
 * 值班检查内容DAO接口
 */
public interface DutyResultDAO extends BaseHibernateDAO<DutyResult> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyResult> findAll();

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public DutyResult findByPK(Serializable rcid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyResultSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyResult> findByCond(final DutyResultSearchCond cond, final int start, final int count);
	
	
}
