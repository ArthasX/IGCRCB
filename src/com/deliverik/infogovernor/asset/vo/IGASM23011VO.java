/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 采集控制台信息检索结果ＶＯ
 * 功能描述: 采集控制台信息检索结果ＶＯ
 * 创建记录: 2011/05/04
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM23011VO extends BaseVO implements Serializable{
	
	/** 采集控制台检索结果 */
	protected List<ImportVersionInfo> importVersionInfoList;
	
	
	/**
	 * 构造函数
	 * 
	 * @param importVersionInfoList采集控制台检索结果
	 */
	public IGASM23011VO(List<ImportVersionInfo> importVersionInfoList) {
		super();
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * 采集控制台检索结果 
	 * @return 采集控制台检索结果 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * 采集控制台检索结果 
	 * @param importVersionInfoList采集控制台检索结果 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}
	
	
	

}
