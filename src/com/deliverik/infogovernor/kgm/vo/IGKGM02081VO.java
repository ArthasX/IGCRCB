/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.Knowledge;


/**
 * ����: ֪ʶ��˻���VO
 * ����������1.֪ʶ��˻���VO
 *          
 * ������¼���κ��� 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02081VO extends BaseVO implements Serializable{
	

	/** ֪ʶ����� */
	private List<Knowledge>  knowledgeList;
	/**
	 * ֪ʶ�������ȡ��
	 * @return ֪ʶ�����
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}
	/**
	 * �趨֪ʶ�����
	 * @param knowledgeList ֪ʶ�����
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}
	
	

}


