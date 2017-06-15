/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:֪ʶ���ѯVO
 * ����������֪ʶ���ѯVO
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02051VO extends BaseVO implements Serializable{
	
	/**֪ʶ���ѯ���List*/
	protected List<KnowLedgeInfo> knowLedgeInfoList;

	/**֪ʶ����ϸ��Ϣ*/
	protected Knowledge knowledge;
	
	/**֪ʶ��ʷ�汾List*/
	protected List<Knowledge> knowledgeList;
	
	/**֪ʶ������̲�ѯ���List*/
	protected List<KnowledgeProcess> knowledgeProcessList;
	
	/**֪ʶ�����ֲ�ѯ���List*/
	protected List<KnowledgeGrade> knowledgeGradeList;
	
	/**�ǲ�������Ϣ*/
	protected String isNewKnowledge;
	
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
	
	/**
	 * ֪ʶ������̲�ѯ���ȡ��
	 * @return ֪ʶ������̲�ѯ���
	 */
	public List<KnowledgeProcess> getKnowledgeProcessList() {
		return knowledgeProcessList;
	}
	/**
	 * ֪ʶ������̲�ѯ����趨
	 * @param knowledgeProcessList ֪ʶ������̲�ѯ���
	 */
	public void setKnowledgeProcessList(List<KnowledgeProcess> knowledgeProcessList) {
		this.knowledgeProcessList = knowledgeProcessList;
	}
	
	/**
	 * ֪ʶ����ϸ��Ϣȡ��
	 * @return ֪ʶ����ϸ��Ϣ
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * ֪ʶ����ϸ��Ϣ�趨
	 * @param knowledge ֪ʶ����ϸ��Ϣ
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	/**
	 * ֪ʶ���ѯ���Listȡ��
	 * @return ֪ʶ���ѯ���List
	 */
	public List<KnowLedgeInfo> getKnowLedgeInfoList() {
		return knowLedgeInfoList;
	}

	/**
	 * ֪ʶ���ѯ�ǹ�List�趨
	 * @param knowLedgeInfoList ֪ʶ���ѯ�ǹ�List
	 */
	public void setKnowLedgeInfoList(List<KnowLedgeInfo> knowLedgeInfoList) {
		this.knowLedgeInfoList = knowLedgeInfoList;
	}
	/**
	 * ֪ʶ��ʷ�汾Listȡ��
	 * @return ֪ʶ��ʷ�汾List
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}
	
	/**
	 * ֪ʶ��ʷ�汾List�趨
	 * @param knowlegeList ֪ʶ��ʷ�汾List
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
	
	/** ҵ��ϵͳVO */
	protected List<IGKGM02052VO> voList;

	/**
	 * ҵ��ϵͳVOȡ��
	 * @return ҵ��ϵͳVO
	 */
	public List<IGKGM02052VO> getVoList() {
		return voList;
	}
	
	/**
	 * ҵ��ϵͳVO�趨
	 * @param voList ҵ��ϵͳVO
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


