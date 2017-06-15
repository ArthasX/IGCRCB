/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 流程定义_参与者_权限Vo
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01081VO extends BaseVO implements Serializable {

	/** 流程状态_参与者 */
	protected IG222Info processParticipantDef;
	
	/** 流程状态 */
	protected IG333Info processStatusDef;

	/** 参与者表单权限信息集合 */
	protected List<IG100Info> lst_processInfoParticipantDefVW;
	
	/** 自定义流程定义表信息集合 */
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
	 * 参与者表单权限信息集合取得
	 * 
	 * @return 参与者表单权限信息集合
	 */
	public List<IG100Info> getLst_processInfoParticipantDefVW() {
		return lst_processInfoParticipantDefVW;
	}

	/**
	 * 参与者表单权限信息集合设定
	 * 
	 * @param lst_processInfoParticipantDefVW 参与者表单权限信息集合
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
     * @return the 自定义流程定义表信息集合
     */
    public List<IG913Info> getLst_processDefinitionInfo() {
        return lst_processDefinitionInfo;
    }

    /**
     * @param 自定义流程定义表信息集合 the lst_processDefinitionInfo to set
     */
    public void setLst_processDefinitionInfo(
            List<IG913Info> lst_processDefinitionInfo) {
        this.lst_processDefinitionInfo = lst_processDefinitionInfo;
    }

    
}
