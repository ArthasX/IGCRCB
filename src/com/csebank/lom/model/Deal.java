/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 功能：外出就餐登记实体类
 * 
 * 作者：唐晓娜 mail to tangxiaona@deliverik.com
 *
 */

public interface Deal extends BaseModel {
	/** 外出就餐管理ID */
	public Integer getRid();
	public String getRapporgid();
	
   /**
    * 
    * 主要申请部门
    */
	public String getDeptName();
	/**
	 * 
	 * 申请时间
	 */
	public String getDealTime();
	/**
	 * 
	 * 申请人数规模
	 */
	public String getDealScale();
	/**
	 * 
	 * 申请金额
	 */
	public BigDecimal getDealCash();
	/**
	 * 
	 * 发票编号
	 */
	public String getInvoiceNumber();
	/**
	 * 
	 * 其他参与部门人
	 */
	public String getOtherJoiner();
	/**
	 * 
	 * 内容描述
	 */
	public String getDealDesc();
	public OrganizationTB getOrganizationTB();

}
