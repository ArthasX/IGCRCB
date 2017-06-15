/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCond;

/**
 * 值班检查项检查时间逻辑接口
 *
 */
public interface DutyAuditTimeDAO  extends BaseHibernateDAO<DutyAuditTime> {
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyAuditTime> findAll();

	/**
	 * 主键检索处理
	 * @param acrid 主键
	 * @return 检索结果
	 */
	public DutyAuditTime findByPK(Serializable datid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyAuditTimeSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyAuditTime> findByCond(final DutyAuditTimeSearchCond cond, final int start, final int count);
	


}
