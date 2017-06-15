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
 * ��������DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRAM02DTO extends BaseDTO implements Serializable{

	/** ������������id */
	protected String prid;
	
	/** ����������������id */
	protected String pdid;
	
	/**������Ŀ����*/
	protected Map<String,List<IG007Info>> prjMap;
	
	/**������ʷ��ѯ��Ա�������*/
	protected List<IG337Info> ppList; 
	
	/**����������ʷ����*/
	protected List<AssessmentScoreVWInfo> historyScoreList;

	/**
	 * pridȡ��
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * prid�趨
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * pdidȡ��
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * pdid�趨
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * historyScoreListȡ��
	 */
	public List<AssessmentScoreVWInfo> getHistoryScoreList() {
		return historyScoreList;
	}

	/**
	 * historyScoreList�趨
	 */
	public void setHistoryScoreList(List<AssessmentScoreVWInfo> historyScoreList) {
		this.historyScoreList = historyScoreList;
	}


	/**
	 * prjMapȡ��
	 */
	public Map<String, List<IG007Info>> getPrjMap() {
		return prjMap;
	}

	/**
	 * prjMap�趨
	 */
	public void setPrjMap(Map<String, List<IG007Info>> prjMap) {
		this.prjMap = prjMap;
	}

	/**
	 * ppListȡ��
	 */
	public List<IG337Info> getPpList() {
		return ppList;
	}

	/**
	 * ppList�趨
	 */
	public void setPpList(List<IG337Info> ppList) {
		this.ppList = ppList;
	}
		
}


