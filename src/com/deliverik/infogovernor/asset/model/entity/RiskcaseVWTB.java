/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;

/**
  * 概述: 风险事件实体
  * 功能描述: 风险事件实体
  * 创建记录: 2014/07/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="riskcaseVW")
public class RiskcaseVWTB extends BaseEntity implements Serializable,
		Cloneable, RiskcaseVWInfo {

	/** 资产ID */
	@Id
	protected Integer EIID;

	/** 风险事件名称 */
	protected String fcname;

	/** 风险事件描述 */
	protected String fcdesc;

	/** 风险事件状态 */
	protected String EISTATUS;

	/** 风险点名称 */
	protected String fcriskname;

	/** 风险点ID  */
	protected String riskid;

	/** 风险事件来源 */
	protected String fcorigin;

	/** 风险事件所属领域 */
	protected String fccategory;

	/** 相关评估工作ID  */
	protected String riskjobid;

	/** 风险点分类ID */
	protected String risktype;

	/** 风险严重级别名称 */
	protected String fcseveritylevel;

	/** 风险发生可能性名称 */
	protected String fcpossibility;

	/** 风险级别名称 */
	protected String fclevel;

	/** 风险识别时间 */
	protected String riskcatchtime;

	/** 应对任务名称 */
	protected String fcrisktask;

	/** 应对任务描述 */
	protected String fcrisktaskdesc;

	/** 应对策略 */
	protected String fcpolicy;

	/** 应对目标  */
	protected String fcoperatoraim;

	/** 应对部门ID */
	protected String riskoperatordept;

	/** 应对部门 */
	protected String fcoperatordept;

	/** 应对负责人ID */
	protected String riskoperator;

	/** 应对负责人 */
	protected String fcoperator;

	/** 抄送风控人员ID */
	protected String riskccoperator;

	/** 抄送风控人员 */
	protected String fcccoperator;

	/** 评审结果 */
	protected String riskreviewresult;
	
	/** 相关问题整改ID */
	protected String riskdealid;
	
	/** 版本 */
	protected String version;

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEIID() {
		return EIID;
	}

	/**
	 * 资产ID设定
	 *
	 * @param EIID 资产ID
	 */
	public void setEIID(Integer EIID) {
		this.EIID = EIID;
	}

	/**
	 * 风险事件名称取得
	 *
	 * @return 风险事件名称
	 */
	public String getFcname() {
		return fcname;
	}

	/**
	 * 风险事件名称设定
	 *
	 * @param fcname 风险事件名称
	 */
	public void setFcname(String fcname) {
		this.fcname = fcname;
	}

	/**
	 * 风险事件描述取得
	 *
	 * @return 风险事件描述
	 */
	public String getFcdesc() {
		return fcdesc;
	}

	/**
	 * 风险事件描述设定
	 *
	 * @param fcdesc 风险事件描述
	 */
	public void setFcdesc(String fcdesc) {
		this.fcdesc = fcdesc;
	}

	/**
	 * 风险事件状态取得
	 *
	 * @return 风险事件状态
	 */
	public String getEISTATUS() {
		return EISTATUS;
	}

	/**
	 * 风险事件状态设定
	 *
	 * @param EISTATUS 风险事件状态
	 */
	public void setEISTATUS(String EISTATUS) {
		this.EISTATUS = EISTATUS;
	}

	/**
	 * 风险点名称取得
	 *
	 * @return 风险点名称
	 */
	public String getFcriskname() {
		return fcriskname;
	}

	/**
	 * 风险点名称设定
	 *
	 * @param fcriskname 风险点名称
	 */
	public void setFcriskname(String fcriskname) {
		this.fcriskname = fcriskname;
	}

	/**
	 * 风险点ID 取得
	 *
	 * @return 风险点ID 
	 */
	public String getRiskid() {
		return riskid;
	}

	/**
	 * 风险点ID 设定
	 *
	 * @param riskid 风险点ID 
	 */
	public void setRiskid(String riskid) {
		this.riskid = riskid;
	}

	/**
	 * 风险事件来源取得
	 *
	 * @return 风险事件来源
	 */
	public String getFcorigin() {
		return fcorigin;
	}

	/**
	 * 风险事件来源设定
	 *
	 * @param fcorigin 风险事件来源
	 */
	public void setFcorigin(String fcorigin) {
		this.fcorigin = fcorigin;
	}

	/**
	 * 风险事件所属领域取得
	 *
	 * @return 风险事件所属领域
	 */
	public String getFccategory() {
		return fccategory;
	}

	/**
	 * 风险事件所属领域设定
	 *
	 * @param fccategory 风险事件所属领域
	 */
	public void setFccategory(String fccategory) {
		this.fccategory = fccategory;
	}

	/**
	 * 相关评估工作ID 取得
	 *
	 * @return 相关评估工作ID 
	 */
	public String getRiskjobid() {
		return riskjobid;
	}

	/**
	 * 相关评估工作ID 设定
	 *
	 * @param riskjobid 相关评估工作ID 
	 */
	public void setRiskjobid(String riskjobid) {
		this.riskjobid = riskjobid;
	}

	/**
	 * 风险点分类ID取得
	 *
	 * @return 风险点分类ID
	 */
	public String getRisktype() {
		return risktype;
	}

	/**
	 * 风险点分类ID设定
	 *
	 * @param risktype 风险点分类ID
	 */
	public void setRisktype(String risktype) {
		this.risktype = risktype;
	}

	/**
	 * 风险严重级别名称取得
	 *
	 * @return 风险严重级别名称
	 */
	public String getFcseveritylevel() {
		return fcseveritylevel;
	}

	/**
	 * 风险严重级别名称设定
	 *
	 * @param fcseveritylevel 风险严重级别名称
	 */
	public void setFcseveritylevel(String fcseveritylevel) {
		this.fcseveritylevel = fcseveritylevel;
	}

	/**
	 * 风险发生可能性名称取得
	 *
	 * @return 风险发生可能性名称
	 */
	public String getFcpossibility() {
		return fcpossibility;
	}

	/**
	 * 风险发生可能性名称设定
	 *
	 * @param fcpossibility 风险发生可能性名称
	 */
	public void setFcpossibility(String fcpossibility) {
		this.fcpossibility = fcpossibility;
	}

	/**
	 * 风险级别名称取得
	 *
	 * @return 风险级别名称
	 */
	public String getFclevel() {
		return fclevel;
	}

	/**
	 * 风险级别名称设定
	 *
	 * @param fclevel 风险级别名称
	 */
	public void setFclevel(String fclevel) {
		this.fclevel = fclevel;
	}

	/**
	 * 风险识别时间取得
	 *
	 * @return 风险识别时间
	 */
	public String getRiskcatchtime() {
		return riskcatchtime;
	}

	/**
	 * 风险识别时间设定
	 *
	 * @param riskcatchtime 风险识别时间
	 */
	public void setRiskcatchtime(String riskcatchtime) {
		this.riskcatchtime = riskcatchtime;
	}

	/**
	 * 应对任务名称取得
	 *
	 * @return 应对任务名称
	 */
	public String getFcrisktask() {
		return fcrisktask;
	}

	/**
	 * 应对任务名称设定
	 *
	 * @param fcrisktask 应对任务名称
	 */
	public void setFcrisktask(String fcrisktask) {
		this.fcrisktask = fcrisktask;
	}

	/**
	 * 应对任务描述取得
	 *
	 * @return 应对任务描述
	 */
	public String getFcrisktaskdesc() {
		return fcrisktaskdesc;
	}

	/**
	 * 应对任务描述设定
	 *
	 * @param fcrisktaskdesc 应对任务描述
	 */
	public void setFcrisktaskdesc(String fcrisktaskdesc) {
		this.fcrisktaskdesc = fcrisktaskdesc;
	}

	/**
	 * 应对策略取得
	 *
	 * @return 应对策略
	 */
	public String getFcpolicy() {
		return fcpolicy;
	}

	/**
	 * 应对策略设定
	 *
	 * @param fcpolicy 应对策略
	 */
	public void setFcpolicy(String fcpolicy) {
		this.fcpolicy = fcpolicy;
	}

	/**
	 * 应对目标 取得
	 *
	 * @return 应对目标 
	 */
	public String getFcoperatoraim() {
		return fcoperatoraim;
	}

	/**
	 * 应对目标 设定
	 *
	 * @param fcoperatoraim 应对目标 
	 */
	public void setFcoperatoraim(String fcoperatoraim) {
		this.fcoperatoraim = fcoperatoraim;
	}

	/**
	 * 应对部门ID取得
	 *
	 * @return 应对部门ID
	 */
	public String getRiskoperatordept() {
		return riskoperatordept;
	}

	/**
	 * 应对部门ID设定
	 *
	 * @param riskoperatordept 应对部门ID
	 */
	public void setRiskoperatordept(String riskoperatordept) {
		this.riskoperatordept = riskoperatordept;
	}

	/**
	 * 应对部门取得
	 *
	 * @return 应对部门
	 */
	public String getFcoperatordept() {
		return fcoperatordept;
	}

	/**
	 * 应对部门设定
	 *
	 * @param fcoperatordept 应对部门
	 */
	public void setFcoperatordept(String fcoperatordept) {
		this.fcoperatordept = fcoperatordept;
	}

	/**
	 * 应对负责人ID取得
	 *
	 * @return 应对负责人ID
	 */
	public String getRiskoperator() {
		return riskoperator;
	}

	/**
	 * 应对负责人ID设定
	 *
	 * @param riskoperator 应对负责人ID
	 */
	public void setRiskoperator(String riskoperator) {
		this.riskoperator = riskoperator;
	}

	/**
	 * 应对负责人取得
	 *
	 * @return 应对负责人
	 */
	public String getFcoperator() {
		return fcoperator;
	}

	/**
	 * 应对负责人设定
	 *
	 * @param fcoperator 应对负责人
	 */
	public void setFcoperator(String fcoperator) {
		this.fcoperator = fcoperator;
	}

	/**
	 * 抄送风控人员ID取得
	 *
	 * @return 抄送风控人员ID
	 */
	public String getRiskccoperator() {
		return riskccoperator;
	}

	/**
	 * 抄送风控人员ID设定
	 *
	 * @param riskccoperator 抄送风控人员ID
	 */
	public void setRiskccoperator(String riskccoperator) {
		this.riskccoperator = riskccoperator;
	}

	/**
	 * 抄送风控人员取得
	 *
	 * @return 抄送风控人员
	 */
	public String getFcccoperator() {
		return fcccoperator;
	}

	/**
	 * 抄送风控人员设定
	 *
	 * @param fcccoperator 抄送风控人员
	 */
	public void setFcccoperator(String fcccoperator) {
		this.fcccoperator = fcccoperator;
	}

	/**
	 * 评审结果取得
	 *
	 * @return 评审结果
	 */
	public String getRiskreviewresult() {
		return riskreviewresult;
	}

	/**
	 * 评审结果设定
	 *
	 * @param riskreviewresult 评审结果
	 */
	public void setRiskreviewresult(String riskreviewresult) {
		this.riskreviewresult = riskreviewresult;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return EIID;
	}

	public String getRiskdealid() {
		return riskdealid;
	}

	public void setRiskdealid(String riskdealid) {
		this.riskdealid = riskdealid;
	}

	/**
	 * 版本取得
	 * @return version 版本
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 版本设定
	 * @param version 版本
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}