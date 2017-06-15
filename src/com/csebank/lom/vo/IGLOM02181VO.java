/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Ginoutstockdetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 物品管理VO
 *
 */
public class IGLOM02181VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Ginoutstockdetail> giostockdetailList;

	private Integer[] totalStockNum;
	
	private String gname;
	
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public List<Ginoutstockdetail> getGiostockdetailList() {
		return giostockdetailList;
	}

	public void setGiostockdetailList(List<Ginoutstockdetail> giostockdetailList) {
		this.giostockdetailList = giostockdetailList;
	}

	public Integer[] getTotalStockNum() {
		return totalStockNum;
	}

	public void setTotalStockNum(Integer[] totalStockNum) {
		this.totalStockNum = totalStockNum;
	}

}
