/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCond;

/**
 * 服务工单DAO接口
 */
public interface IG933DAO extends BaseHibernateDAO<IG933Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG933Info> findAll();

	/**
	 * 全件检索
	 * @return 检索结果集时间升序
	 */
	public List<IG933Info> findAllAsc();
	
	/**
	 * 主键检索处理
	 * @param sfid 主键
	 * @return 检索结果
	 */
	public IG933Info findByPK(Serializable sfid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG933SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG933Info> findByCond(final IG933SearchCond cond, final int start, final int count);
	

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表时间升序
	 */
	public List<IG933Info> findByCondAsc(final IG933SearchCond cond, final int start, final int count);
	
	 /**
	 * 获取服务工单编号最大值
	 * @param code 服务工单编码类型
	 * @return 服务工单编号最大值
	 */
	public String searchMaxID(String code);
}
