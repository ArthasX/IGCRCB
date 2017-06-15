/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;

/**
 * 值班检查管理DAO接口
 */
public interface DutyAuditDefDAO extends BaseHibernateDAO<DutyAuditDef> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyAuditDef> findAll();

	/**
	 * 主键检索处理
	 * @param dadid 主键
	 * @return 检索结果
	 */
	public DutyAuditDef findByPK(Serializable dadid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyAuditDefSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyAuditDef> findByCond(final DutyAuditDefSearchCond cond, final int start, final int count);
	
	

}
