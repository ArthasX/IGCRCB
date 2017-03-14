/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.condition.EquipmentInquireVWSearchCond;

/**
 * 概述:3D机房支持IP查询 
 * 功能描述：3D机房支持IP查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-01-31
 * 修改记录：
 */
public interface EquipmentInquireVWDAO extends BaseHibernateDAO<EquipmentInquireVWInfo>{

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EquipmentInquireVWInfo> getEquipmentAndIP(final EquipmentInquireVWSearchCond cond, final int start, final int count);
	/**
	 * 条件检索处理条数获得
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索条数
	 */
	public int getEquipmentAndIPCount(final EquipmentInquireVWSearchCond cond);
}
