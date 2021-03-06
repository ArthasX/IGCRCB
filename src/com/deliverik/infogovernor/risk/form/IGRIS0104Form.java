/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;

/**
 * 审计项查询FORM
 * 
 */

public class IGRIS0104Form extends BaseForm implements RiskAuditDefSearchCond {
	
	private static final long serialVersionUID = 1L;
	
	/** 风险审计项ID */
	protected Integer radid;
	
	/** 风险审计ID */
	protected Integer raid;

	/** 风险审计版本 */
	protected String raversion;
	
	/** 风险审计项名称 */
	protected String radname;
	
	/** 风险审计项层次码 */
	protected String radcode;
	
	/** 风险审计项上级名称 */
	protected String radparname;	
	
	/** 风险审计项上级层次码 */
	protected String radparcode;
	
	/** 风险审计项描述 */
	protected String raddesc;
	
	/** 风险审计项风险程度 */
	protected String radrisklevel;
	
	/** 风险审计项责任人ID */
	protected String raduserid;
	
	/** 风险审计项责任人姓名 */
	protected String radusername;
	
	/** 风险审计项责任部门 */
	protected String radorg;
	
	/** 风险审计项控制手段 */
	protected String radmode;
	
	/** 风险审计项控制类型 */
	protected String radtype;
	
	/** 风险审计项控制频率 */
	protected String radfrequency;
	
	/** 风险审计项上级层次码查询 */
	protected String radparcode_q;
	
	/** 风险审计项层次码 */
	protected String radcode_q;
	
	public String getRadcode_q() {
		return radcode_q;
	}

	public void setRadcode_q(String radcode_q) {
		this.radcode_q = radcode_q;
	}
	
	public String getRadparcode_q() {
		return radparcode_q;
	}

	public void setRadparcode_q(String radparcode_q) {
		this.radparcode_q = radparcode_q;
	}

	/**
	 * 审计项状态(0停用 1启用)
	 */
	
	protected String radstatus;
	

	/**
	 * 风险审计项状态取得
	 * @return 风险审计项状态
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * 风险审计项状态设定
	 * @param radfrequency 风险审计项状态
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return radid;
	}
	
	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * 风险审计项ID设定
	 * @param radid 风险审计项ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
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
	 * 风险审计项名称取得
	 * @return 风险审计项名称
	 */
	public String getRadname() {
		return radname;
	}

	/**
	 * 风险审计项名称设定
	 * @param radname 风险审计项名称
	 */
	public void setRadname(String radname) {
		this.radname = radname;
	}

	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * 风险审计项层次码设定
	 * @param radcode 风险审计项层次码
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}

	/**
	 * 风险审计项上级名称取得
	 * @return 风险审计项上级名称
	 */
	public String getRadparname() {
		return radparname;
	}

	/**
	 * 风险审计项上级名称设定
	 * @param radparcode 风险审计项上级名称
	 */
	public void setRadparname(String radparname) {
		this.radparname = radparname;
	}

	/**
	 * 风险审计项上级层次码取得
	 * @return 风险审计项上级层次码
	 */
	public String getRadparcode() {
		return radparcode;
	}

	/**
	 * 风险审计项上级层次码设定
	 * @param radparcode 风险审计项上级层次码
	 */
	public void setRadparcode(String radparcode) {
		this.radparcode = radparcode;
	}

	/**
	 * 风险审计项描述取得
	 * @return 风险审计项描述
	 */
	public String getRaddesc() {
		return raddesc;
	}

	/**
	 * 风险审计项描述设定
	 * @param raddesc 风险审计项描述
	 */
	public void setRaddesc(String raddesc) {
		this.raddesc = raddesc;
	}

	/**
	 * 风险审计项风险程度取得
	 * @return 风险审计项风险程度
	 */
	public String getRadrisklevel() {
		return radrisklevel;
	}

	/**
	 * 风险审计项风险程度设定
	 * @param radrisklevel 风险审计项风险程度
	 */
	public void setRadrisklevel(String radrisklevel) {
		this.radrisklevel = radrisklevel;
	}

	/**
	 * 风险审计项责任人ID取得
	 * @return 风险审计项责任人ID
	 */
	public String getRaduserid() {
		return raduserid;
	}

	/**
	 * 风险审计项责任人ID设定
	 * @param raduserid 风险审计项责任人ID
	 */
	public void setRaduserid(String raduserid) {
		this.raduserid = raduserid;
	}

	/**
	 * 风险审计项责任人姓名取得
	 * @return 风险审计项责任人姓名
	 */
	public String getRadusername() {
		return radusername;
	}

	/**
	 * 风险审计项责任人姓名设定
	 * @param radusername 风险审计项责任人姓名
	 */
	public void setRadusername(String radusername) {
		this.radusername = radusername;
	}

	/**
	 * 风险审计项责任部门取得
	 * @return 风险审计项责任部门
	 */
	public String getRadorg() {
		return radorg;
	}

	/**
	 * 风险审计项责任部门设定
	 * @param radorg 风险审计项责任部门
	 */
	public void setRadorg(String radorg) {
		this.radorg = radorg;
	}

	/**
	 * 风险审计项控制手段取得
	 * @return 风险审计项控制手段
	 */
	public String getRadmode() {
		return radmode;
	}

	/**
	 * 风险审计项控制手段设定
	 * @param radmode 风险审计项控制手段
	 */
	public void setRadmode(String radmode) {
		this.radmode = radmode;
	}

	/**
	 * 风险审计项控制类型取得
	 * @return 风险审计项控制类型
	 */
	public String getRadtype() {
		return radtype;
	}

	/**
	 * 风险审计项控制类型设定
	 * @param radtype 风险审计项控制类型
	 */
	public void setRadtype(String radtype) {
		this.radtype = radtype;
	}

	/**
	 * 风险审计项控制频率取得
	 * @return 风险审计项控制频率
	 */
	public String getRadfrequency() {
		return radfrequency;
	}

	/**
	 * 风险审计项控制频率设定
	 * @param radfrequency 风险审计项控制频率
	 */
	public void setRadfrequency(String radfrequency) {
		this.radfrequency = radfrequency;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getByLevelDesc() {
		// TODO Auto-generated method stub
		return null;
	}

}
