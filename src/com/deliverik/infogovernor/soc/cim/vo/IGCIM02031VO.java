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
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM02031VO extends BaseVO implements Serializable {

	/** 资产域定义检索结果 */
	protected List<SOC0111Info> soc0111List;

	/**
	 * 构造函数
	 * 
	 * @param eiDomainDefInfoList资产域定义检索结果
	 */
	public IGCIM02031VO(List<SOC0111Info> soc0111List) {
		this.soc0111List = soc0111List;
	}

	/**
	 * 资产域定义检索结果
	 * 
	 * @return 资产域定义检索结果
	 */
	public List<SOC0111Info> getSoc0111List() {
		return soc0111List;
	}

	/**
	 * 资产域定义检索结果
	 * 
	 * @param eiDomainDefInfoList资产域定义检索结果
	 */
	public void setSoc0111List(List<SOC0111Info> soc0111List) {
		this.soc0111List = soc0111List;
	}

}
