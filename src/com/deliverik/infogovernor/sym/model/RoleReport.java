/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.sym.model.entity.ReportFileDefinitionTB;

 
/**
 * 报表授权信息接口
 * 
 */

public interface RoleReport  extends BaseModel {

	/**
	 * 主键取得
	 * @return 主键
	 */
	public abstract Integer getRrid();

	/**
	 * 角色ID
	 * @return 
	 */
	public abstract Integer getRoleid();
	
	/**
	 * 报表ID
	 * @return 主键
	 */
	public abstract Integer getRfdid();
	
	public abstract String getRrperm();
	
	public abstract String getRrdesc();
	
	public ReportFileDefinitionTB getReportFileDefinitionTB();
	

}