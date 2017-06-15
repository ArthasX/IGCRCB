/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;

/**
 * 概述:知识库评分查询VO
 * 功能描述：知识库评分查询VO
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02071VO extends BaseVO implements Serializable{
	
	/**知识库评分查询结果List*/
	protected List<KnowledgeGrade> knowledgeGradeList;
	
	protected List<KnowledgeAppImpact>  knowledgeAppImpactList;

	
	public List<KnowledgeAppImpact> getKnowledgeAppImpactList() {
		return knowledgeAppImpactList;
	}

	public void setKnowledgeAppImpactList(
			List<KnowledgeAppImpact> knowledgeAppImpactList) {
		this.knowledgeAppImpactList = knowledgeAppImpactList;
	}

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

	


}


