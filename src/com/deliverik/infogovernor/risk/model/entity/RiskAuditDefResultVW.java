package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;


/**
 * 审计项和相关审计人外联视图实体
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "RiskAuditDefResultVW")
@SuppressWarnings("serial")
public class RiskAuditDefResultVW implements Serializable, Cloneable, RiskAuditDefResultVWInfo {

	/** 风险审计项ID */
	@Id
	protected Integer radid;
	
	/** 风险审计ID */
	protected Integer raid;
	
	/** 风险审计项名称 */
	protected String radname;
	
	/** 风险审计项层次码 */
	protected String radcode;
	
	/** 风险审计项上级层次码 */
	protected String radparcode;
	
	/** 风险审计项状态 */
	protected String radstatus;
	
	/** 风险审计项级次 */
	protected String radlevel;
	
	/** 风险审计评估结果ID */
	protected Integer rarid;

	/** 风险审计发起ID */
	protected Integer raiid;
	
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
	
	/** 风险审计项风险程度 */
	protected String radrisklevel;
	
	/** 风险审计项控制手段 */
	protected String radmode;
	
	/** 风险审计项控制类型 */
	protected String radtype;
	
	/** 风险审计项控制频率 */
	protected String radfrequency;
	
	/** 风险审计项责任人姓名 */
	protected String radusername;
	
	/** 风险审计项责任部门 */
	protected String radorg;
	
	/** 风险审计项描述 */
	protected String raddesc;
	
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
	 * 风险审计项级次取得
	 * @return 风险审计项级次
	 */
	public String getRadlevel() {
		return radlevel;
	}

	/**
	 * 风险审计项级次设定
	 * @param radlevel 风险审计项级次
	 */
	public void setRadlevel(String radlevel) {
		this.radlevel = radlevel;
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

}
