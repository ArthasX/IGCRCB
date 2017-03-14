/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * 风险检查结果实体
 * @author lipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskCheckResult")
public class RiskCheckResultTB extends BaseEntity implements Serializable, Cloneable, RiskCheckResult {

	/** 风险检查结果ID */
	@Id
	@TableGenerator(
		    name="RISKCHECKRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKCHECKRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKCHECKRESULT_TABLE_GENERATOR")
	/** 风险检查结果ID */
	protected Integer rcrid;
	
	/** 风险检查ID */
	protected Integer rcid;

	/** 风险检查计划检查时间 */
	protected String rcrplandate;
	
	/** 风险检查实际检查时间 */
	protected String rcrrealtime;
	
	/** 风险检查结果提交人ID */
	protected String rcruserid;
	
	/** 风险检查结果提交人姓名 */
	protected String rcrusername;
	
	/** 风险检查结果 */
	protected String rcrresult;
	
	/** 风险检查结果说明 */
	protected String rcrcomment;
	
	/** 风险检查重要程度 */
	protected String rctype;
	
	/** 下次执行检查时间 */
	protected String rcrnextdate;
	
	/** 关联流程ID */
	protected Integer prid;
	
	protected String rcrtestmode;
	
	protected Integer assignprid;
	
	/** 检查项名称*/
	protected String rcname;
	
	/** 检查项类型*/
	protected String rcrclass;
	
	/** 检查项描述*/
	protected String rcdesc;
	
	/** 检查项说明*/
	protected String rccommon;
	
	/** 风险检查对象 */
	@OneToOne
	@JoinColumn(name="rcid", referencedColumnName="rcid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RiskCheckTB riskCheck;
	
	/** 风险检查结果附件 */
	protected String rcrattch;

	/**
	 * @return the assignprid
	 */
	public Integer getAssignprid() {
		return assignprid;
	}

	/**
	 * @param assignprid the assignprid to set
	 */
	public void setAssignprid(Integer assignprid) {
		this.assignprid = assignprid;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rcrid;
	}

	
	/**
	 * @return the rcrtestmode
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * @param rcrtestmode the rcrtestmode to set
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * 风险检查重要程度取得
	 * @return 风险检查重要程度
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 *风险检查重要程度设定
	 * @param rctype 风险检查重要程度
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * 风险检查对象取得
	 * @return 风险检查对象
	 */
	public RiskCheckTB getRiskCheck() {
		return riskCheck;
	}


	/**
	 * 风险检查对象设定
	 * @param riskCheck 风险检查对象
	 */
	public void setRiskCheck(RiskCheckTB riskCheck) {
		this.riskCheck = riskCheck;
	}




	/**
	 * 风险检查结果附件取得
	 * @return 风险检查结果附件
	 */
	public String getRcrattch() {
		return rcrattch;
	}



	/**
	 * 风险检查结果附件设定
	 * @param rcrattch 风险检查结果附件
	 */
	public void setRcrattch(String rcrattch) {
		this.rcrattch = rcrattch;
	}


	/**
	 * 风险检查结果ID取得
	 * @return 风险检查结果ID
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * 风险检查结果ID设定
	 * @param rcrid 风险检查结果ID
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * 风险检查ID取得
	 * @return 风险检查ID
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * 风险检查ID设定
	 * @param rcid 风险检查ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 风险检查计划检查时间取得
	 * @return 风险检查计划检查时间
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * 风险检查计划检查时间设定
	 * @param rcrplandate 风险检查计划检查时间
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * 风险检查实际检查时间取得
	 * @return 风险检查实际检查时间
	 */
	public String getRcrrealtime() {
		return rcrrealtime;
	}

	/**
	 * 风险检查实际检查时间设定
	 * @param rcrrealtime 风险检查实际检查时间
	 */
	public void setRcrrealtime(String rcrrealtime) {
		this.rcrrealtime = rcrrealtime;
	}

	/**
	 * 风险检查实际检查时间取得
	 * @return 风险检查实际检查时间
	 */
	public String getRcruserid() {
		return rcruserid;
	}

	/**
	 * 风险检查实际检查时间设定
	 * @param rcrrealdate 风险检查实际检查时间
	 */
	public void setRcruserid(String rcruserid) {
		this.rcruserid = rcruserid;
	}

	/**
	 * 风险检查结果提交人姓名取得
	 * @return 风险检查结果提交人姓名
	 */
	public String getRcrusername() {
		return rcrusername;
	}

	/**
	 * 风险检查结果提交人姓名设定
	 * @param rcrusername 风险检查结果提交人姓名
	 */
	public void setRcrusername(String rcrusername) {
		this.rcrusername = rcrusername;
	}

	/**
	 * 风险检查结果取得
	 * @return 风险检查结果
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * 风险检查结果设定
	 * @param rcrresult 风险检查结果
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * 风险检查结果说明取得
	 * @return 风险检查结果说明
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * 风险检查结果说明设定
	 * @param rcrcomment 风险检查结果说明
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * 下次执行检查时间取得
	 * @return 下次执行检查时间
	 */
	public String getRcrnextdate() {
		return rcrnextdate;
	}

	/**
	 * 下次执行检查时间设定
	 * @param rcrnexttimen 下次执行检查时间
	 */
	public void setRcrnextdate(String rcrnextdate) {
		this.rcrnextdate = rcrnextdate;
	}
	
	/**
	 * 关联流程取得
	 * @return 关联流程
	 */
	public Integer getPrid() {
		return prid;
	}
	
	/**
	 * 关联流程设定
	 * @param rcrnexttimen 关联流程设定
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 检查项名称取得
	 * @return the rcname
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * 检查项名称设定
	 * @param rcname the rcname to set
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * 检查项类型取得
	 * @return the rcrclass
	 */
	public String getRcrclass() {
		return rcrclass;
	}

	/**
	 * 检查项类型设定
	 * @param rcrclass the rcrclass to set
	 */
	public void setRcrclass(String rcrclass) {
		this.rcrclass = rcrclass;
	}

	/**
	 * 检查项描述取得
	 * @return the rcdesc
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * 检查项描述设定
	 * @param rcdesc the rcdesc to set
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}

	/**
	 * 检查项说明取得
	 * @return the rccommon
	 */
	public String getRccommon() {
		return rccommon;
	}

	/**
	 * 检查项说明设定
	 * @param rccommon the rccommon to set
	 */
	public void setRccommon(String rccommon) {
		this.rccommon = rccommon;
	}
	
	
	
}
