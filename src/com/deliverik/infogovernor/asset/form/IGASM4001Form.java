/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计Form
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGASM4001Form extends BaseForm{
	/** 风险领域*/
	protected String riskly;

	/**
	 * 风险领域取得
	 * @return riskly 风险领域
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * 风险领域设定
	 * @param riskly 风险领域
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}
}
