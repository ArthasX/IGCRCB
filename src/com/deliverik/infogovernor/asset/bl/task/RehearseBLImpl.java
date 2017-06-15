/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.dao.RehearseDAO;




/**
  * 概述: 角色组织架构关系表业务逻辑实现
  * 功能描述: 角色组织架构关系表业务逻辑实现
  * 创建记录: 2014/06/16
  * 修改记录: 
  */
public class RehearseBLImpl extends BaseBLImpl implements RehearseBL {

	/** 角色组织架构关系表DAO接口 */
	protected RehearseDAO rehearseDAO;
	

	public void setRehearseDAO(RehearseDAO rehearseDAO) {
		this.rehearseDAO = rehearseDAO;
	}


}