package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * 餐卡实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class WorkLunchEateryVWPK extends BasePK implements Serializable {

	/**日期 */
	protected String wldate;

	/** 餐卡名称 */
	protected String lunchcardname;
	
	/**
	 * 构造函数
	 */
	public WorkLunchEateryVWPK(){}
	
	/**
	 * 构造函数
	 */
	public WorkLunchEateryVWPK(String wldate, String lunchcardname) {
		this.wldate = wldate;
		this.lunchcardname = lunchcardname;
	}
}
