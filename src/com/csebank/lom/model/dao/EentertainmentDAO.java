/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 食堂接待信息DAO接口
 *
 */
public interface EentertainmentDAO extends BaseHibernateDAO<Eentertainment> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Eentertainment> findAll();

	/**
	 * 主键检索处理
	 * @param eeid 主键
	 * @return 检索结果
	 */
	public Eentertainment findByPK(Serializable eeid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EentertainmentSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Eentertainment> findByCond(final EentertainmentSearchCond cond, final int start, final int count);
	
	


}
