/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
  * 概述: 状态可分派机构定义表接口
  * 功能描述: 状态可分派机构定义表接口
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public interface IG299Info extends BaseModel {

	/**
	 * 状态配置机构主键主键取得
	 *
	 * @return 状态配置机构主键主键
	 */
	public String getPsodid();

	/**
	 * 状态节点ID取得
	 *
	 * @return psdid 状态节点ID
	 */
	public String getPsdid();

	/**
	 * 机构层次码取得
	 *
	 * @return orgsyscoding 机构层次码
	 */
	public String getOrgsyscoding();
	
	/**
	 * 机构名称取得
	 *
	 * @return orgname 机构名称
	 */
	public String getOrgname();
	
	/**
	 * 机构取得
	 * @return 机构
	 */
	public OrganizationTB getOrg();

}