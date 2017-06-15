/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG808Info;

/**
 * <p>概述:首页上按部门统计工作数量查询DAO接口</p>
 * <p>功能描述：获取sql执行查询</p>
 * <p>创建记录：宋海洋 2010/11/13</p>
 */

public interface IG808DAO extends BaseHibernateDAO<IG808Info> {

	/**
	 * 功能：获取工作数量
	 * @return 检索结果列表
	 */
	public List<IG808Info> findIG808Info();

}
