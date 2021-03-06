/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 概述: 最新版域信息视图DAO接口
 * 功能描述: 最新版域信息视图DAO接口
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface EiDomainDefVWDAO extends BaseHibernateDAO<EiDomainDefVWInfo> {
	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiDomainDefVWInfo> findAll();

	
	/**
	 * 根据eiddid查询
	 * @param eiddid
	 * @return
	 */
	public EiDomainDefVWInfo searchEiDomainDefVW(String eiddid);

}
