/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskAudit;


/**
 * 审计版本查询Form
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0102Form extends BaseForm implements RiskAudit {

	/** 风险审计ID */
	protected Integer raid;

	/** 风险审计版本 */
	protected String raversion;
	
	/** 风险审计创建日期 */
	protected String radate;
	
	/** 风险审计创建人ID */
	protected String rauserid;
	
	/** 风险审计创建人姓名 */
	protected String rausername;

	/** 风险审计描述 */
	protected String radesc;
	
	/** 风险审计状态 */
	protected String rastatus;
	
	/** 风险审计记录的时间戳 */
	protected String fingerPrint;
	
	/** 风险审计根标识 */
	protected String racode;
	
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
	 * 风险审计创建日期取得
	 * @return 风险审计创建日期
	 */
	public String getRadate() {
		return radate;
	}

	/**
	 * 风险审计创建日期设定
	 * @param radate 风险审计创建日期
	 */
	public void setRadate(String radate) {
		this.radate = radate;
	}

	/**
	 * 风险审计描述取得
	 * @return 风险审计描述
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * 风险审计描述设定
	 * @param radesc 风险审计描述
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * 风险审计状态取得
	 * @return 风险审计状态
	 */
	public String getRastatus() {
		return rastatus;
	}

	/**
	 * 风险审计状态设定
	 * @param rastatus 风险审计状态
	 */
	public void setRastatus(String rastatus) {
		this.rastatus = rastatus;
	}

	/**
	 * 风险审计记录的时间戳取得
	 * 
	 * @return 风险审计记录的时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 风险审计记录的时间戳设定
	 *
	 * @param fingerPrint 风险审计记录的时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * 风险审计创建人ID取得
	 * @return 风险审计创建人ID
	 */
	public String getRauserid() {
		return rauserid;
	}

	/**
	 * 风险审计创建人ID设定
	 * @param rauserid 风险审计创建人ID
	 */
	public void setRauserid(String rauserid) {
		this.rauserid = rauserid;
	}

	/**
	 * 风险审计创建人姓名取得
	 * @return 风险审计创建人姓名
	 */
	public String getRausername() {
		return rausername;
	}

	/**
	 * 风险审计创建人姓名设定
	 * @param rausername 风险审计创建人姓名
	 */
	public void setRausername(String rausername) {
		this.rausername = rausername;
	}
	
	/**
	 * 风险审计根标识取得
	 * @return 风险审计根标识
	 */
	public String getRacode() {
		return racode;
	}

	/**
	 * 风险审计根标识设定
	 * @param racode 风险审计根标识
	 */
	public void setRacode(String racode) {
		this.racode = racode;
	}
	
}
