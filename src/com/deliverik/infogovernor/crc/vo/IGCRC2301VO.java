/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * 概述: 程序开发信息查询VO 
 * 创建记录：yukexin    2014-8-7 10:03:28
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2301VO extends BaseVO{

	/** 程序开发信息集合 */
	protected List<IGCRC2301VWInfo> igcrc2301VWList;

	protected List<IG500Info> processList;
	
	
	/**
	 * 程序开发信息集合取得
	 * @return igcrc2301VWList  程序开发信息集合
	 */
	public List<IGCRC2301VWInfo> getIgcrc2301VWList() {
		return igcrc2301VWList;
	}

	/**
	 * 程序开发信息集合设定
	 * @param igcrc2301vwList  igcrc2301VWList
	 */
	public void setIgcrc2301VWList(List<IGCRC2301VWInfo> igcrc2301vwList) {
		igcrc2301VWList = igcrc2301vwList;
	}

	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
	
	
	

}
