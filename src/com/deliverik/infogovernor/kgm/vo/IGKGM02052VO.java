/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;

/**
 * ����:֪ʶ���ѯҵ��ϵͳVO
 * ����������֪ʶ���ѯҵ��ϵͳVO
 * ������¼��yangshengnan 2011-3-29
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02052VO extends BaseVO implements Serializable {
	
	protected Knowledge knowledge;
	
	
	/** ҵ��ϵͳList */
	protected List<KnowledgeAppImpact> knowledgeAppImpactList;

	/**
	 * ҵ��ϵͳListȡ��
	 * @return ҵ��ϵͳList
	 */
	public List<KnowledgeAppImpact> getKnowledgeAppImpactList() {
		return knowledgeAppImpactList;
	}
	
	/**
	 * ҵ��ϵͳList�趨
	 * @param knowledgeAppImpactList ҵ��ϵͳList
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
