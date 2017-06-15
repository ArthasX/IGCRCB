package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_测试_测试短信
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */
public class IGSYM1301Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String smsnumber;
	private String smscontent;

	public String getSmsnumber() {
		return smsnumber;
	}

	public void setSmsnumber(String smsnumber) {
		this.smsnumber = smsnumber;
	}

	public String getSmscontent() {
		return smscontent;
	}

	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}

}
