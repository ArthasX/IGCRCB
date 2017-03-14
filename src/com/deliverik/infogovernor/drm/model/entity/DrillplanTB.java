/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;

/**
  * 概述: 演练计划实体
  * 功能描述: 演练计划实体
  * 创建记录: 2015/03/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="drillplan")
public class DrillplanTB extends BaseEntity implements Serializable,
		Cloneable, DrillplanInfo {

	/** 演练计划id */
	@Id
	@TableGenerator(
		name="DRILLPLAN_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="DRILLPLAN_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DRILLPLAN_TABLE_GENERATOR")
	protected Integer did;

	/** 演练计划制定人id */
	protected String duserid;

	/** 演练计划指定人名 */
	protected String dusername;

	/** 创建时间 */
	protected String crttime;

	/** 审批时间 */
	protected String judgetime;

	/** 演练计划编号 */
	protected String dserial;

	/** 演练计划名称 */
	protected String dname;

	/** 审批状态 #为编辑中，a 为送审，t审批通过，f为审批驳回 */
	protected String judgestatus;
	
	/** 描述 */
	protected String depict;
	
	/** 审批意见 */
	protected String dopinion;
	
	/**审批人userid*/
	protected String judgeuserid;

	/**审批人username*/
	protected String judgeusername;
	
	/**完成数量*/
    protected String completecount;
	
	
    
    
    public String getCompletecount() {
        return completecount;
    }

    public void setCompletecount(String completecount) {
        this.completecount = completecount;
    }

    /** 审批意见 */
	public String getDopinion() {
        return dopinion;
    }

    public void setDopinion(String dopinion) {
        this.dopinion = dopinion;
    }

    public String getJudgeuserid() {
        return judgeuserid;
    }

    public void setJudgeuserid(String judgeuserid) {
        this.judgeuserid = judgeuserid;
    }

    public String getJudgeusername() {
        return judgeusername;
    }

    public void setJudgeusername(String judgeusername) {
        this.judgeusername = judgeusername;
    }

    /**
	 * 演练计划id取得
	 *
	 * @return 演练计划id
	 */
	public Integer getDid() {
		return did;
	}

	/**
	 * 演练计划id设定
	 *
	 * @param did 演练计划id
	 */
	public void setDid(Integer did) {
		this.did = did;
	}

	/**
	 * 演练计划制定人id取得
	 *
	 * @return 演练计划制定人id
	 */
	public String getDuserid() {
		return duserid;
	}

	/**
	 * 演练计划制定人id设定
	 *
	 * @param duserid 演练计划制定人id
	 */
	public void setDuserid(String duserid) {
		this.duserid = duserid;
	}

	/**
	 * 演练计划指定人名取得
	 *
	 * @return 演练计划指定人名
	 */
	public String getDusername() {
		return dusername;
	}

	/**
	 * 演练计划指定人名设定
	 *
	 * @param dusername 演练计划指定人名
	 */
	public void setDusername(String dusername) {
		this.dusername = dusername;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getCrttime() {
		return crttime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param crttime 创建时间
	 */
	public void setCrttime(String crttime) {
		this.crttime = crttime;
	}

	/**
	 * 审批时间取得
	 *
	 * @return 审批时间
	 */
	public String getJudgetime() {
		return judgetime;
	}

	/**
	 * 审批时间设定
	 *
	 * @param judgetime 审批时间
	 */
	public void setJudgetime(String judgetime) {
		this.judgetime = judgetime;
	}

	/**
	 * 演练计划编号取得
	 *
	 * @return 演练计划编号
	 */
	public String getDserial() {
		return dserial;
	}

	/**
	 * 演练计划编号设定
	 *
	 * @param dserial 演练计划编号
	 */
	public void setDserial(String dserial) {
		this.dserial = dserial;
	}

	/**
	 * 演练计划名称取得
	 *
	 * @return 演练计划名称
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * 演练计划名称设定
	 *
	 * @param dname 演练计划名称
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	/**
	 * 审批状态 a 为送审，b审批中，c审批完成取得
	 *
	 * @return 审批状态 a 为送审，b审批中，c审批完成
	 */
	public String getJudgestatus() {
		return judgestatus;
	}

	/**
	 * 审批状态 a 为送审，b审批中，c审批完成设定
	 *
	 * @param judgestatus 审批状态 a 为送审，b审批中，c审批完成
	 */
	public void setJudgestatus(String judgestatus) {
		this.judgestatus = judgestatus;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getDepict() {
		return depict;
	}

	/**
	 * 描述设定
	 *
	 * @param depict 描述
	 */
	public void setDepict(String depict) {
		this.depict = depict;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
    public Serializable getPK() {
		return did;
	}

}