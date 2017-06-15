package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * 值班日报视图实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class SingleGoodsStockVWPK extends BasePK implements Serializable {

	/**日期 */
	protected String giodtime;

	/**出入库类型 */
	protected String giodtype;
	
	/**
	 * 构造函数
	 */
	public SingleGoodsStockVWPK(){}
	
	/**
	 * 构造函数
	 */
	public SingleGoodsStockVWPK(String giodtime, String giodtype) {
		this.giodtime = giodtime;
		this.giodtype = giodtype;
	}
}
