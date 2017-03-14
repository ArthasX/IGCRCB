package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * 预支汇总实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class AdvanceSummaryTBPK extends BasePK implements Serializable {

	/** 年度取得 */
	protected String asyear;

	/** 月份取得 */
	protected String asmonth;
	
	/**
	 * 构造函数
	 */
	public AdvanceSummaryTBPK(){}
	
	/**
	 * 构造函数
	 */
	public AdvanceSummaryTBPK(String asyear, String asmonth) {
		this.asyear = asyear;
		this.asmonth = asmonth;
	}
}
