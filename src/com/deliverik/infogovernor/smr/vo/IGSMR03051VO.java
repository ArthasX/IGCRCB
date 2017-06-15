/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.entity.ReportHistorySearchVW;

/**
 * 概述:通用查询vo 
 * 功能描述：通用查询vo 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR03051VO extends BaseVO {

	/** 通用查询结果*/
	protected List<ReportHistorySearchVW> list_rhs;

	public List<ReportHistorySearchVW> getList_rhs() {
		return list_rhs;
	}

	public void setList_rhs(List<ReportHistorySearchVW> list_rhs) {
		this.list_rhs = list_rhs;
	}
	
	
}
