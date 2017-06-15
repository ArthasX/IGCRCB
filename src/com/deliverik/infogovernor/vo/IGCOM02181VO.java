/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.infogovernor.kgm.model.Knowledge;

/**
 * ����: Ӧ�ù�����ҳ��ʾAction����
 * ��������: Ӧ�ù�����ҳ��ʾAction����
 * ������¼: 2012/03/01
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCOM02181VO extends BaseVO implements Serializable{
	
	/** �澯��Ϣ */
	protected List<SOC0305Info> soc0305List;
	
	/** �澯��ͼ��Ϣ */
	protected List<SOC0307Info> soc0307List;

	/** ֪ʶ��Ϣ */
	protected List<Knowledge> knowledgeList;

	/**
	 * �澯��Ϣȡ��
	 *
	 * @return soc0305List �澯��Ϣ
	 */
	public List<SOC0305Info> getSoc0305List() {
		return soc0305List;
	}

	/**
	 * �澯��Ϣ�趨
	 *
	 * @param soc0305List �澯��Ϣ
	 */
	public void setSoc0305List(List<SOC0305Info> soc0305List) {
		this.soc0305List = soc0305List;
	}

	

	/**
	 * ֪ʶ��Ϣȡ��
	 *
	 * @return knowledgeList ֪ʶ��Ϣ
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	/**
	 * ֪ʶ��Ϣ�趨
	 *
	 * @param knowledgeList ֪ʶ��Ϣ
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	/**
	 * �澯��ͼ��Ϣȡ��
	 *
	 * @return soc0307List �澯��ͼ��Ϣ
	 */
	public List<SOC0307Info> getSoc0307List() {
		return soc0307List;
	}

	/**
	 * �澯��ͼ��Ϣ�趨
	 *
	 * @param soc0307List �澯��ͼ��Ϣ
	 */
	public void setSoc0307List(List<SOC0307Info> soc0307List) {
		this.soc0307List = soc0307List;
	}



	
	
}


