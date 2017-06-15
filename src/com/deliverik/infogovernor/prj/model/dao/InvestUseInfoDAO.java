/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.condition.InvestUseInfoSearchCond;

/**
 * 概述: 投资使用情况导出出DAO接口
 * 功能描述：投资使用情况导出出DAO接口
 * 创建人：王廷志
 * 创建记录： 2012-5-22
 * 修改记录：
 */
public interface InvestUseInfoDAO extends BaseHibernateDAO<InvestUseInfoVW>{
	/**
	 * 查询投资使用情况明细
	 */
	public List<InvestUseInfoVW> findAll(final InvestUseInfoSearchCond cond);
	
	/***
	 * 投资合同明细报表查询
	 * @return
	 */
	public List<InvestContractInfoVW> findInvestContractInfo();
}
