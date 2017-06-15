/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fin.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.prj.model.Pbsummary;

/**
 * 概述: 项目登记预算弹出页vo
 * 功能描述： 项目登记预算弹出页vo
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGFIN01013VO extends BaseVO{
	/** 预算视图结果集 */
	private List<Pbsummary> pbsummaryList;

	/**
	 * 预算视图结果集取得
	 * @return pbsummaryList 预算视图结果集
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}

	/**
	 * 预算视图结果集设定
	 * @param pbsummaryList 预算视图结果集
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}
}
