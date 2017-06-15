/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class RiskVWCondImpl implements RiskVWCond {
	/** 风险领域*/
	protected String riskly;
	
	/** 风险子域*/
	protected String riskarea;
	
	/** 风险项*/
	protected String riskitem;
	
	/** 风险点（检查点）*/
	protected String einame;
	
	/** 严重等级*/
	protected String grad;
	
	/** 发生可能性*/
	protected String poss;
	
	/** 风险级别*/
	protected String levels;
	
	/** 风险点标志*/
	protected String risksign;

	/**
	 * 风险领域取得
	 * @return riskly 风险领域
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * 风险领域设定
	 * @param riskly 风险领域
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * 风险子域取得
	 * @return riskarea 风险子域
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * 风险子域设定
	 * @param riskarea 风险子域
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * 风险项取得
	 * @return riskitem 风险项
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * 风险项设定
	 * @param riskitem 风险项
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}

	/**
	 * 风险点（检查点）取得
	 * @return einame 风险点（检查点）
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 风险点（检查点）设定
	 * @param einame 风险点（检查点）
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 严重等级取得
	 * @return grad 严重等级
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * 严重等级设定
	 * @param grad 严重等级
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}

	/**
	 * 发生可能性取得
	 * @return poss 发生可能性
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * 发生可能性设定
	 * @param poss 发生可能性
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * 风险级别取得
	 * @return levels 风险级别
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * 风险级别设定
	 * @param levels 风险级别
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * 风险点标志取得
	 * @return risksign 风险点标志
	 */
	public String getRisksign() {
		return risksign;
	}

	/**
	 * 风险点标志设定
	 * @param risksign 风险点标志
	 */
	public void setRisksign(String risksign) {
		this.risksign = risksign;
	}
}
