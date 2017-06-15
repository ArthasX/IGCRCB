/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 预支费用管理Form
 *
 */
public class IGLOM0302Form extends BaseForm implements AdvanCescostSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预支费用计财记帐日期查询时间开始
	 */
	protected String acdate_from;
	
	/**
	 * 预支费用计财记帐日期查询时间结束
	 */
	protected String acdate_to;
	
	/** 预支费用删除对象 */
	protected String[] deleteAcid;
	
	/**
	 * 预支费用状态
	 */
	protected String acstatus_q;

	/**
	 * 预支费用计财记帐日期查询时间开始取得
	 * @return 预支费用计财记帐日期查询时间开始
	 */
	public String getAcdate_from() {
		return acdate_from;
	}

	/**
	 * 预支费用计财记帐日期查询时间开始设定
	 * @param acdate_from 预支费用计财记帐日期查询时间开始
	 */
	public void setAcdate_from(String acdate_from) {
		this.acdate_from = acdate_from;
	}

	/**
	 * 预支费用计财记帐日期查询时间结束取得
	 * @return 预支费用计财记帐日期查询时间结束
	 */
	public String getAcdate_to() {
		return acdate_to;
	}

	/**
	 * 预支费用计财记帐日期查询时间结束设定
	 * @param acdate_to 预支费用计财记帐日期查询时间结束
	 */
	public void setAcdate_to(String acdate_to) {
		this.acdate_to = acdate_to;
	}
	
	/**
	 * 预支费用删除对象取得
	 * @return 预支费用删除对象
	 */
	public String[] getDeleteAcid() {
		return deleteAcid;
	}

	/**
	 * 预支费用删除对象设定
	 * @param deleteAcid 预支费用删除对象
	 */
	public void setDeleteAcid(String[] deleteAcid) {
		this.deleteAcid = deleteAcid;
	}
	
	/**
	 * 预支费用状态取得
	 * @return 预支费用状态
	 */
	public String getAcstatus_q() {
		return acstatus_q;
	}

	/**
	 * 预支费用状态设定
	 * @param acstatus_q 预支费用状态
	 */
	public void setAcstatus_q(String acstatus_q) {
		this.acstatus_q = acstatus_q;
	}

}
