/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 域CI信息检索结果ＶＯ
 * 功能描述: 域CI信息检索结果ＶＯ
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20131VO extends BaseVO implements Serializable{
	
	/** 域明细信息 */
	protected List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList;
	
	protected List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList;
	
	protected String eilabel;


	
	/**
	 * 域明细信息取得
	 * @return 域明细信息
	 */
	public List<EiDomainDetailMaxVWInfo> getEiDomainDetailVWInfoList() {
		return eiDomainDetailVWInfoList;
	}

	/**
	 * 域明细信息设定
	 * @param eiDomainDetailInfoList域明细信息
	 */
	public void setEiDomainDetailVWInfoList(
			List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList) {
		this.eiDomainDetailVWInfoList = eiDomainDetailVWInfoList;
	}


	public List<EiDomainDetailCIInfo> getEiDomainDetailCIInfoList() {
		return eiDomainDetailCIInfoList;
	}

	public void setEiDomainDetailCIInfoList(
			List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList) {
		this.eiDomainDetailCIInfoList = eiDomainDetailCIInfoList;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

}
