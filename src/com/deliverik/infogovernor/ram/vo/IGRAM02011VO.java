package com.deliverik.infogovernor.ram.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;

/**
 * ��������������ʷ��ѯ�֣�
 *
 */
@SuppressWarnings("serial")
public class IGRAM02011VO extends BaseVO implements Serializable{

	/**������Ŀ����*/
	protected Map<String,List<IG007Info>> prjMap;
	
	/**������ʷ��ѯ��Ա�������*/
	protected List<IG337Info> ppList; 
	
	/**������ʷ��ѯ�����������*/
	protected List<AssessmentScoreVWInfo> hsList;



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

	/**
	 * hsListȡ��
	 */
	public List<AssessmentScoreVWInfo> getHsList() {
		return hsList;
	}

	/**
	 * hsList�趨
	 */
	public void setHsList(List<AssessmentScoreVWInfo> hsList) {
		this.hsList = hsList;
	}

	
}


