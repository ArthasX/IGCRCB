/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: CI变更任务信息检索结果ＶＯ
 * 功能描述: CI变更任务信息检索结果ＶＯ
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM22071VO extends BaseVO implements Serializable {
	
	/** CI变更任务检索结果 */
	protected List<CITaskInfo> ciTaskInfoList;

	
	/**
	 * 构造函数
	 * @param ciTaskInfoListCI变更任务检索结果
	 */
	public IGASM22071VO(List<CITaskInfo> ciTaskInfoList) {
		super();
		this.ciTaskInfoList = ciTaskInfoList;
	}

	/**
	 * CI变更任务检索结果取得
	 * @return CI变更任务检索结果
	 */
	public List<CITaskInfo> getCiTaskInfoList() {
		return ciTaskInfoList;
	}

	/**
	 * CI变更任务检索结果设定
	 * @param ciTaskInfoListCI变更任务检索结果
	 */
	public void setCITaskInfoList(List<CITaskInfo> ciTaskInfoList) {
		this.ciTaskInfoList = ciTaskInfoList;
	}
	
	
	
	
	
}
