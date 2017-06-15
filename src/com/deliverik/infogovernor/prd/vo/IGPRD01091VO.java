/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;

/**
 * ��������Ϣ��������֣�
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01091VO extends BaseVO implements Serializable {

	/** ��������Ϣ������� */
	protected List<IG273Info> processTransitionDefList;

	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;

	/** ����״̬_�����߼��� */
	protected List<IG222Info> processParticipantDefList;
	
	protected List<IG725Info> participantDefaultButtonDefInfoList;
	
	public List<IG725Info> getParticipantDefaultButtonDefInfoList() {
		return participantDefaultButtonDefInfoList;
	}

	public void setParticipantDefaultButtonDefInfoList(
			List<IG725Info> participantDefaultButtonDefInfoList) {
		this.participantDefaultButtonDefInfoList = participantDefaultButtonDefInfoList;
	}

	/**
	 * ���캯��
	 * 
	 * @param processTransitionDef
	 *            ����������Ϣ�������
	 * @param processStatusDef
	 *            ������״̬��Ϣ
	 */
	public IGPRD01091VO(List<IG273Info> processTransitionDefList,
			IG333Info processStatusDef,
			List<IG222Info> processParticipantDefList) {
		this.processTransitionDefList = processTransitionDefList;
		this.processStatusDef = processStatusDef;
		this.processParticipantDefList = processParticipantDefList;
	}

	/**
	 * ��������Ϣ�������ȡ��
	 * 
	 * @return ��������Ϣ�������
	 */
	public List<IG273Info> getProcessTransitionDefList() {
		return processTransitionDefList;
	}

	/**
	 * ����״̬��Ϣȡ��
	 * 
	 * @return ����״̬��Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ����״̬�����߼���ȡ��
	 * 
	 * @return ����״̬�����߼���
	 */
	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}
	
	public Map<String, List<IG132Info>> processParticipantButtonDefMap;

	public Map<String, List<IG132Info>> getProcessParticipantButtonDefMap() {
		return processParticipantButtonDefMap;
	}

	public void setProcessParticipantButtonDefMap(
			Map<String, List<IG132Info>> processParticipantButtonDefMap) {
		this.processParticipantButtonDefMap = processParticipantButtonDefMap;
	}
}
