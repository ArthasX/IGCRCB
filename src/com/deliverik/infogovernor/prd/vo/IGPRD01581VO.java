/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;

/**
 * 概述: 流程通知策略设定VO
 * 功能描述: 流程通知策略设定VO
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD01581VO extends BaseVO implements Serializable {

	/** 流程策略列表 */
	protected List<IG238Info> lst_ProcessNoticeStrategyDef;
	
	/** 页面显示策略信息Map */
	protected Map<IG238Info, List<IG335Info>> showMap;
	
	/** 流程整体策略 */
    protected List<IG335Info> processWholeTactic_list;

	/**
	 * 流程策略列表取得
	 * 
	 * @return 流程策略列表
	 */
	public List<IG238Info> getLst_ProcessNoticeStrategyDef() {
		return lst_ProcessNoticeStrategyDef;
	}

	/**
	 * 流程策略列表设定
	 * 
	 * @param lst_ProcessNoticeStrategyDef 流程策略列表
	 */
	public void setLst_ProcessNoticeStrategyDef(
			List<IG238Info> lst_ProcessNoticeStrategyDef) {
		this.lst_ProcessNoticeStrategyDef = lst_ProcessNoticeStrategyDef;
	}

	/**
	 * 页面显示策略信息Map取得
	 * @return showMap 页面显示策略信息Map
	 */
	public Map<IG238Info, List<IG335Info>> getShowMap() {
		return showMap;
	}

	/**
	 * 页面显示策略信息Map设定
	 * @param showMap 页面显示策略信息Map
	 */
	public void setShowMap(Map<IG238Info, List<IG335Info>> showMap) {
		this.showMap = showMap;
	}

    /** 
     * 流程整体策略 取得
     * @return processWholeTactic_list 流程整体策略 
     */
    public List<IG335Info> getProcessWholeTactic_list() {
        return processWholeTactic_list;
    }

    /** 
     * 流程整体策略 设定
     * @param processWholeTactic_list 流程整体策略 
     */
    public void setProcessWholeTactic_list(List<IG335Info> processWholeTactic_list) {
        this.processWholeTactic_list = processWholeTactic_list;
    }

}
