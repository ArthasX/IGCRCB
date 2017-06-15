/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.orl.model.OrealAlertInfo;
import com.deliverik.orl.model.condition.OrealAlertSearchCond;

/**
 * 概述：欧莱雅告警表DAO接口
 * 功能描述：欧莱雅告警表DAO接口
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
public interface OrealAlertDAO extends BaseHibernateDAO<OrealAlertInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OrealAlertInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public OrealAlertInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws Exception 
	 */
	public int getSearchCount(final OrealAlertSearchCond cond) throws BLException;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws Exception 
	 */
	public List<OrealAlertInfo> findByCond(final OrealAlertSearchCond cond, final int start, final int count) throws BLException;
}