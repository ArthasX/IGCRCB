/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 接待管理实体接口
 *
 */
public interface Recption extends BaseModel {

	/** 接待管理ID */
	public Integer getRid();
	
	/** 接待工作名称 */
	public String getRname();
	
	/** 主要申请部门层次码 */
	public String getRapporgid();
	
	/** 接待结束日期 */
	public String getRetime();
	
	/** 接待开始日期 */
	public String getRstime();
	
	/** 接待人数规模 */
	public String getRscale();
	
	/** 接待标准 */
	public String getRstandard();
	
	/** 其他参与部门名称 */
	public String getRpporg();
	
	/** 接待内容描述 */
	public String getRdescription();
	
	/** 登记日期 */
	public String getRdate();
	
	/** 状态（1进行中，2结束） */
	public String getRstatus();

	public OrganizationTB getOrganizationTB();
	
	/**住宿标准*/
	public String getRlodgestandard();
	
	/**住宿费用*/
	public BigDecimal getRlodgecost();

}
