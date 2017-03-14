/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;


/**
 * 审计版本查询Form
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0110Form extends BaseForm implements RiskAuditIns {
	/** 风险审计发起ID */
	protected Integer raiid;
	
	/** 风险审计ID */
	protected Integer raid;

	/** 风险审计版本 */
	protected String raversion;
	
	/** 风险审计发起编号 */
	protected String raicode;
	
	/** 风险审计发起创建日期 */
	protected String raistart;
	
	/** 风险审计发起结束日期 */
	protected String raiend;
	
	/** 风险审计发起描述 */
	protected String raidesc;
	
	/** 风险审计发起状态 */
	protected String raistatus;
	
	/** 风险审计发起记录的时间戳 */
	protected String fingerPrint;
	
	/** 模式 0登记，1编辑 */
	protected String mode = "0";
	
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
	 * 风险审计版本取得
	 * @return 风险审计版本
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * 风险审计版本设定
	 * @param raversion 风险审计版本
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
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
	 * 风险审计发起描述取得
	 * @return 风险审计发起描述
	 */
	public String getRaidesc() {
		return raidesc;
	}

	/**
	 * 风险审计发起描述设定
	 * @param raidesc 风险审计发起描述
	 */
	public void setRaidesc(String raidesc) {
		this.raidesc = raidesc;
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
	 * 风险审计发起记录的时间戳取得
	 * 
	 * @return 风险审计发起记录的时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 风险审计发起记录的时间戳设定
	 *
	 * @param fingerPrint 风险审计发起记录的时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * 模式取得
	 * 
	 * @return 模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 模式设定
	 *
	 * @param mode 模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
