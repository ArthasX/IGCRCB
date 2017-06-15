package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * 值班日报视图实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class DutyResultVWPK extends BasePK implements Serializable {

	/** 检查项ID */
	protected Integer dadid;

	/** 检查时间 */
	protected String dattime;
	
	/**
	 * 构造函数
	 */
	public DutyResultVWPK(){}
	
	/**
	 * 构造函数
	 */
	public DutyResultVWPK(Integer dadid, String dattime) {
		this.dadid = dadid;
		this.dattime = dattime;
	}
}
