/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG222Info;

/**
 * ���̶���_���ɽ�ɫVO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01141VO extends BaseVO implements Serializable {

	
	/**  ����Ӳ����� */
	protected List<IG222Info> processParticipantDefList;

	/**
	 * ���췽��
	 * @param processParticipantDefList
	 */
	public IGPRD01141VO(List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}
	
	/**
	 * ����Ӳ�����ȡ��
	 * @return ����Ӳ�����
	 */

	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}


	
}
