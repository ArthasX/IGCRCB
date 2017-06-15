/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * 仓库收益相关VO
 *
 */
@SuppressWarnings("serial")
public class ITEMS01691VO extends BaseVO {

	private List<ITEMS01692VO> items01692VOList;

	public List<ITEMS01692VO> getItems01692VOList() {
		return items01692VOList;
	}

	public void setItems01692VOList(List<ITEMS01692VO> items01692VOList) {
		this.items01692VOList = items01692VOList;
	}
	
}
