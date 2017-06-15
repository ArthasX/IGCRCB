/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.condition.InvestUseInfoSearchCond;
import com.deliverik.infogovernor.prj.model.dao.InvestUseInfoDAO;

/**
 * 概述:投资使用情况明细操作BL实现 
 * 功能描述：投资使用情况明细操作BL实现
 * 创建人：王廷志
 * 创建记录： 2012-5-22
 * 修改记录：
 */
public class InvestUseInfoBLImpl extends BaseBLImpl implements InvestUseInfoBL{
	
	/** 投资使用情况DAO */
	private InvestUseInfoDAO  investUseInfoDAO;

	/**
	 * 投资使用情况DAO设定
	 * @param investUseInfoDAO 投资使用情况DAO
	 */
	public void setInvestUseInfoDAO(InvestUseInfoDAO investUseInfoDAO) {
		this.investUseInfoDAO = investUseInfoDAO;
	}
	
	public List<InvestUseInfoVW> findAll(InvestUseInfoSearchCond cond){
		return investUseInfoDAO.findAll(cond);
	}
	
	/***
	 * 投资合同明细报表查询
	 * @return
	 */
	public List<InvestContractInfoVW> findInvestContractInfo(){
		return investUseInfoDAO.findInvestContractInfo();
	}
}
