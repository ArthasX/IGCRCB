/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.vo;

import java.util.List;

import com.csebank.lom.model.GstockVWInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * @author duchong
 *
 */
public class IGLOM02131VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	/** 库存物品集合(库存预警查询使用) */
	private List<GstockVWInfo> gstockVWList;

	/**
	 * @return the gstockVWList
	 */
	public List<GstockVWInfo> getGstockVWList() {
		return gstockVWList;
	}

	/**
	 * @param gstockVWList the gstockVWList to set
	 */
	public void setGstockVWList(List<GstockVWInfo> gstockVWList) {
		this.gstockVWList = gstockVWList;
	}
	
	
}
