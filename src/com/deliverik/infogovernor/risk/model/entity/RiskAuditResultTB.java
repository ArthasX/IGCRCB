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
import com.deliverik.infogovernor.risk.model.RiskAuditResult;

/**
 * 风险审计评估结果实体
 * @author lipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskAuditResult")
public class RiskAuditResultTB extends BaseEntity implements Serializable, Cloneable, RiskAuditResult {

	/** 风险审计评估结果ID */
	@Id
	@TableGenerator(
		    name="RISKAUDITRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKAUDITRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKAUDITRESULT_TABLE_GENERATOR")
	protected Integer rarid;

	/** 风险审计发起ID */
	protected Integer raiid;
	
	/** 风险审计项ID */
	protected Integer radid;
	
	/** 风险审计评估日期 */
	protected String rardate;

	/** 风险审计评估人ID */
	protected String raruserid;
	
	/** 风险审计评估人姓名 */
	protected String rarusername;
	
	/** 风险审计制度建设评分 */
	protected String rarplanscore;
	
	/** 风险审计制度建设评价 */
	protected String rarplandesc;
	
	/** 风险审计制度执行评分 */
	protected String rarexecscore;
	
	/** 风险审计制度执行评价 */
	protected String rarexecdesc;
	
	/** 风险审计总体评分 */
	protected String raroverallscore;
	
	/** 风险审计总体评价 */
	protected String raroveralldesc;
	
	/** 风险审计评估说明 */
	protected String rarcomment;
	
	/** 风险审计项层次码 */
	protected String radcode;
	
	/** 审计项实体 */
	@OneToOne
	@JoinColumn(name="radid", referencedColumnName="radid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RiskAuditDefTB riskAuditDefTB;
	
	/** 审计发起实体 */
	@OneToOne
	@JoinColumn(name="raiid", referencedColumnName="raiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RiskAuditInsTB riskAuditInsTB;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rarid;
	}

	/**
	 * 风险审计评估结果ID取得
	 * @return 风险审计评估结果ID
	 */
	public Integer getRarid() {
		return rarid;
	}

	/**
	 * 风险审计评估结果ID设定
	 * @param rarid 风险审计评估结果ID
	 */
	public void setRarid(Integer rarid) {
		this.rarid = rarid;
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

	/**
	 * 风险审计评估日期取得
	 * @return 风险审计评估日期
	 */
	public String getRardate() {
		return rardate;
	}

	/**
	 * 风险审计评估日期设定
	 * @param rardate 风险审计评估日期
	 */
	public void setRardate(String rardate) {
		this.rardate = rardate;
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
	 * 风险审计评估人ID取得
	 * @return 风险审计评估人ID
	 */
	public String getRaruserid() {
		return raruserid;
	}

	/**
	 * 风险审计评估人ID设定
	 * @param raruserid 风险审计评估人ID
	 */
	public void setRaruserid(String raruserid) {
		this.raruserid = raruserid;
	}

	/**
	 * 风险审计评估人姓名取得
	 * @return 风险审计评估人姓名
	 */
	public String getRarusername() {
		return rarusername;
	}

	/**
	 * 风险审计评估人姓名设定
	 * @param rarusername 风险审计评估人姓名
	 */
	public void setRarusername(String rarusername) {
		this.rarusername = rarusername;
	}

	/**
	 * 风险审计制度建设评分取得
	 * @return 风险审计制度建设评分
	 */
	public String getRarplanscore() {
		return rarplanscore;
	}

	/**
	 * 风险审计制度建设评分设定
	 * @param rarplanscore 风险审计制度建设评分
	 */
	public void setRarplanscore(String rarplanscore) {
		this.rarplanscore = rarplanscore;
	}

	/**
	 * 风险审计制度建设评价取得
	 * @return 风险审计制度建设评价
	 */
	public String getRarplandesc() {
		return rarplandesc;
	}

	/**
	 * 风险审计制度建设评价设定
	 * @param rarplandesc 风险审计制度建设评价
	 */
	public void setRarplandesc(String rarplandesc) {
		this.rarplandesc = rarplandesc;
	}

	/**
	 * 风险审计制度执行评分取得
	 * @return 风险审计制度执行评分
	 */
	public String getRarexecscore() {
		return rarexecscore;
	}

	/**
	 * 风险审计制度执行评分设定
	 * @param rarexecscore 风险审计制度执行评分
	 */
	public void setRarexecscore(String rarexecscore) {
		this.rarexecscore = rarexecscore;
	}

	/**
	 * 风险审计制度执行评价取得
	 * @return 风险审计制度执行评价
	 */
	public String getRarexecdesc() {
		return rarexecdesc;
	}

	/**
	 * 风险审计制度执行评价设定
	 * @param rarexecdesc 风险审计制度执行评价
	 */
	public void setRarexecdesc(String rarexecdesc) {
		this.rarexecdesc = rarexecdesc;
	}

	/**
	 * 风险审计总体评分取得
	 * @return 风险审计总体评分
	 */
	public String getRaroverallscore() {
		return raroverallscore;
	}

	/**
	 * 风险审计总体评分设定
	 * @param raroverallscore 风险审计总体评分
	 */
	public void setRaroverallscore(String raroverallscore) {
		this.raroverallscore = raroverallscore;
	}

	/**
	 * 风险审计总体评价取得
	 * @return 风险审计总体评价
	 */
	public String getRaroveralldesc() {
		return raroveralldesc;
	}

	/**
	 * 风险审计总体评价设定
	 * @param raroveralldesc 风险审计总体评价
	 */
	public void setRaroveralldesc(String raroveralldesc) {
		this.raroveralldesc = raroveralldesc;
	}

	/**
	 * 风险审计评估说明取得
	 * @return 风险审计评估说明
	 */
	public String getRarcomment() {
		return rarcomment;
	}

	/**
	 * 风险审计评估说明设定
	 * @param rarcomment 风险审计评估说明
	 */
	public void setRarcomment(String rarcomment) {
		this.rarcomment = rarcomment;
	}

	/**
	 * 审计项实体取得
	 * @return 审计项实体
	 */
	public RiskAuditDefTB getRiskAuditDefTB() {
		return riskAuditDefTB;
	}

	/**
	 * 审计项实体设定
	 * @param riskAuditDefTB 审计项实体
	 */
	public void setRiskAuditDefTB(RiskAuditDefTB riskAuditDefTB) {
		this.riskAuditDefTB = riskAuditDefTB;
	}

	/**
	 * 审计发起实体取得
	 * @return 审计发起实体
	 */
	public RiskAuditInsTB getRiskAuditInsTB() {
		return riskAuditInsTB;
	}

	/**
	 * 审计发起实体设定
	 * @param riskAuditInsTB 审计发起实体
	 */
	public void setRiskAuditInsTB(RiskAuditInsTB riskAuditInsTB) {
		this.riskAuditInsTB = riskAuditInsTB;
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
	
}
