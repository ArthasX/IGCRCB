package com.deliverik.infogovernor.ram.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;

/**
 * 风险评估DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRAM02DTO extends BaseDTO implements Serializable{

	/** 风险评估流程id */
	protected String prid;
	
	/** 风险评估流程类型id */
	protected String pdid;
	
	/**评估项目集合*/
	protected Map<String,List<IG007Info>> prjMap;
	
	/**分数历史查询人员结果集合*/
	protected List<IG337Info> ppList; 
	
	/**风险评估历史分数*/
	protected List<AssessmentScoreVWInfo> historyScoreList;

	/**
	 * prid取得
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * prid设定
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * pdid取得
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * pdid设定
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * historyScoreList取得
	 */
	public List<AssessmentScoreVWInfo> getHistoryScoreList() {
		return historyScoreList;
	}

	/**
	 * historyScoreList设定
	 */
	public void setHistoryScoreList(List<AssessmentScoreVWInfo> historyScoreList) {
		this.historyScoreList = historyScoreList;
	}


	/**
	 * prjMap取得
	 */
	public Map<String, List<IG007Info>> getPrjMap() {
		return prjMap;
	}

	/**
	 * prjMap设定
	 */
	public void setPrjMap(Map<String, List<IG007Info>> prjMap) {
		this.prjMap = prjMap;
	}

	/**
	 * ppList取得
	 */
	public List<IG337Info> getPpList() {
		return ppList;
	}

	/**
	 * ppList设定
	 */
	public void setPpList(List<IG337Info> ppList) {
		this.ppList = ppList;
	}
		
}


