/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;

/**
 * ����:֪ʶ�����ֲ�ѯVO
 * ����������֪ʶ�����ֲ�ѯVO
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02071VO extends BaseVO implements Serializable{
	
	/**֪ʶ�����ֲ�ѯ���List*/
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
	 * ֪ʶ�����ֲ�ѯList���ȡ��
	 * @return ֪ʶ�����ֲ�ѯList���
	 */
	public List<KnowledgeGrade> getKnowledgeGradeList() {
		return knowledgeGradeList;
	}

	/**
	 * ֪ʶ�����ֲ�ѯList����趨
	 * @param knowledgeGradeList ֪ʶ�����ֲ�ѯList���
	 */
	public void setKnowledgeGradeList(List<KnowledgeGrade> knowledgeGradeList) {
		this.knowledgeGradeList = knowledgeGradeList;
	}

	


}


