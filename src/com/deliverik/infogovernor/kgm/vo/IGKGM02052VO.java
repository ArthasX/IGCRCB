/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;

/**
 * 概述:知识库查询业务系统VO
 * 功能描述：知识库查询业务系统VO
 * 创建记录：yangshengnan 2011-3-29
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM02052VO extends BaseVO implements Serializable {
	
	protected Knowledge knowledge;
	
	
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

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}


}
