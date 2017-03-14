/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * 物品收益相关VO
 *
 */
@SuppressWarnings("serial")
public class ITEMS01711VO extends BaseVO {

	private List<ITEMS01712VO> items01712VOList;
	
	private String total;

	public List<ITEMS01712VO> getItems01712VOList() {
		return items01712VOList;
	}

	public void setItems01712VOList(List<ITEMS01712VO> items01712VOList) {
		this.items01712VOList = items01712VOList;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
}
