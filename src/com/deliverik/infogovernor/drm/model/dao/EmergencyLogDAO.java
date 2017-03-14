/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;

/**
 * 概述：应急日志信息表DAO接口
 * 功能描述：应急日志信息表DAO接口
 * 创建记录：2014/05/19
 * (1)升序与降序排序条件以EmergencyLogTB中的字段列为主且这里只是简单排序没涉及复杂关系
 * 修改记录：
 */
public interface EmergencyLogDAO extends BaseHibernateDAO<EmergencyLogInfo> {
	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EmergencyLogInfo> findAll();
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EmergencyLogInfo findByPK(Serializable pk);
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EmergencyLogSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EmergencyLogInfo> findByCond(final EmergencyLogSearchCond cond, final int start, final int count);
}