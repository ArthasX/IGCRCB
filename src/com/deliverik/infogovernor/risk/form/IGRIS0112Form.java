/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;


/**
 * 审计人Form
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0112Form extends BaseForm implements RiskAuditDefResultVWSearchCond {
	
	/** 风险审计发起ID */
	protected Integer raiid;
	
	/** 风险审计项状态 */
	protected String radstatus;
	
	/** 风险审计项ID */
	protected String[] radid;
	
	/** 风险审计评估ID */
	protected String[] rarid;
	
	/** 风险审计评估人ID */
	protected String[] raruserid;
	
	/** 风险审计评估人姓名 */
	protected String[] rarusername;
	
	/**
	 * 风险审计发起ID取得
	 * @return 风险审计发起ID
	 */
	public Integer getRaiid() {
		if(raiid != null && raiid == 0) {
			raiid = null;
		}
		return raiid;
	}

	/**
	 * 风险审计发起ID设定
	 * @param raiid 风险审计发起ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}
	
	/**
	 * 风险审计项状态取得
	 * @return 风险审计项状态
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * 风险审计项状态设定
	 * @param radstatus 风险审计项状态
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}

	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public String[] getRadid() {
		return radid;
	}

	/**
	 * 风险审计项ID设定
	 * @param radid 风险审计项ID
	 */
	public void setRadid(String[] radid) {
		this.radid = radid;
	}

	/**
	 * 风险审计评估ID取得
	 * @return 风险审计评估ID
	 */
	public String[] getRarid() {
		return rarid;
	}

	/**
	 * 风险审计评估ID设定
	 * @param rarid 风险审计评估ID
	 */
	public void setRarid(String[] rarid) {
		this.rarid = rarid;
	}

	/**
	 * 风险审计评估人ID取得
	 * @return 风险审计评估人ID
	 */
	public String[] getRaruserid() {
		return raruserid;
	}

	/**
	 * 风险审计评估人ID设定
	 * @param raruserid 风险审计评估人ID
	 */
	public void setRaruserid(String[] raruserid) {
		this.raruserid = raruserid;
	}

	/**
	 * 风险审计评估人姓名取得
	 * @return 风险审计评估人姓名
	 */
	public String[] getRarusername() {
		return rarusername;
	}

	/**
	 * 风险审计评估人姓名设定
	 * @param rarusername 风险审计评估人姓名
	 */
	public void setRarusername(String[] rarusername) {
		this.rarusername = rarusername;
	}
	
}
