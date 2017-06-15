package com.deliverik.infogovernor.ram.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;

/**
 * 风险评估评分历史查询ＶＯ
 *
 */
@SuppressWarnings("serial")
public class IGRAM02011VO extends BaseVO implements Serializable{

	/**评估项目集合*/
	protected Map<String,List<IG007Info>> prjMap;
	
	/**分数历史查询人员结果集合*/
	protected List<IG337Info> ppList; 
	
	/**分数历史查询分数结果集合*/
	protected List<AssessmentScoreVWInfo> hsList;



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

	/**
	 * hsList取得
	 */
	public List<AssessmentScoreVWInfo> getHsList() {
		return hsList;
	}

	/**
	 * hsList设定
	 */
	public void setHsList(List<AssessmentScoreVWInfo> hsList) {
		this.hsList = hsList;
	}

	
}


