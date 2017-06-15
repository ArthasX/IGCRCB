/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程导入模板导出Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR1001Form extends BaseForm{

	/** 流程定义ID集合 */
	protected String [] pdids;

	/**
	 * 流程定义ID集合取得
	 * @return pdids 流程定义ID集合
	 */
	public String[] getPdids() {
		return pdids;
	}

	/**
	 * 流程定义ID集合设定
	 * @param pdids 流程定义ID集合
	 */
	public void setPdids(String[] pdids) {
		this.pdids = pdids;
	}
}
