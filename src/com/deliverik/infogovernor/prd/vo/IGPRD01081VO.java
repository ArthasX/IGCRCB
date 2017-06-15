/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;

/**
 * ���̶���_������_Ȩ��Vo
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01081VO extends BaseVO implements Serializable {

	/** ����״̬_������ */
	protected IG222Info processParticipantDef;
	
	/** ����״̬ */
	protected IG333Info processStatusDef;

	/** �����߱�Ȩ����Ϣ���� */
	protected List<IG100Info> lst_processInfoParticipantDefVW;
	
	/** �Զ������̶������Ϣ���� */
    protected List<IG913Info> lst_processDefinitionInfo;
	
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	public IG222Info getProcessParticipantDef() {
		return processParticipantDef;
	}

	public void setProcessParticipantDef(IG222Info processParticipantDef) {
		this.processParticipantDef = processParticipantDef;
	}

	/**
	 * �����߱�Ȩ����Ϣ����ȡ��
	 * 
	 * @return �����߱�Ȩ����Ϣ����
	 */
	public List<IG100Info> getLst_processInfoParticipantDefVW() {
		return lst_processInfoParticipantDefVW;
	}

	/**
	 * �����߱�Ȩ����Ϣ�����趨
	 * 
	 * @param lst_processInfoParticipantDefVW �����߱�Ȩ����Ϣ����
	 */
	public void setLst_processInfoParticipantDefVW(
			List<IG100Info> lst_processInfoParticipantDefVW) {
		this.lst_processInfoParticipantDefVW = lst_processInfoParticipantDefVW;
	}
	
	public List<IG221Info> processParticipantButtonDefVWInfoList;

	public List<IG221Info> getProcessParticipantButtonDefVWInfoList() {
		return processParticipantButtonDefVWInfoList;
	}

	public void setProcessParticipantButtonDefVWInfoList(
			List<IG221Info> processParticipantButtonDefVWInfoList) {
		this.processParticipantButtonDefVWInfoList = processParticipantButtonDefVWInfoList;
	}

    /**
     * @return the �Զ������̶������Ϣ����
     */
    public List<IG913Info> getLst_processDefinitionInfo() {
        return lst_processDefinitionInfo;
    }

    /**
     * @param �Զ������̶������Ϣ���� the lst_processDefinitionInfo to set
     */
    public void setLst_processDefinitionInfo(
            List<IG913Info> lst_processDefinitionInfo) {
        this.lst_processDefinitionInfo = lst_processDefinitionInfo;
    }

    
}
