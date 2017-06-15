/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;

/**
  * 概述: 流程私有变量表接口
  * 功能描述: 流程私有变量表接口
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
public interface IG899Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPpiid();

	/**
	 * 流程变量定义ID取得
	 *
	 * @return 流程变量定义ID
	 */
	public String getPidid();

	/**
	 * 流程变量值ID取得
	 *
	 * @return 流程变量值ID
	 */
	public Integer getPiid();

	/**
	 * 流程参与者的角色ID取得
	 *
	 * @return 流程参与者的角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 流程参与者ID取得
	 * 
	 * @return 流程参与者ID
	 */
	public String getUserid();

	/**
	 * 值取得
	 *
	 * @return 值
	 */
	public String getPpivalue();

	/**
	 * 附件索引取得
	 *
	 * @return 附件索引
	 */
	public String getPpiattkey();
	
	public UserTB getUserTB();
	
	public RoleTB getRoleTB();
	
	/**
	 * 机构信息取得
	 * @return 机构信息
	 */
	public OrganizationTB getOrg();
	
	/**
	 * 备注取得
	 * @return ppicommect 备注
	 */
	public String getPpicommect();

}