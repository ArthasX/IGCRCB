/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.sym.form.IGSYM1301Form;
import com.deliverik.infogovernor.sym.form.IGSYM1302Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_测试_DTO
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM13DTO extends BaseDTO implements Serializable {

	private IGSYM1302Form igsym1302Form;
	
	private IGSYM1301Form igsym1301Form;
	
	private boolean enable;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public IGSYM1301Form getIgsym1301Form() {
		return igsym1301Form;
	}

	public void setIgsym1301Form(IGSYM1301Form igsym1301Form) {
		this.igsym1301Form = igsym1301Form;
	}

	public IGSYM1302Form getIgsym1302Form() {
		return igsym1302Form;
	}

	public void setIgsym1302Form(IGSYM1302Form igsym1302Form) {
		this.igsym1302Form = igsym1302Form;
	}

}
