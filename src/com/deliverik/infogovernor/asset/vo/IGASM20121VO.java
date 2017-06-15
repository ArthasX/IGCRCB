/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 资产域定义信息检索结果ＶＯ
 * 功能描述: 资产域定义信息检索结果ＶＯ
 * 创建记录: 2011/04/26
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20121VO extends BaseVO implements Serializable{
	
	/** 资产域定义检索结果 */
	protected EiDomainDefInfo eiDomainDefInfo;
	
	/** 资产域定义版本检索结果 */
	protected List<EiDomainDefInfo> eiDomainDefInfoList;
	
	
	/**
	 * 构造函数
	 * @param eiDomainDefInfo资产域定义检索结果
	 * @param eiDomainDefInfoList资产域定义版本检索结果
	 */
	public IGASM20121VO(EiDomainDefInfo eiDomainDefInfo,
			List<EiDomainDefInfo> eiDomainDefInfoList) {
		super();
		this.eiDomainDefInfo = eiDomainDefInfo;
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * 资产域定义检索结果取得
	 * @return 资产域定义检索结果
	 */
	public EiDomainDefInfo getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}

	/**
	 * 资产域定义检索结果设定
	 * @param eiDomainDefInfo资产域定义检索结果
	 */
	public void setEiDomainDefInfo(EiDomainDefInfo eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}

	/**
	 * 资产域定义版本检索结果取得
	 * @return 资产域定义版本检索结果
	 */
	public List<EiDomainDefInfo> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * 资产域定义版本检索结果设定
	 * @param eiDomainDefInfoList资产域定义版本检索结果
	 */
	public void setEiDomainDefInfoList(List<EiDomainDefInfo> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}
	
	

}
