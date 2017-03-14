/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.SingleGoodsStock;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 库存统计VO
 *
 */
public class IGLOM05151VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 库存统计结果
	 */
	protected List<SingleGoodsStock> singleGoodsStock;

	/**
	 * 库存统计结果取得
	 * @return 库存统计结果
	 */
	public List<SingleGoodsStock> getSingleGoodsStockList() {
		return singleGoodsStock;
	}

	/**
	 * 库存统计结果
	 * @param goodsStock 库存统计结果
	 */
	public void setSingleGoodsStockList(List<SingleGoodsStock> singleGoodsStock) {
		this.singleGoodsStock = singleGoodsStock;
	}

}
