/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.SingleGoodsStock;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ���ͳ��VO
 *
 */
public class IGLOM05151VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���ͳ�ƽ��
	 */
	protected List<SingleGoodsStock> singleGoodsStock;

	/**
	 * ���ͳ�ƽ��ȡ��
	 * @return ���ͳ�ƽ��
	 */
	public List<SingleGoodsStock> getSingleGoodsStockList() {
		return singleGoodsStock;
	}

	/**
	 * ���ͳ�ƽ��
	 * @param goodsStock ���ͳ�ƽ��
	 */
	public void setSingleGoodsStockList(List<SingleGoodsStock> singleGoodsStock) {
		this.singleGoodsStock = singleGoodsStock;
	}

}
