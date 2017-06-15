/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.prj.model.Pbsummary;

/**
 * 概述:项目修改页vo 
 * 功能描述：项目修改页vo
 * 创建人：王廷志
 * 创建记录： 2012-5-21
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGPRJ01091VO extends BaseVO{
	/** 项目预算关系视图集合 */
	private List<Pbsummary> pbsummaryList;

	/**
	 * 项目预算关系视图集合取得
	 * @return pbsummaryList 项目预算关系视图集合
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}

	/**
	 * 项目预算关系视图集合设定
	 * @param pbsummaryList 项目预算关系视图集合
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}
}
