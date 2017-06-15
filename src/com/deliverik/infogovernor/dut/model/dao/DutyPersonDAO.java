/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;

/**
 * 值班管理逻辑接口
 *
 */
public interface DutyPersonDAO  extends BaseHibernateDAO<DutyPerson> {
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyPerson> findAll();

	/**
	 * 主键检索处理
	 * @param dperid 主键
	 * @return 检索结果
	 */
	public DutyPerson findByPK(Serializable dperid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyPersonSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyPerson> findByCond(final DutyPersonSearchCond cond, final int start, final int count);

}
