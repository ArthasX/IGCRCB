/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 流程优先级配置Form
 * 功能描述：流程优先级配置Form
 * 创建记录：赵俊    2010/12/14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM1109Form extends BaseForm {
	
	/**优先级类型*/
	private String pprtype;
	
	/**优先级值*/
	private String pvalues[][];
	
	public String getPprtype() {
		
		return pprtype;
	}
	
	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}
	
	public String[][] getPvalues() {
		return pvalues;
	}
	
	public void setPvalues(String[][] pvalues) {
		this.pvalues = pvalues;
	}
	
}
