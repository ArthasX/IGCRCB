package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * ֵ���ձ���ͼʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class SingleGoodsStockVWPK extends BasePK implements Serializable {

	/**���� */
	protected String giodtime;

	/**��������� */
	protected String giodtype;
	
	/**
	 * ���캯��
	 */
	public SingleGoodsStockVWPK(){}
	
	/**
	 * ���캯��
	 */
	public SingleGoodsStockVWPK(String giodtime, String giodtype) {
		this.giodtime = giodtime;
		this.giodtype = giodtype;
	}
}
