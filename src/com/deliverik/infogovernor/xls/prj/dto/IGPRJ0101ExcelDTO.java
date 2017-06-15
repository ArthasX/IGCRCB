/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.prj.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;

/**
 * 概述: 投资使用情况报表导出DTO
 * 功能描述：投资使用情况报表导出DTO
 * 创建人：王廷志
 * 创建记录： 2012-5-22
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGPRJ0101ExcelDTO extends ExcelDTO{
	/** 投资使用明细集合 */
	private List<InvestUseInfoVW> investUseInfoList;
	
	/** 项目性质 */
	protected List<CodeDetail> ppqCodeList;
	/** 项目类型 */
	protected List<CodeDetail> ptypeCodeList;

	/**
	 * 项目性质取得
	 * @return ppqCodeList 项目性质
	 */
	public List<CodeDetail> getPpqCodeList() {
		return ppqCodeList;
	}

	/**
	 * 项目性质设定
	 * @param ppqCodeList 项目性质
	 */
	public void setPpqCodeList(List<CodeDetail> ppqCodeList) {
		this.ppqCodeList = ppqCodeList;
	}

	/**
	 * 项目类型取得
	 * @return ptypeCodeList 项目类型
	 */
	public List<CodeDetail> getPtypeCodeList() {
		return ptypeCodeList;
	}

	/**
	 * 项目类型设定
	 * @param ptypeCodeList 项目类型
	 */
	public void setPtypeCodeList(List<CodeDetail> ptypeCodeList) {
		this.ptypeCodeList = ptypeCodeList;
	}

	/**
	 * 投资使用明细集合取得
	 * @return investUseInfoList 投资使用明细集合
	 */
	public List<InvestUseInfoVW> getInvestUseInfoList() {
		return investUseInfoList;
	}

	/**
	 * 投资使用明细集合设定
	 * @param investUseInfoList 投资使用明细集合
	 */
	public void setInvestUseInfoList(List<InvestUseInfoVW> investUseInfoList) {
		this.investUseInfoList = investUseInfoList;
	}
}
