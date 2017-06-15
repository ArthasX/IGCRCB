/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseDTO;
/**
 * 概述: 资产域定义业务用DTO
 * 功能描述: 资产域定义业务用DTO
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM23DTO extends BaseDTO implements Serializable {

	/**
	 * 导入对象表检索条件接口
	 */
	protected ImportVersionSearchCond importVersionSearchCond;
	
	/** 对象ID集合 */
	protected String[] collectIds;
	
	/** 导入对象检索结果 */
	protected List<ImportVersionInfo> importVersionInfoList;

	/**
	 * 导入对象表检索条件接口取得
	 * @return 导入对象表检索条件接口
	 */
	public ImportVersionSearchCond getImportVersionSearchCond() {
		return importVersionSearchCond;
	}

	/**
	 * 导入对象表检索条件接口设定
	 * @param importVersionSearchCond导入对象表检索条件接口
	 */
	public void setImportVersionSearchCond(
			ImportVersionSearchCond importVersionSearchCond) {
		this.importVersionSearchCond = importVersionSearchCond;
	}

	/**
	 * 对象ID集合
	 * @return 对象ID集合
	 */
	public String[] getCollectIds() {
		return collectIds;
	}

	/**
	 * 对象ID集合
	 * @param collectIds 对象ID集合
	 */
	public void setCollectIds(String[] collectIds) {
		this.collectIds = collectIds;
	}
	
	/**
	 * 导入对象检索结果 
	 * @return 导入对象检索结果 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * 导入对象检索结果 
	 * @param importVersionInfoList导入对象检索结果 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}
	
}
