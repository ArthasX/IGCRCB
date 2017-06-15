/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 导入对象信息添加后信息VO
 * 功能描述: 导入对象信息添加后信息VO
 * 创建记录: 2011/05/03
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20061VO extends BaseVO implements Serializable{
	
	/**
	 * 导入对象信息添加后信息
	 */
	protected ImportVersionInfo importVersionInfo;
	
	/**
	 * 导入版本
	 */
	protected Integer impversion;
	
	/**
	 * 导入对象实体名
	 */
	protected String impeiname;
	
	/**
	 * 构造函数
	 * @param eiDomainDefInfo资产预定义添加后信息
	 */
	public IGASM20061VO(ImportVersionInfo importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * 导入对象信息添加后信息
	 * @return 导入对象信息添加后信息
	 */
	public ImportVersionInfo getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * 导入对象信息添加后信息
	 * @param importVersionInfo导入对象信息添加后信息
	 */
	public void setImportVersionInfo(ImportVersionInfo importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * 导入版本
	 * @return 导入版本
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * 导入版本
	 * @param impversion导入版本
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * 导入对象实体名
	 * @return 导入对象实体名
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * 导入对象实体名
	 * @param impeiname导入对象实体名
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}
	
	

}
