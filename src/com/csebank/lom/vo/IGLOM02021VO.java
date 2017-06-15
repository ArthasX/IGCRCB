/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Goods;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 物品管理VO
 *
 */
public class IGLOM02021VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Goods> goodsList;

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

}
