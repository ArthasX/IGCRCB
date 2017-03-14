/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.vo;

import java.util.List;

import com.csebank.lom.model.Gstock;
import com.deliverik.framework.base.BaseVO;

/**
 * @author duchong
 *
 */
public class IGLOM02141VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	/** 库存物品集合(库存预警查询使用) */
	private List<Gstock> gstockList;

	/**
	 * @return the gstockList
	 */
	public List<Gstock> getGstockList() {
		return gstockList;
	}

	/**
	 * @param gstockList the gstockList to set
	 */
	public void setGstockList(List<Gstock> gstockList) {
		this.gstockList = gstockList;
	}

	
	
}
