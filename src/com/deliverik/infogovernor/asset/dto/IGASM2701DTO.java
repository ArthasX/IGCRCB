package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;

@SuppressWarnings("serial")
public class IGASM2701DTO extends BaseDTO{

	/**风险集合取值范围集合*/
	protected List<SOC0151Info> levelList;

	/**风险等级取值范围集合*/
	protected List<SOC0151Info> gradeList;
	
	/**风险点资产FORM*/
	protected IGASM2713Form Igasm2713form;
	
	/**风险点查询集合*/
	private  List<RiskPointVMInfo> riskList;
	
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
		
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
	 * igasm2713form取得
	 * @return igasm2713form igasm2713form
	 */
	public IGASM2713Form getIgasm2713form() {
		return Igasm2713form;
	}

	/**
	 * igasm2713form设定
	 * @param igasm2713form igasm2713form
	 */
	public void setIgasm2713form(IGASM2713Form igasm2713form) {
		Igasm2713form = igasm2713form;
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
	 * 允许查询的最大记录数取得
	 * @return maxSearchCount 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

}
