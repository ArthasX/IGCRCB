/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wkm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGWKM01101VO extends BaseVO{

	/** 流程对象List */
	protected List<IG500Info> processList;

	/**
	 * 流程对象List取得
	 * @return processList 流程对象List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * 流程对象List设定
	 * @param processList 流程对象List
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
}
