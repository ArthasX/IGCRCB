/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;

/**
 * ���̶���_ȱʡ������_Ȩ��VO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01161VO extends BaseVO implements Serializable {
	
	protected String psdid;
	
	protected String pdid;
	/** ����״̬ */
	protected IG333Info processStatusDef;
	
	/** ȱʡ��Ȩ����Ϣ���� */
	protected List<IG909Info> lst_ParticipantDefaultVariableVW;
	
	/** ��ط��������������Ϣ���� */
	protected List<IG913Info> Lst_processDefinitionInfo;
	
	/**
	 * ����״̬ȡ��
	 * @return
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ����״̬�趨
	 * @param processStatusDef����״̬
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * ȱʡ��Ȩ����Ϣ����ȡ��
	 * 
	 * @return ȱʡ��Ȩ����Ϣ����
	 */
	public List<IG909Info> getLst_ParticipantDefaultVariableVW() {
		return lst_ParticipantDefaultVariableVW;
	}

	/**
	 * ȱʡ��Ȩ����Ϣ�����趨
	 * 
	 * @param lst_ParticipantDefaultVariableVW ȱʡ��Ȩ����Ϣ����
	 */
	public void setLst_ParticipantDefaultVariableVW(
			List<IG909Info> lst_ParticipantDefaultVariableVW) {
		this.lst_ParticipantDefaultVariableVW = lst_ParticipantDefaultVariableVW;
	}
	public List<IG221Info> processParticipantButtonDefVWInfoList;

	public List<IG221Info> getProcessParticipantButtonDefVWInfoList() {
		return processParticipantButtonDefVWInfoList;
	}

	public void setProcessParticipantButtonDefVWInfoList(
			List<IG221Info> processParticipantButtonDefVWInfoList) {
		this.processParticipantButtonDefVWInfoList = processParticipantButtonDefVWInfoList;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

    /**
     * @return the lst_processDefinitionInfo
     */
    public List<IG913Info> getLst_processDefinitionInfo() {
        return Lst_processDefinitionInfo;
    }

    /**
     * @param lst_processDefinitionInfo the lst_processDefinitionInfo to set
     */
    public void setLst_processDefinitionInfo(
            List<IG913Info> lst_processDefinitionInfo) {
        Lst_processDefinitionInfo = lst_processDefinitionInfo;
    }
}
