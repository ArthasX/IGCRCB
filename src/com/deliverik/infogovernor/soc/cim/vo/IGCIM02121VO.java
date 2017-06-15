/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0111Info;

/**
 * 概述: 资产域定义信息检索结果ＶＯ
 * 功能描述: 资产域定义信息检索结果ＶＯ
 * 创建记录: 2011/04/26
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM02121VO extends BaseVO implements Serializable{
	
	/** 资产域定义检索结果 */
	protected SOC0111Info eiDomainDefInfo;
	
	/** 资产域定义版本检索结果 */
	protected List<SOC0111Info> eiDomainDefInfoList;
	
	
	/**
	 * 构造函数
	 * @param eiDomainDefInfo资产域定义检索结果
	 * @param eiDomainDefInfoList资产域定义版本检索结果
	 */
	public IGCIM02121VO(SOC0111Info eiDomainDefInfo,
			List<SOC0111Info> eiDomainDefInfoList) {
		super();
		this.eiDomainDefInfo = eiDomainDefInfo;
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * 资产域定义检索结果取得
	 * @return 资产域定义检索结果
	 */
	public SOC0111Info getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}

	/**
	 * 资产域定义检索结果设定
	 * @param eiDomainDefInfo资产域定义检索结果
	 */
	public void setEiDomainDefInfo(SOC0111Info eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}

	/**
	 * 资产域定义版本检索结果取得
	 * @return 资产域定义版本检索结果
	 */
	public List<SOC0111Info> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * 资产域定义版本检索结果设定
	 * @param eiDomainDefInfoList资产域定义版本检索结果
	 */
	public void setEiDomainDefInfoList(List<SOC0111Info> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}
	
	

}
