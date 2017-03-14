/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 接待管理DAO接口
 *
 */
public interface RecptionDAO extends BaseHibernateDAO<Recption> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Recption> findAll();

	/**
	 * 主键检索处理
	 * @param rid 主键
	 * @return 检索结果
	 */
	public Recption findByPK(Serializable rid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RecptionSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Recption> findByCond(final RecptionSearchCond cond, final int start, final int count);
	
	/**
	 * 根据客户姓名，客户单位查询接待工作信息
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 接待工作信息
	 */
	public List<GuestRecption> findByGuestInfoCond(final RecptionGuestInfoCond cond, final int start, final int count);
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getRecptionSearchCount(RecptionGuestInfoCond cond);

}
