/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 流程定义_缺省参与者_权限VO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01161VO extends BaseVO implements Serializable {
	
	protected String psdid;
	
	protected String pdid;
	/** 流程状态 */
	protected IG333Info processStatusDef;
	
	/** 缺省表单权限信息集合 */
	protected List<IG909Info> lst_ParticipantDefaultVariableVW;
	
	/** 相关发起的流程类型信息集合 */
	protected List<IG913Info> Lst_processDefinitionInfo;
	
	/**
	 * 流程状态取得
	 * @return
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * 流程状态设定
	 * @param processStatusDef流程状态
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * 缺省表单权限信息集合取得
	 * 
	 * @return 缺省表单权限信息集合
	 */
	public List<IG909Info> getLst_ParticipantDefaultVariableVW() {
		return lst_ParticipantDefaultVariableVW;
	}

	/**
	 * 缺省表单权限信息集合设定
	 * 
	 * @param lst_ParticipantDefaultVariableVW 缺省表单权限信息集合
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
