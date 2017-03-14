/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 接待客人实体接口
 *
 */
public interface RecptionGuest extends BaseModel {


	/** 接待客人ID */
	public Integer getRgid();

	/** 接待工作ID */
	public Integer getRid();
	
	/** 接待客人姓名 */
	public String getRgname();
	
	/** 接待客人职务 */
	public String getRgpost();
	
	/** 接待客人单位 */
	public String getRgunit();
	
	/** 接待客人联系方式 */
	public String getRgtel();
	
	/** 登记日期 */
	public String getRgdate();

}
