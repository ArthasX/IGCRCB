/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;


/**
 * 审计发起查询Form
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0118Form extends BaseForm implements RiskAuditInsSearchCond {
	
	/** 风险审计ID */
	protected Integer raid;
	
	/** 风险审计发起ID */
	protected Integer raiid;

	/** 风险审计发起编号 */
	protected String raicode;
	
	/** 风险审计发起创建日期 */
	protected String raistart;
	
	/** 风险审计发起结束日期 */
	protected String raiend;
	
	/** 风险审计发起状态 */
	protected String raistatus;
	
	/**
	 * 风险审计发起编号取得
	 * @return 风险审计发起编号
	 */
	public String getRaicode() {
		return raicode;
	}

	/**
	 * 风险审计发起编号设定
	 * @param raicode 风险审计发起编号
	 */
	public void setRaicode(String raicode) {
		this.raicode = raicode;
	}
	
	/**
	 * 风险审计ID取得
	 * @return 风险审计ID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * 风险审计ID设定
	 * @param raid 风险审计ID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}
	
	/**
	 * 风险审计发起创建日期取得
	 * @return 风险审计发起创建日期
	 */
	public String getRaistart() {
		return raistart;
	}

	/**
	 * 风险审计发起创建日期设定
	 * @param raistart 风险审计发起创建日期
	 */
	public void setRaistart(String raistart) {
		this.raistart = raistart;
	}

	/**
	 * 风险审计发起结束日期取得
	 * @return 风险审计发起结束日期
	 */
	public String getRaiend() {
		return raiend;
	}

	/**
	 * 风险审计发起结束日期设定
	 * @param raiend 风险审计发起结束日期
	 */
	public void setRaiend(String raiend) {
		this.raiend = raiend;
	}
	/**
	 * 风险审计发起状态取得
	 * @return 风险审计发起状态
	 */
	public String getRaistatus() {
		return raistatus;
	}

	/**
	 * 风险审计发起状态设定
	 * @param raistatus 风险审计发起状态
	 */
	public void setRaistatus(String raistatus) {
		this.raistatus = raistatus;
	}
	
	/**
	 * 风险审计发起ID取得
	 * @return 风险审计发起ID
	 */
	public Integer getRaiid() {
		return raiid;
	}

	/**
	 * 风险审计发起ID设定
	 * @param raiid 风险审计发起ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}
}
