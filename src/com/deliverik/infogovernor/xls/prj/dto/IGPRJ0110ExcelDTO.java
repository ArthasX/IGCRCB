/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.prj.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;

/**
 * 概述: 投资合同明细导出dto
 * 功能描述：投资合同明细导出dto
 * 创建人：王廷志
 * 创建记录： 2012-5-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGPRJ0110ExcelDTO extends ExcelDTO{
	/** 投资合同明细集合 */
	private List<InvestContractInfoVW> investContractList;

	/**
	 * 投资合同明细集合取得
	 * @return investContractList 投资合同明细集合
	 */
	public List<InvestContractInfoVW> getInvestContractList() {
		return investContractList;
	}

	/**
	 * 投资合同明细集合设定
	 * @param investContractList 投资合同明细集合
	 */
	public void setInvestContractList(List<InvestContractInfoVW> investContractList) {
		this.investContractList = investContractList;
	}
}
