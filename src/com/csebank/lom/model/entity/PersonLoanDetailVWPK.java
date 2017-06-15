package com.csebank.lom.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * 人员借款明细统计实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class PersonLoanDetailVWPK extends BasePK implements Serializable {

	/** ID */
	protected String id;

	/** 交易类型 */
	protected String type;
	
	/**
	 * 构造函数
	 */
	public PersonLoanDetailVWPK(){}
	
	/**
	 * 构造函数
	 */
	public PersonLoanDetailVWPK(String id, String type) {
		this.id = id;
		this.type = type;
	}
}
