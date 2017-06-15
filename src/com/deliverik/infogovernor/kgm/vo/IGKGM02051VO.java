/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.form.IGKGM0215Form;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;

/**
 * 概述:知识库查询VO
 * 功能描述：知识库查询VO
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02051VO extends BaseVO implements Serializable{
	
	/**知识库查询结果List*/
	protected List<KnowLedgeInfo> knowLedgeInfoList;

	/**知识库详细信息*/
	protected Knowledge knowledge;
	
	/**知识历史版本List*/
	protected List<Knowledge> knowledgeList;
	
	/**知识相关流程查询结果List*/
	protected List<KnowledgeProcess> knowledgeProcessList;
	
	/**知识库评分查询结果List*/
	protected List<KnowledgeGrade> knowledgeGradeList;
	
	/**是不是新消息*/
	protected String isNewKnowledge;
	
	/**
	 * 知识库评分查询List结果取得
	 * @return 知识库评分查询List结果
	 */
	public List<KnowledgeGrade> getKnowledgeGradeList() {
		return knowledgeGradeList;
	}

	/**
	 * 知识库评分查询List结果设定
	 * @param knowledgeGradeList 知识库评分查询List结果
	 */
	public void setKnowledgeGradeList(List<KnowledgeGrade> knowledgeGradeList) {
		this.knowledgeGradeList = knowledgeGradeList;
	}
	
	/**
	 * 知识相关流程查询结果取得
	 * @return 知识相关流程查询结果
	 */
	public List<KnowledgeProcess> getKnowledgeProcessList() {
		return knowledgeProcessList;
	}
	/**
	 * 知识相关流程查询结果设定
	 * @param knowledgeProcessList 知识相关流程查询结果
	 */
	public void setKnowledgeProcessList(List<KnowledgeProcess> knowledgeProcessList) {
		this.knowledgeProcessList = knowledgeProcessList;
	}
	
	/**
	 * 知识库详细信息取得
	 * @return 知识库详细信息
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * 知识库详细信息设定
	 * @param knowledge 知识库详细信息
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	/**
	 * 知识库查询结果List取得
	 * @return 知识库查询结果List
	 */
	public List<KnowLedgeInfo> getKnowLedgeInfoList() {
		return knowLedgeInfoList;
	}

	/**
	 * 知识库查询记过List设定
	 * @param knowLedgeInfoList 知识库查询记过List
	 */
	public void setKnowLedgeInfoList(List<KnowLedgeInfo> knowLedgeInfoList) {
		this.knowLedgeInfoList = knowLedgeInfoList;
	}
	/**
	 * 知识历史版本List取得
	 * @return 知识历史版本List
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}
	
	/**
	 * 知识历史版本List设定
	 * @param knowlegeList 知识历史版本List
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}



	protected IGKGM0215Form igkgm0215form;

	public IGKGM0215Form getIgkgm0215form() {
		return igkgm0215form;
	}
	public void setIgkgm0215form(IGKGM0215Form igkgm0215form) {
		this.igkgm0215form = igkgm0215form;
	}
	
	/** 业务系统List */
	protected List<KnowledgeAppImpact> knowledgeAppImpactList;

	/**
	 * 业务系统List取得
	 * @return 业务系统List
	 */
	public List<KnowledgeAppImpact> getKnowledgeAppImpactList() {
		return knowledgeAppImpactList;
	}
	
	/**
	 * 业务系统List设定
	 * @param knowledgeAppImpactList 业务系统List
	 */
	public void setKnowledgeAppImpactList(
			List<KnowledgeAppImpact> knowledgeAppImpactList) {
		this.knowledgeAppImpactList = knowledgeAppImpactList;
	}
	
	/** 业务系统VO */
	protected List<IGKGM02052VO> voList;

	/**
	 * 业务系统VO取得
	 * @return 业务系统VO
	 */
	public List<IGKGM02052VO> getVoList() {
		return voList;
	}
	
	/**
	 * 业务系统VO设定
	 * @param voList 业务系统VO
	 */
	public void setVoList(List<IGKGM02052VO> voList) {
		this.voList = voList;
	}

	public String getIsNewKnowledge() {
		return isNewKnowledge;
	}

	public void setIsNewKnowledge(String isNewKnowledge) {
		this.isNewKnowledge = isNewKnowledge;
	}
}


