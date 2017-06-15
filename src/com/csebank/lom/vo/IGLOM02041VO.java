/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 物品管理VO
 *
 */
public class IGLOM02041VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Ginoutstockdetail> giostockdetailList;
	
	private List<GinoutStockDetailVW> ginoutStockDetailVWList;

	public List<Ginoutstockdetail> getGiostockdetailList() {
		return giostockdetailList;
	}

	public void setGiostockdetailList(List<Ginoutstockdetail> giostockdetailList) {
		this.giostockdetailList = giostockdetailList;
	}

	public List<GinoutStockDetailVW> getGinoutStockDetailVWList() {
		return ginoutStockDetailVWList;
	}

	public void setGinoutStockDetailVWList(
			List<GinoutStockDetailVW> ginoutStockDetailVWList) {
		this.ginoutStockDetailVWList = ginoutStockDetailVWList;
	}
	

}
