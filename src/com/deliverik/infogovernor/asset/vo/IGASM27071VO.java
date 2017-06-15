package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;

@SuppressWarnings("serial")
public class IGASM27071VO extends BaseVO implements Serializable{
	
	/**风险集合取值范围集合*/
	protected List<SOC0151Info> levelList;

	/**风险等级取值范围集合*/
	protected List<SOC0151Info> gradeList;

	/**风险点可能性*/
	protected List<SOC0151Info> possibleList;
	/**风险标识集合*/
	protected List<SOC0151Info> signList;
	
	/**风险点查询集合*/
	private  List<RiskPointVMInfo> riskList;
	
	/**风险点查询form*/
	protected IGASM2713Form igasm2713form;
	/**
	 * 风险点查询form取得
	 * @return igasm2713form 风险点查询form
	 */
	public IGASM2713Form getIgasm2713form() {
		return igasm2713form;
	}

	/**
	 * 风险点查询form设定
	 * @param igasm2713form 风险点查询form
	 */
	public void setIgasm2713form(IGASM2713Form igasm2713form) {
		this.igasm2713form = igasm2713form;
	}

	/**
	 * 风险集合取值范围集合取得
	 * @return levelList 风险集合取值范围集合
	 */
	public List<SOC0151Info> getLevelList() {
		return levelList;
	}

	/**
	 * 风险集合取值范围集合设定
	 * @param levelList 风险集合取值范围集合
	 */
	public void setLevelList(List<SOC0151Info> levelList) {
		this.levelList = levelList;
	}

	/**
	 * 风险等级取值范围集合取得
	 * @return gradeList 风险等级取值范围集合
	 */
	public List<SOC0151Info> getGradeList() {
		return gradeList;
	}

	/**
	 * 风险等级取值范围集合设定
	 * @param gradeList 风险等级取值范围集合
	 */
	public void setGradeList(List<SOC0151Info> gradeList) {
		this.gradeList = gradeList;
	}

	/**
	 * 风险点查询集合取得
	 * @return riskList 风险点查询集合
	 */
	public List<RiskPointVMInfo> getRiskList() {
		return riskList;
	}

	/**
	 * 风险点查询集合设定
	 * @param riskList 风险点查询集合
	 */
	public void setRiskList(List<RiskPointVMInfo> riskList) {
		this.riskList = riskList;
	}

	/**
	 * 风险点可能性取得
	 * @return possibleList 风险点可能性
	 */
	public List<SOC0151Info> getPossibleList() {
		return possibleList;
	}

	/**
	 * 风险点可能性设定
	 * @param possibleList 风险点可能性
	 */
	public void setPossibleList(List<SOC0151Info> possibleList) {
		this.possibleList = possibleList;
	}

	/**
	 * 风险标识集合取得
	 * @return signList 风险标识集合
	 */
	public List<SOC0151Info> getSignList() {
		return signList;
	}

	/**
	 * 风险标识集合设定
	 * @param signList 风险标识集合
	 */
	public void setSignList(List<SOC0151Info> signList) {
		this.signList = signList;
	}

}
