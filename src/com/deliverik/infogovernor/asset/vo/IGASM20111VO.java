/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;
/**
 * 概述: 导入对象信息检索结果ＶＯ
 * 功能描述: 导入对象信息检索结果ＶＯ
 * 创建记录: 2011/05/05
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20111VO extends BaseVO implements Serializable{
	
	/** 导入对象版本检索结果 */
	protected List<ImportVersionInfo> importVersionInfoList;
	
	/** 导入对象检索结果 */
	protected ImportVersionInfo importVersionInfo;
	
	
	
	/**
	 * 构造函数
	 * @param importVersionInfoList导入对象版本检索结果
	 * @param importVersionInfo导入对象检索结果
	 */
	public IGASM20111VO(List<ImportVersionInfo> importVersionInfoList,
			ImportVersionInfo importVersionInfo) {
		super();
		this.importVersionInfoList = importVersionInfoList;
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * 导入对象版本检索结果取得
	 * @return 导入对象检索结果 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * 导入对象版本检索结果设定
	 * @param importVersionInfoList导入对象检索结果 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * 导入对象检索结果
	 * @return 导入对象检索结果
	 */
	public ImportVersionInfo getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * 导入对象检索结果
	 * @param importVersionInfo导入对象检索结果
	 */
	public void setImportVersionInfo(ImportVersionInfo importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}
	
	

}
