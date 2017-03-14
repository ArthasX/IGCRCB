/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0104Info;

/**
 * 概述: 审计任务信息添加后信息VO
 * 功能描述: 审计任务信息添加后信息VO
 * 创建记录: 2011/05/019
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM03051VO extends BaseVO implements Serializable {
	
	/**审计任务添加后信息*/
	protected SOC0104Info SOC0104Info;

	/**
	 * sOC0104Info取得
	 *
	 * @return sOC0104Info sOC0104Info
	 */
	public SOC0104Info getSOC0104Info() {
		return SOC0104Info;
	}

	/**
	 * sOC0104Info设定
	 *
	 * @param info sOC0104Info
	 */
	public void setSOC0104Info(SOC0104Info info) {
		SOC0104Info = info;
	}

	/**
	 * @param info
	 */
	public IGCIM03051VO(SOC0104Info info) {
		super();
		SOC0104Info = info;
	}
	
	

	
	

}
